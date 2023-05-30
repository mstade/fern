package api

import (
	json "encoding/json"
	fmt "fmt"
)

type NestedUnion struct {
	Type string
	Docs string
	Raw  string
	One  *ExampleType
}

func (x *NestedUnion) UnmarshalJSON(data []byte) error {
	var unmarshaler struct {
		Type string `json:"type"`
		Docs string `json:"docs"`
		Raw  string `json:"raw"`
	}
	if err := json.Unmarshal(data, &unmarshaler); err != nil {
		return err
	}
	x.Type = unmarshaler.Type
	x.Docs = unmarshaler.Docs
	x.Raw = unmarshaler.Raw
	switch unmarshaler.Type {
	case "one":
		value := new(ExampleType)
		if err := json.Unmarshal(data, &value); err != nil {
			return err
		}
		x.One = value
	}
	return nil
}

func (x NestedUnion) MarshalJSON() ([]byte, error) {
	switch x.Type {
	default:
		return nil, fmt.Errorf("invalid type %s in %T", x.Type, x)
	case "one":
		var marshaler = struct {
			Type string `json:"type"`
			Docs string `json:"docs"`
			Raw  string `json:"raw"`
			*ExampleType
		}{
			Type:        x.Type,
			Docs:        x.Docs,
			Raw:         x.Raw,
			ExampleType: x.One,
		}
		return json.Marshal(marshaler)
	}
}

type NestedUnionVisitor interface {
	VisitOne(*ExampleType) error
}

func (x *NestedUnion) Accept(v NestedUnionVisitor) error {
	switch x.Type {
	default:
		return fmt.Errorf("invalid type %s in %T", x.Type, x)
	case "one":
		return v.VisitOne(x.One)
	}
}
