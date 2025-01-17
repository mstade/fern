// This file was auto-generated by Fern from our API Definition.

package nullable

import (
	json "encoding/json"
	fmt "fmt"
	internal "github.com/nullable/fern/internal"
	time "time"
)

type CreateUserRequest struct {
	Username string    `json:"username" url:"-"`
	Tags     []string  `json:"tags,omitempty" url:"-"`
	Metadata *Metadata `json:"metadata,omitempty" url:"-"`
	Avatar   *string   `json:"avatar,omitempty" url:"-"`
}

type DeleteUserRequest struct {
	// The user to delete.
	Username *string `json:"username,omitempty" url:"-"`
}

type GetUsersRequest struct {
	Usernames []*string `json:"-" url:"usernames,omitempty"`
	Avatar    *string   `json:"-" url:"avatar,omitempty"`
	Activated []*bool   `json:"-" url:"activated,omitempty"`
	Tags      []*string `json:"-" url:"tags,omitempty"`
	Extra     *bool     `json:"-" url:"extra,omitempty"`
}

type Metadata struct {
	CreatedAt time.Time `json:"createdAt" url:"createdAt"`
	UpdatedAt time.Time `json:"updatedAt" url:"updatedAt"`
	Avatar    *string   `json:"avatar,omitempty" url:"avatar,omitempty"`
	Activated *bool     `json:"activated,omitempty" url:"activated,omitempty"`

	extraProperties map[string]interface{}
	rawJSON         json.RawMessage
}

func (m *Metadata) GetCreatedAt() time.Time {
	if m == nil {
		return time.Time{}
	}
	return m.CreatedAt
}

func (m *Metadata) GetUpdatedAt() time.Time {
	if m == nil {
		return time.Time{}
	}
	return m.UpdatedAt
}

func (m *Metadata) GetAvatar() *string {
	if m == nil {
		return nil
	}
	return m.Avatar
}

func (m *Metadata) GetActivated() *bool {
	if m == nil {
		return nil
	}
	return m.Activated
}

func (m *Metadata) GetExtraProperties() map[string]interface{} {
	return m.extraProperties
}

func (m *Metadata) UnmarshalJSON(data []byte) error {
	type embed Metadata
	var unmarshaler = struct {
		embed
		CreatedAt *internal.DateTime `json:"createdAt"`
		UpdatedAt *internal.DateTime `json:"updatedAt"`
	}{
		embed: embed(*m),
	}
	if err := json.Unmarshal(data, &unmarshaler); err != nil {
		return err
	}
	*m = Metadata(unmarshaler.embed)
	m.CreatedAt = unmarshaler.CreatedAt.Time()
	m.UpdatedAt = unmarshaler.UpdatedAt.Time()
	extraProperties, err := internal.ExtractExtraProperties(data, *m)
	if err != nil {
		return err
	}
	m.extraProperties = extraProperties
	m.rawJSON = json.RawMessage(data)
	return nil
}

func (m *Metadata) MarshalJSON() ([]byte, error) {
	type embed Metadata
	var marshaler = struct {
		embed
		CreatedAt *internal.DateTime `json:"createdAt"`
		UpdatedAt *internal.DateTime `json:"updatedAt"`
	}{
		embed:     embed(*m),
		CreatedAt: internal.NewDateTime(m.CreatedAt),
		UpdatedAt: internal.NewDateTime(m.UpdatedAt),
	}
	return json.Marshal(marshaler)
}

func (m *Metadata) String() string {
	if len(m.rawJSON) > 0 {
		if value, err := internal.StringifyJSON(m.rawJSON); err == nil {
			return value
		}
	}
	if value, err := internal.StringifyJSON(m); err == nil {
		return value
	}
	return fmt.Sprintf("%#v", m)
}

type User struct {
	Name     string    `json:"name" url:"name"`
	Tags     []string  `json:"tags,omitempty" url:"tags,omitempty"`
	Metadata *Metadata `json:"metadata,omitempty" url:"metadata,omitempty"`

	extraProperties map[string]interface{}
	rawJSON         json.RawMessage
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

func (u *User) GetMetadata() *Metadata {
	if u == nil {
		return nil
	}
	return u.Metadata
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
	u.rawJSON = json.RawMessage(data)
	return nil
}

func (u *User) String() string {
	if len(u.rawJSON) > 0 {
		if value, err := internal.StringifyJSON(u.rawJSON); err == nil {
			return value
		}
	}
	if value, err := internal.StringifyJSON(u); err == nil {
		return value
	}
	return fmt.Sprintf("%#v", u)
}
