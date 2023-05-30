package ir

import (
	json "encoding/json"
	fmt "fmt"
)

type AuthScheme struct {
	Type   string
	Bearer *BearerAuthScheme
	Basic  *BasicAuthScheme
	Header *HeaderAuthScheme
}

func (x *AuthScheme) UnmarshalJSON(data []byte) error {
	var unmarshaler struct {
		Type string `json:"_type"`
	}
	if err := json.Unmarshal(data, &unmarshaler); err != nil {
		return err
	}
	x.Type = unmarshaler.Type
	switch unmarshaler.Type {
	case "bearer":
		value := new(BearerAuthScheme)
		if err := json.Unmarshal(data, &value); err != nil {
			return err
		}
		x.Bearer = value
	case "basic":
		value := new(BasicAuthScheme)
		if err := json.Unmarshal(data, &value); err != nil {
			return err
		}
		x.Basic = value
	case "header":
		value := new(HeaderAuthScheme)
		if err := json.Unmarshal(data, &value); err != nil {
			return err
		}
		x.Header = value
	}
	return nil
}

func (x AuthScheme) MarshalJSON() ([]byte, error) {
	switch x.Type {
	default:
		return nil, fmt.Errorf("invalid type %s in %T", x.Type, x)
	case "bearer":
		var marshaler = struct {
			Type string `json:"_type"`
			*BearerAuthScheme
		}{
			Type:             x.Type,
			BearerAuthScheme: x.Bearer,
		}
		return json.Marshal(marshaler)
	case "basic":
		var marshaler = struct {
			Type string `json:"_type"`
			*BasicAuthScheme
		}{
			Type:            x.Type,
			BasicAuthScheme: x.Basic,
		}
		return json.Marshal(marshaler)
	case "header":
		var marshaler = struct {
			Type string `json:"_type"`
			*HeaderAuthScheme
		}{
			Type:             x.Type,
			HeaderAuthScheme: x.Header,
		}
		return json.Marshal(marshaler)
	}
}

type AuthSchemeVisitor interface {
	VisitBearer(*BearerAuthScheme) error
	VisitBasic(*BasicAuthScheme) error
	VisitHeader(*HeaderAuthScheme) error
}

func (x *AuthScheme) Accept(v AuthSchemeVisitor) error {
	switch x.Type {
	default:
		return fmt.Errorf("invalid type %s in %T", x.Type, x)
	case "bearer":
		return v.VisitBearer(x.Bearer)
	case "basic":
		return v.VisitBasic(x.Basic)
	case "header":
		return v.VisitHeader(x.Header)
	}
}
