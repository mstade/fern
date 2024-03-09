// This file was auto-generated by Fern from our API Definition.

package undiscriminated

import (
	json "encoding/json"
	fmt "fmt"
)

// Several different types are accepted.
type MyUnion struct {
	String          string
	StringList      []string
	Integer         int
	IntegerList     []int
	IntegerListList [][]int
}

func (m *MyUnion) UnmarshalJSON(data []byte) error {
	var valueString string
	if err := json.Unmarshal(data, &valueString); err == nil {
		m.String = valueString
		return nil
	}
	var valueStringList []string
	if err := json.Unmarshal(data, &valueStringList); err == nil {
		m.StringList = valueStringList
		return nil
	}
	var valueInteger int
	if err := json.Unmarshal(data, &valueInteger); err == nil {
		m.Integer = valueInteger
		return nil
	}
	var valueIntegerList []int
	if err := json.Unmarshal(data, &valueIntegerList); err == nil {
		m.IntegerList = valueIntegerList
		return nil
	}
	var valueIntegerListList [][]int
	if err := json.Unmarshal(data, &valueIntegerListList); err == nil {
		m.IntegerListList = valueIntegerListList
		return nil
	}
	return fmt.Errorf("%s cannot be deserialized as a %T", data, m)
}

func (m MyUnion) MarshalJSON() ([]byte, error) {
	if m.String != "" {
		return json.Marshal(m.String)
	}
	if m.StringList != nil {
		return json.Marshal(m.StringList)
	}
	if m.Integer != 0 {
		return json.Marshal(m.Integer)
	}
	if m.IntegerList != nil {
		return json.Marshal(m.IntegerList)
	}
	if m.IntegerListList != nil {
		return json.Marshal(m.IntegerListList)
	}
	return nil, fmt.Errorf("type %T does not include a non-empty union type", m)
}

type MyUnionVisitor interface {
	VisitString(string) error
	VisitStringList([]string) error
	VisitInteger(int) error
	VisitIntegerList([]int) error
	VisitIntegerListList([][]int) error
}

func (m *MyUnion) Accept(visitor MyUnionVisitor) error {
	if m.String != "" {
		return visitor.VisitString(m.String)
	}
	if m.StringList != nil {
		return visitor.VisitStringList(m.StringList)
	}
	if m.Integer != 0 {
		return visitor.VisitInteger(m.Integer)
	}
	if m.IntegerList != nil {
		return visitor.VisitIntegerList(m.IntegerList)
	}
	if m.IntegerListList != nil {
		return visitor.VisitIntegerListList(m.IntegerListList)
	}
	return fmt.Errorf("type %T does not include a non-empty union type", m)
}