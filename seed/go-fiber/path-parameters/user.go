// This file was auto-generated by Fern from our API Definition.

package pathparameters

import (
	json "encoding/json"
	fmt "fmt"
	internal "github.com/path-parameters/fern/internal"
)

type SearchUsersRequest struct {
	Limit *int `query:"limit"`
}

type User struct {
	Name string   `json:"name" url:"name"`
	Tags []string `json:"tags,omitempty" url:"tags,omitempty"`

	extraProperties map[string]interface{}
}

func (u *User) GetName() string {
	if u == nil {
		return ""
	}
	return u.Name
}

func (u *User) GetTags() []string {
	if u == nil {
		return nil
	}
	return u.Tags
}

func (u *User) GetExtraProperties() map[string]interface{} {
	return u.extraProperties
}

func (u *User) UnmarshalJSON(data []byte) error {
	type unmarshaler User
	var value unmarshaler
	if err := json.Unmarshal(data, &value); err != nil {
		return err
	}
	*u = User(value)
	extraProperties, err := internal.ExtractExtraProperties(data, *u)
	if err != nil {
		return err
	}
	u.extraProperties = extraProperties
	return nil
}

func (u *User) String() string {
	if value, err := internal.StringifyJSON(u); err == nil {
		return value
	}
	return fmt.Sprintf("%#v", u)
}

type UpdateUserRequest struct {
	Body *User `json:"-" url:"-"`
}

func (u *UpdateUserRequest) UnmarshalJSON(data []byte) error {
	body := new(User)
	if err := json.Unmarshal(data, &body); err != nil {
		return err
	}
	u.Body = body
	return nil
}

func (u *UpdateUserRequest) MarshalJSON() ([]byte, error) {
	return json.Marshal(u.Body)
}
