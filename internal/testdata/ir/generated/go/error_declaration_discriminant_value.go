package ir

import (
	json "encoding/json"
	fmt "fmt"
)

type ErrorDeclarationDiscriminantValue struct {
	Type       string
	Property   *NameAndWireValue
	StatusCode any
}

func (x *ErrorDeclarationDiscriminantValue) UnmarshalJSON(data []byte) error {
	var unmarshaler struct {
		Type string `json:"type"`
	}
	if err := json.Unmarshal(data, &unmarshaler); err != nil {
		return err
	}
	x.Type = unmarshaler.Type
	switch unmarshaler.Type {
	case "property":
		value := new(NameAndWireValue)
		if err := json.Unmarshal(data, &value); err != nil {
			return err
		}
		x.Property = value
	case "statusCode":
		value := make(map[string]any)
		if err := json.Unmarshal(data, &value); err != nil {
			return err
		}
		x.StatusCode = value
	}
	return nil
}

func (x ErrorDeclarationDiscriminantValue) MarshalJSON() ([]byte, error) {
	switch x.Type {
	default:
		return nil, fmt.Errorf("invalid type %s in %T", x.Type, x)
	case "property":
		var marshaler = struct {
			Type string `json:"type"`
			*NameAndWireValue
		}{
			Type:             x.Type,
			NameAndWireValue: x.Property,
		}
		return json.Marshal(marshaler)
	case "statusCode":
		var marshaler = struct {
			Type       string `json:"type"`
			StatusCode any    `json:"statusCode"`
		}{
			Type:       x.Type,
			StatusCode: x.StatusCode,
		}
		return json.Marshal(marshaler)
	}
}

type ErrorDeclarationDiscriminantValueVisitor interface {
	VisitProperty(*NameAndWireValue) error
	VisitStatusCode(any) error
}

func (x *ErrorDeclarationDiscriminantValue) Accept(v ErrorDeclarationDiscriminantValueVisitor) error {
	switch x.Type {
	default:
		return fmt.Errorf("invalid type %s in %T", x.Type, x)
	case "property":
		return v.VisitProperty(x.Property)
	case "statusCode":
		return v.VisitStatusCode(x.StatusCode)
	}
}
