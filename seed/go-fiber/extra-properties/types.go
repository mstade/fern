// This file was auto-generated by Fern from our API Definition.

package extraproperties

import (
	json "encoding/json"
	fmt "fmt"
	internal "github.com/extra-properties/fern/internal"
)

type Failure struct {
	status string

	ExtraProperties map[string]interface{} `json:"-" url:"-"`
}

func (f *Failure) Status() string {
	return f.status
}

func (f *Failure) GetExtraProperties() map[string]interface{} {
	return f.ExtraProperties
}

func (f *Failure) UnmarshalJSON(data []byte) error {
	type embed Failure
	var unmarshaler = struct {
		embed
		Status string `json:"status"`
	}{
		embed: embed(*f),
	}
	if err := json.Unmarshal(data, &unmarshaler); err != nil {
		return err
	}
	*f = Failure(unmarshaler.embed)
	if unmarshaler.Status != "failure" {
		return fmt.Errorf("unexpected value for literal on type %T; expected %v got %v", f, "failure", unmarshaler.Status)
	}
	f.status = unmarshaler.Status

	extraProperties, err := internal.ExtractExtraProperties(data, *f, "status")
	if err != nil {
		return err
	}
	f.ExtraProperties = extraProperties

	return nil
}

func (f *Failure) MarshalJSON() ([]byte, error) {
	type embed Failure
	var marshaler = struct {
		embed
		Status string `json:"status"`
	}{
		embed:  embed(*f),
		Status: "failure",
	}
	return internal.MarshalJSONWithExtraProperties(marshaler, f.ExtraProperties)
}

func (f *Failure) String() string {
	if value, err := internal.StringifyJSON(f); err == nil {
		return value
	}
	return fmt.Sprintf("%#v", f)
}
