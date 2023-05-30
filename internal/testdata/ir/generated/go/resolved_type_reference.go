package ir

import (
	json "encoding/json"
	fmt "fmt"
)

type ResolvedTypeReference struct {
	Type      string
	Container *ContainerType
	Named     *ResolvedNamedType
	Primitive PrimitiveType
	Unknown   any
}

func (x *ResolvedTypeReference) UnmarshalJSON(data []byte) error {
	var unmarshaler struct {
		Type string `json:"_type"`
	}
	if err := json.Unmarshal(data, &unmarshaler); err != nil {
		return err
	}
	x.Type = unmarshaler.Type
	switch unmarshaler.Type {
	case "container":
		var valueUnmarshaler struct {
			Container *ContainerType `json:"container"`
		}
		if err := json.Unmarshal(data, &valueUnmarshaler); err != nil {
			return err
		}
		x.Container = valueUnmarshaler.Container
	case "named":
		value := new(ResolvedNamedType)
		if err := json.Unmarshal(data, &value); err != nil {
			return err
		}
		x.Named = value
	case "primitive":
		var valueUnmarshaler struct {
			Primitive PrimitiveType `json:"primitive"`
		}
		if err := json.Unmarshal(data, &valueUnmarshaler); err != nil {
			return err
		}
		x.Primitive = valueUnmarshaler.Primitive
	case "unknown":
		value := make(map[string]any)
		if err := json.Unmarshal(data, &value); err != nil {
			return err
		}
		x.Unknown = value
	}
	return nil
}

func (x ResolvedTypeReference) MarshalJSON() ([]byte, error) {
	switch x.Type {
	default:
		return nil, fmt.Errorf("invalid type %s in %T", x.Type, x)
	case "container":
		var marshaler = struct {
			Type      string         `json:"_type"`
			Container *ContainerType `json:"container"`
		}{
			Type:      x.Type,
			Container: x.Container,
		}
		return json.Marshal(marshaler)
	case "named":
		var marshaler = struct {
			Type string `json:"_type"`
			*ResolvedNamedType
		}{
			Type:              x.Type,
			ResolvedNamedType: x.Named,
		}
		return json.Marshal(marshaler)
	case "primitive":
		var marshaler = struct {
			Type      string        `json:"_type"`
			Primitive PrimitiveType `json:"primitive"`
		}{
			Type:      x.Type,
			Primitive: x.Primitive,
		}
		return json.Marshal(marshaler)
	case "unknown":
		var marshaler = struct {
			Type    string `json:"_type"`
			Unknown any    `json:"unknown"`
		}{
			Type:    x.Type,
			Unknown: x.Unknown,
		}
		return json.Marshal(marshaler)
	}
}

type ResolvedTypeReferenceVisitor interface {
	VisitContainer(*ContainerType) error
	VisitNamed(*ResolvedNamedType) error
	VisitPrimitive(PrimitiveType) error
	VisitUnknown(any) error
}

func (x *ResolvedTypeReference) Accept(v ResolvedTypeReferenceVisitor) error {
	switch x.Type {
	default:
		return fmt.Errorf("invalid type %s in %T", x.Type, x)
	case "container":
		return v.VisitContainer(x.Container)
	case "named":
		return v.VisitNamed(x.Named)
	case "primitive":
		return v.VisitPrimitive(x.Primitive)
	case "unknown":
		return v.VisitUnknown(x.Unknown)
	}
}
