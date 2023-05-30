package ir

import (
	json "encoding/json"
	fmt "fmt"
)

type ContainerType struct {
	Type     string
	List     *TypeReference
	Map      *MapType
	Optional *TypeReference
	Set      *TypeReference
	Literal  *Literal
}

func (x *ContainerType) UnmarshalJSON(data []byte) error {
	var unmarshaler struct {
		Type string `json:"_type"`
	}
	if err := json.Unmarshal(data, &unmarshaler); err != nil {
		return err
	}
	x.Type = unmarshaler.Type
	switch unmarshaler.Type {
	case "list":
		var valueUnmarshaler struct {
			List *TypeReference `json:"list"`
		}
		if err := json.Unmarshal(data, &valueUnmarshaler); err != nil {
			return err
		}
		x.List = valueUnmarshaler.List
	case "map":
		value := new(MapType)
		if err := json.Unmarshal(data, &value); err != nil {
			return err
		}
		x.Map = value
	case "optional":
		var valueUnmarshaler struct {
			Optional *TypeReference `json:"optional"`
		}
		if err := json.Unmarshal(data, &valueUnmarshaler); err != nil {
			return err
		}
		x.Optional = valueUnmarshaler.Optional
	case "set":
		var valueUnmarshaler struct {
			Set *TypeReference `json:"set"`
		}
		if err := json.Unmarshal(data, &valueUnmarshaler); err != nil {
			return err
		}
		x.Set = valueUnmarshaler.Set
	case "literal":
		var valueUnmarshaler struct {
			Literal *Literal `json:"literal"`
		}
		if err := json.Unmarshal(data, &valueUnmarshaler); err != nil {
			return err
		}
		x.Literal = valueUnmarshaler.Literal
	}
	return nil
}

func (x ContainerType) MarshalJSON() ([]byte, error) {
	switch x.Type {
	default:
		return nil, fmt.Errorf("invalid type %s in %T", x.Type, x)
	case "list":
		var marshaler = struct {
			Type string         `json:"_type"`
			List *TypeReference `json:"list"`
		}{
			Type: x.Type,
			List: x.List,
		}
		return json.Marshal(marshaler)
	case "map":
		var marshaler = struct {
			Type string `json:"_type"`
			*MapType
		}{
			Type:    x.Type,
			MapType: x.Map,
		}
		return json.Marshal(marshaler)
	case "optional":
		var marshaler = struct {
			Type     string         `json:"_type"`
			Optional *TypeReference `json:"optional"`
		}{
			Type:     x.Type,
			Optional: x.Optional,
		}
		return json.Marshal(marshaler)
	case "set":
		var marshaler = struct {
			Type string         `json:"_type"`
			Set  *TypeReference `json:"set"`
		}{
			Type: x.Type,
			Set:  x.Set,
		}
		return json.Marshal(marshaler)
	case "literal":
		var marshaler = struct {
			Type    string   `json:"_type"`
			Literal *Literal `json:"literal"`
		}{
			Type:    x.Type,
			Literal: x.Literal,
		}
		return json.Marshal(marshaler)
	}
}

type ContainerTypeVisitor interface {
	VisitList(*TypeReference) error
	VisitMap(*MapType) error
	VisitOptional(*TypeReference) error
	VisitSet(*TypeReference) error
	VisitLiteral(*Literal) error
}

func (x *ContainerType) Accept(v ContainerTypeVisitor) error {
	switch x.Type {
	default:
		return fmt.Errorf("invalid type %s in %T", x.Type, x)
	case "list":
		return v.VisitList(x.List)
	case "map":
		return v.VisitMap(x.Map)
	case "optional":
		return v.VisitOptional(x.Optional)
	case "set":
		return v.VisitSet(x.Set)
	case "literal":
		return v.VisitLiteral(x.Literal)
	}
}
