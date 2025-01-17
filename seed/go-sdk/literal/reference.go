// This file was auto-generated by Fern from our API Definition.

package literal

import (
	json "encoding/json"
	fmt "fmt"
	internal "github.com/literal/fern/internal"
)

type ContainerObject struct {
	NestedObjects []*NestedObjectWithLiterals `json:"nestedObjects,omitempty" url:"nestedObjects,omitempty"`

	extraProperties map[string]interface{}
	rawJSON         json.RawMessage
}

func (c *ContainerObject) GetNestedObjects() []*NestedObjectWithLiterals {
	if c == nil {
		return nil
	}
	return c.NestedObjects
}

func (c *ContainerObject) GetExtraProperties() map[string]interface{} {
	return c.extraProperties
}

func (c *ContainerObject) UnmarshalJSON(data []byte) error {
	type unmarshaler ContainerObject
	var value unmarshaler
	if err := json.Unmarshal(data, &value); err != nil {
		return err
	}
	*c = ContainerObject(value)
	extraProperties, err := internal.ExtractExtraProperties(data, *c)
	if err != nil {
		return err
	}
	c.extraProperties = extraProperties
	c.rawJSON = json.RawMessage(data)
	return nil
}

func (c *ContainerObject) String() string {
	if len(c.rawJSON) > 0 {
		if value, err := internal.StringifyJSON(c.rawJSON); err == nil {
			return value
		}
	}
	if value, err := internal.StringifyJSON(c); err == nil {
		return value
	}
	return fmt.Sprintf("%#v", c)
}

type NestedObjectWithLiterals struct {
	StrProp  string `json:"strProp" url:"strProp"`
	literal1 string
	literal2 string

	extraProperties map[string]interface{}
	rawJSON         json.RawMessage
}

func (n *NestedObjectWithLiterals) GetStrProp() string {
	if n == nil {
		return ""
	}
	return n.StrProp
}

func (n *NestedObjectWithLiterals) Literal1() string {
	return n.literal1
}

func (n *NestedObjectWithLiterals) Literal2() string {
	return n.literal2
}

func (n *NestedObjectWithLiterals) GetExtraProperties() map[string]interface{} {
	return n.extraProperties
}

func (n *NestedObjectWithLiterals) UnmarshalJSON(data []byte) error {
	type embed NestedObjectWithLiterals
	var unmarshaler = struct {
		embed
		Literal1 string `json:"literal1"`
		Literal2 string `json:"literal2"`
	}{
		embed: embed(*n),
	}
	if err := json.Unmarshal(data, &unmarshaler); err != nil {
		return err
	}
	*n = NestedObjectWithLiterals(unmarshaler.embed)
	if unmarshaler.Literal1 != "literal1" {
		return fmt.Errorf("unexpected value for literal on type %T; expected %v got %v", n, "literal1", unmarshaler.Literal1)
	}
	n.literal1 = unmarshaler.Literal1
	if unmarshaler.Literal2 != "literal2" {
		return fmt.Errorf("unexpected value for literal on type %T; expected %v got %v", n, "literal2", unmarshaler.Literal2)
	}
	n.literal2 = unmarshaler.Literal2
	extraProperties, err := internal.ExtractExtraProperties(data, *n, "literal1", "literal2")
	if err != nil {
		return err
	}
	n.extraProperties = extraProperties
	n.rawJSON = json.RawMessage(data)
	return nil
}

func (n *NestedObjectWithLiterals) MarshalJSON() ([]byte, error) {
	type embed NestedObjectWithLiterals
	var marshaler = struct {
		embed
		Literal1 string `json:"literal1"`
		Literal2 string `json:"literal2"`
	}{
		embed:    embed(*n),
		Literal1: "literal1",
		Literal2: "literal2",
	}
	return json.Marshal(marshaler)
}

func (n *NestedObjectWithLiterals) String() string {
	if len(n.rawJSON) > 0 {
		if value, err := internal.StringifyJSON(n.rawJSON); err == nil {
			return value
		}
	}
	if value, err := internal.StringifyJSON(n); err == nil {
		return value
	}
	return fmt.Sprintf("%#v", n)
}

type SendRequest struct {
	Query           string           `json:"query" url:"query"`
	Context         SomeLiteral      `json:"context,omitempty" url:"context,omitempty"`
	MaybeContext    *SomeLiteral     `json:"maybeContext,omitempty" url:"maybeContext,omitempty"`
	ContainerObject *ContainerObject `json:"containerObject,omitempty" url:"containerObject,omitempty"`
	prompt          string
	stream          bool
	ending          string

	extraProperties map[string]interface{}
	rawJSON         json.RawMessage
}

func (s *SendRequest) GetQuery() string {
	if s == nil {
		return ""
	}
	return s.Query
}

func (s *SendRequest) GetContainerObject() *ContainerObject {
	if s == nil {
		return nil
	}
	return s.ContainerObject
}

func (s *SendRequest) Prompt() string {
	return s.prompt
}

func (s *SendRequest) Stream() bool {
	return s.stream
}

func (s *SendRequest) Ending() string {
	return s.ending
}

func (s *SendRequest) GetExtraProperties() map[string]interface{} {
	return s.extraProperties
}

func (s *SendRequest) UnmarshalJSON(data []byte) error {
	type embed SendRequest
	var unmarshaler = struct {
		embed
		Prompt string `json:"prompt"`
		Stream bool   `json:"stream"`
		Ending string `json:"ending"`
	}{
		embed: embed(*s),
	}
	if err := json.Unmarshal(data, &unmarshaler); err != nil {
		return err
	}
	*s = SendRequest(unmarshaler.embed)
	if unmarshaler.Prompt != "You are a helpful assistant" {
		return fmt.Errorf("unexpected value for literal on type %T; expected %v got %v", s, "You are a helpful assistant", unmarshaler.Prompt)
	}
	s.prompt = unmarshaler.Prompt
	if unmarshaler.Stream != false {
		return fmt.Errorf("unexpected value for literal on type %T; expected %v got %v", s, false, unmarshaler.Stream)
	}
	s.stream = unmarshaler.Stream
	if unmarshaler.Ending != "$ending" {
		return fmt.Errorf("unexpected value for literal on type %T; expected %v got %v", s, "$ending", unmarshaler.Ending)
	}
	s.ending = unmarshaler.Ending
	extraProperties, err := internal.ExtractExtraProperties(data, *s, "prompt", "stream", "ending")
	if err != nil {
		return err
	}
	s.extraProperties = extraProperties
	s.rawJSON = json.RawMessage(data)
	return nil
}

func (s *SendRequest) MarshalJSON() ([]byte, error) {
	type embed SendRequest
	var marshaler = struct {
		embed
		Prompt string `json:"prompt"`
		Stream bool   `json:"stream"`
		Ending string `json:"ending"`
	}{
		embed:  embed(*s),
		Prompt: "You are a helpful assistant",
		Stream: false,
		Ending: "$ending",
	}
	return json.Marshal(marshaler)
}

func (s *SendRequest) String() string {
	if len(s.rawJSON) > 0 {
		if value, err := internal.StringifyJSON(s.rawJSON); err == nil {
			return value
		}
	}
	if value, err := internal.StringifyJSON(s); err == nil {
		return value
	}
	return fmt.Sprintf("%#v", s)
}

type SomeLiteral = string
