package ir

import (
	json "encoding/json"
	fmt "fmt"
)

type Literal struct {
	Type   string
	String string
}

func (x *Literal) UnmarshalJSON(data []byte) error {
	var unmarshaler struct {
		Type string `json:"type"`
	}
	if err := json.Unmarshal(data, &unmarshaler); err != nil {
		return err
	}
	x.Type = unmarshaler.Type
	switch unmarshaler.Type {
	case "string":
		var valueUnmarshaler struct {
			String string `json:"string"`
		}
		if err := json.Unmarshal(data, &valueUnmarshaler); err != nil {
			return err
		}
		x.String = valueUnmarshaler.String
	}
	return nil
}

func (x Literal) MarshalJSON() ([]byte, error) {
	switch x.Type {
	default:
		return nil, fmt.Errorf("invalid type %s in %T", x.Type, x)
	case "string":
		var marshaler = struct {
			Type   string `json:"type"`
			String string `json:"string"`
		}{
			Type:   x.Type,
			String: x.String,
		}
		return json.Marshal(marshaler)
	}
}

type LiteralVisitor interface {
	VisitString(string) error
}

func (x *Literal) Accept(v LiteralVisitor) error {
	switch x.Type {
	default:
		return fmt.Errorf("invalid type %s in %T", x.Type, x)
	case "string":
		return v.VisitString(x.String)
	}
}
