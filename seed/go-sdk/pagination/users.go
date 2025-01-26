// This file was auto-generated by Fern from our API Definition.

package pagination

import (
	json "encoding/json"
	fmt "fmt"
	uuid "github.com/google/uuid"
	internal "github.com/pagination/fern/internal"
)

type ListUsernamesRequest struct {
	// The cursor used for pagination in order to fetch
	// the next page of results.
	StartingAfter *string `json:"-" url:"starting_after,omitempty"`
}

type ListUsersBodyCursorPaginationRequest struct {
	// The object that contains the cursor used for pagination
	// in order to fetch the next page of results.
	Pagination *WithCursor `json:"pagination,omitempty" url:"-"`
}

type ListUsersBodyOffsetPaginationRequest struct {
	// The object that contains the offset used for pagination
	// in order to fetch the next page of results.
	Pagination *WithPage `json:"pagination,omitempty" url:"-"`
}

type ListUsersCursorPaginationRequest struct {
	// Defaults to first page
	Page *int `json:"-" url:"page,omitempty"`
	// Defaults to per page
	PerPage *int   `json:"-" url:"per_page,omitempty"`
	Order   *Order `json:"-" url:"order,omitempty"`
	// The cursor used for pagination in order to fetch
	// the next page of results.
	StartingAfter *string `json:"-" url:"starting_after,omitempty"`
}

type ListUsersDoubleOffsetPaginationRequest struct {
	// Defaults to first page
	Page *float64 `json:"-" url:"page,omitempty"`
	// Defaults to per page
	PerPage *float64 `json:"-" url:"per_page,omitempty"`
	Order   *Order   `json:"-" url:"order,omitempty"`
	// The cursor used for pagination in order to fetch
	// the next page of results.
	StartingAfter *string `json:"-" url:"starting_after,omitempty"`
}

type ListUsersExtendedRequest struct {
	Cursor *uuid.UUID `json:"-" url:"cursor,omitempty"`
}

type ListUsersExtendedRequestForOptionalData struct {
	Cursor *uuid.UUID `json:"-" url:"cursor,omitempty"`
}

type ListWithGlobalConfigRequest struct {
	Offset *int `json:"-" url:"offset,omitempty"`
}

type ListUsersMixedTypeCursorPaginationRequest struct {
	Cursor *string `json:"-" url:"cursor,omitempty"`
}

type ListUsersOffsetPaginationRequest struct {
	// Defaults to first page
	Page *int `json:"-" url:"page,omitempty"`
	// Defaults to per page
	PerPage *int   `json:"-" url:"per_page,omitempty"`
	Order   *Order `json:"-" url:"order,omitempty"`
	// The cursor used for pagination in order to fetch
	// the next page of results.
	StartingAfter *string `json:"-" url:"starting_after,omitempty"`
}

type ListWithOffsetPaginationHasNextPageRequest struct {
	// Defaults to first page
	Page *int `json:"-" url:"page,omitempty"`
	// The maxiumum number of elements to return.
	// This is also used as the step size in this
	// paginated endpoint.
	Limit *int   `json:"-" url:"limit,omitempty"`
	Order *Order `json:"-" url:"order,omitempty"`
}

type ListUsersOffsetStepPaginationRequest struct {
	// Defaults to first page
	Page *int `json:"-" url:"page,omitempty"`
	// The maxiumum number of elements to return.
	// This is also used as the step size in this
	// paginated endpoint.
	Limit *int   `json:"-" url:"limit,omitempty"`
	Order *Order `json:"-" url:"order,omitempty"`
}

type UsernameCursor struct {
	Cursor *UsernamePage `json:"cursor,omitempty" url:"cursor,omitempty"`

	extraProperties map[string]interface{}
	rawJSON         json.RawMessage
}

func (u *UsernameCursor) GetCursor() *UsernamePage {
	if u == nil {
		return nil
	}
	return u.Cursor
}

func (u *UsernameCursor) GetExtraProperties() map[string]interface{} {
	return u.extraProperties
}

func (u *UsernameCursor) UnmarshalJSON(data []byte) error {
	type unmarshaler UsernameCursor
	var value unmarshaler
	if err := json.Unmarshal(data, &value); err != nil {
		return err
	}
	*u = UsernameCursor(value)
	extraProperties, err := internal.ExtractExtraProperties(data, *u)
	if err != nil {
		return err
	}
	u.extraProperties = extraProperties
	u.rawJSON = json.RawMessage(data)
	return nil
}

func (u *UsernameCursor) String() string {
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

type UsernamePage struct {
	After *string  `json:"after,omitempty" url:"after,omitempty"`
	Data  []string `json:"data,omitempty" url:"data,omitempty"`

	extraProperties map[string]interface{}
	rawJSON         json.RawMessage
}

func (u *UsernamePage) GetAfter() *string {
	if u == nil {
		return nil
	}
	return u.After
}

func (u *UsernamePage) GetData() []string {
	if u == nil {
		return nil
	}
	return u.Data
}

func (u *UsernamePage) GetExtraProperties() map[string]interface{} {
	return u.extraProperties
}

func (u *UsernamePage) UnmarshalJSON(data []byte) error {
	type unmarshaler UsernamePage
	var value unmarshaler
	if err := json.Unmarshal(data, &value); err != nil {
		return err
	}
	*u = UsernamePage(value)
	extraProperties, err := internal.ExtractExtraProperties(data, *u)
	if err != nil {
		return err
	}
	u.extraProperties = extraProperties
	u.rawJSON = json.RawMessage(data)
	return nil
}

func (u *UsernamePage) String() string {
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

type ListUsersExtendedOptionalListResponse struct {
	Data *UserOptionalListContainer `json:"data,omitempty" url:"data,omitempty"`
	Next *uuid.UUID                 `json:"next,omitempty" url:"next,omitempty"`
	// The totall number of /users
	TotalCount int `json:"total_count" url:"total_count"`

	extraProperties map[string]interface{}
	rawJSON         json.RawMessage
}

func (l *ListUsersExtendedOptionalListResponse) GetData() *UserOptionalListContainer {
	if l == nil {
		return nil
	}
	return l.Data
}

func (l *ListUsersExtendedOptionalListResponse) GetNext() *uuid.UUID {
	if l == nil {
		return nil
	}
	return l.Next
}

func (l *ListUsersExtendedOptionalListResponse) GetTotalCount() int {
	if l == nil {
		return 0
	}
	return l.TotalCount
}

func (l *ListUsersExtendedOptionalListResponse) GetExtraProperties() map[string]interface{} {
	return l.extraProperties
}

func (l *ListUsersExtendedOptionalListResponse) UnmarshalJSON(data []byte) error {
	type unmarshaler ListUsersExtendedOptionalListResponse
	var value unmarshaler
	if err := json.Unmarshal(data, &value); err != nil {
		return err
	}
	*l = ListUsersExtendedOptionalListResponse(value)
	extraProperties, err := internal.ExtractExtraProperties(data, *l)
	if err != nil {
		return err
	}
	l.extraProperties = extraProperties
	l.rawJSON = json.RawMessage(data)
	return nil
}

func (l *ListUsersExtendedOptionalListResponse) String() string {
	if len(l.rawJSON) > 0 {
		if value, err := internal.StringifyJSON(l.rawJSON); err == nil {
			return value
		}
	}
	if value, err := internal.StringifyJSON(l); err == nil {
		return value
	}
	return fmt.Sprintf("%#v", l)
}

type ListUsersExtendedResponse struct {
	Data *UserListContainer `json:"data,omitempty" url:"data,omitempty"`
	Next *uuid.UUID         `json:"next,omitempty" url:"next,omitempty"`
	// The totall number of /users
	TotalCount int `json:"total_count" url:"total_count"`

	extraProperties map[string]interface{}
	rawJSON         json.RawMessage
}

func (l *ListUsersExtendedResponse) GetData() *UserListContainer {
	if l == nil {
		return nil
	}
	return l.Data
}

func (l *ListUsersExtendedResponse) GetNext() *uuid.UUID {
	if l == nil {
		return nil
	}
	return l.Next
}

func (l *ListUsersExtendedResponse) GetTotalCount() int {
	if l == nil {
		return 0
	}
	return l.TotalCount
}

func (l *ListUsersExtendedResponse) GetExtraProperties() map[string]interface{} {
	return l.extraProperties
}

func (l *ListUsersExtendedResponse) UnmarshalJSON(data []byte) error {
	type unmarshaler ListUsersExtendedResponse
	var value unmarshaler
	if err := json.Unmarshal(data, &value); err != nil {
		return err
	}
	*l = ListUsersExtendedResponse(value)
	extraProperties, err := internal.ExtractExtraProperties(data, *l)
	if err != nil {
		return err
	}
	l.extraProperties = extraProperties
	l.rawJSON = json.RawMessage(data)
	return nil
}

func (l *ListUsersExtendedResponse) String() string {
	if len(l.rawJSON) > 0 {
		if value, err := internal.StringifyJSON(l.rawJSON); err == nil {
			return value
		}
	}
	if value, err := internal.StringifyJSON(l); err == nil {
		return value
	}
	return fmt.Sprintf("%#v", l)
}

type ListUsersMixedTypePaginationResponse struct {
	Next string  `json:"next" url:"next"`
	Data []*User `json:"data,omitempty" url:"data,omitempty"`

	extraProperties map[string]interface{}
	rawJSON         json.RawMessage
}

func (l *ListUsersMixedTypePaginationResponse) GetNext() string {
	if l == nil {
		return ""
	}
	return l.Next
}

func (l *ListUsersMixedTypePaginationResponse) GetData() []*User {
	if l == nil {
		return nil
	}
	return l.Data
}

func (l *ListUsersMixedTypePaginationResponse) GetExtraProperties() map[string]interface{} {
	return l.extraProperties
}

func (l *ListUsersMixedTypePaginationResponse) UnmarshalJSON(data []byte) error {
	type unmarshaler ListUsersMixedTypePaginationResponse
	var value unmarshaler
	if err := json.Unmarshal(data, &value); err != nil {
		return err
	}
	*l = ListUsersMixedTypePaginationResponse(value)
	extraProperties, err := internal.ExtractExtraProperties(data, *l)
	if err != nil {
		return err
	}
	l.extraProperties = extraProperties
	l.rawJSON = json.RawMessage(data)
	return nil
}

func (l *ListUsersMixedTypePaginationResponse) String() string {
	if len(l.rawJSON) > 0 {
		if value, err := internal.StringifyJSON(l.rawJSON); err == nil {
			return value
		}
	}
	if value, err := internal.StringifyJSON(l); err == nil {
		return value
	}
	return fmt.Sprintf("%#v", l)
}

type ListUsersPaginationResponse struct {
	HasNextPage *bool `json:"hasNextPage,omitempty" url:"hasNextPage,omitempty"`
	Page        *Page `json:"page,omitempty" url:"page,omitempty"`
	// The totall number of /users
	TotalCount int     `json:"total_count" url:"total_count"`
	Data       []*User `json:"data,omitempty" url:"data,omitempty"`

	extraProperties map[string]interface{}
	rawJSON         json.RawMessage
}

func (l *ListUsersPaginationResponse) GetHasNextPage() *bool {
	if l == nil {
		return nil
	}
	return l.HasNextPage
}

func (l *ListUsersPaginationResponse) GetPage() *Page {
	if l == nil {
		return nil
	}
	return l.Page
}

func (l *ListUsersPaginationResponse) GetTotalCount() int {
	if l == nil {
		return 0
	}
	return l.TotalCount
}

func (l *ListUsersPaginationResponse) GetData() []*User {
	if l == nil {
		return nil
	}
	return l.Data
}

func (l *ListUsersPaginationResponse) GetExtraProperties() map[string]interface{} {
	return l.extraProperties
}

func (l *ListUsersPaginationResponse) UnmarshalJSON(data []byte) error {
	type unmarshaler ListUsersPaginationResponse
	var value unmarshaler
	if err := json.Unmarshal(data, &value); err != nil {
		return err
	}
	*l = ListUsersPaginationResponse(value)
	extraProperties, err := internal.ExtractExtraProperties(data, *l)
	if err != nil {
		return err
	}
	l.extraProperties = extraProperties
	l.rawJSON = json.RawMessage(data)
	return nil
}

func (l *ListUsersPaginationResponse) String() string {
	if len(l.rawJSON) > 0 {
		if value, err := internal.StringifyJSON(l.rawJSON); err == nil {
			return value
		}
	}
	if value, err := internal.StringifyJSON(l); err == nil {
		return value
	}
	return fmt.Sprintf("%#v", l)
}

type NextPage struct {
	Page          int    `json:"page" url:"page"`
	StartingAfter string `json:"starting_after" url:"starting_after"`

	extraProperties map[string]interface{}
	rawJSON         json.RawMessage
}

func (n *NextPage) GetPage() int {
	if n == nil {
		return 0
	}
	return n.Page
}

func (n *NextPage) GetStartingAfter() string {
	if n == nil {
		return ""
	}
	return n.StartingAfter
}

func (n *NextPage) GetExtraProperties() map[string]interface{} {
	return n.extraProperties
}

func (n *NextPage) UnmarshalJSON(data []byte) error {
	type unmarshaler NextPage
	var value unmarshaler
	if err := json.Unmarshal(data, &value); err != nil {
		return err
	}
	*n = NextPage(value)
	extraProperties, err := internal.ExtractExtraProperties(data, *n)
	if err != nil {
		return err
	}
	n.extraProperties = extraProperties
	n.rawJSON = json.RawMessage(data)
	return nil
}

func (n *NextPage) String() string {
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

type Order string

const (
	OrderAsc  Order = "asc"
	OrderDesc Order = "desc"
)

func NewOrderFromString(s string) (Order, error) {
	switch s {
	case "asc":
		return OrderAsc, nil
	case "desc":
		return OrderDesc, nil
	}
	var t Order
	return "", fmt.Errorf("%s is not a valid %T", s, t)
}

func (o Order) Ptr() *Order {
	return &o
}

type Page struct {
	// The current page
	Page      int       `json:"page" url:"page"`
	Next      *NextPage `json:"next,omitempty" url:"next,omitempty"`
	PerPage   int       `json:"per_page" url:"per_page"`
	TotalPage int       `json:"total_page" url:"total_page"`

	extraProperties map[string]interface{}
	rawJSON         json.RawMessage
}

func (p *Page) GetPage() int {
	if p == nil {
		return 0
	}
	return p.Page
}

func (p *Page) GetNext() *NextPage {
	if p == nil {
		return nil
	}
	return p.Next
}

func (p *Page) GetPerPage() int {
	if p == nil {
		return 0
	}
	return p.PerPage
}

func (p *Page) GetTotalPage() int {
	if p == nil {
		return 0
	}
	return p.TotalPage
}

func (p *Page) GetExtraProperties() map[string]interface{} {
	return p.extraProperties
}

func (p *Page) UnmarshalJSON(data []byte) error {
	type unmarshaler Page
	var value unmarshaler
	if err := json.Unmarshal(data, &value); err != nil {
		return err
	}
	*p = Page(value)
	extraProperties, err := internal.ExtractExtraProperties(data, *p)
	if err != nil {
		return err
	}
	p.extraProperties = extraProperties
	p.rawJSON = json.RawMessage(data)
	return nil
}

func (p *Page) String() string {
	if len(p.rawJSON) > 0 {
		if value, err := internal.StringifyJSON(p.rawJSON); err == nil {
			return value
		}
	}
	if value, err := internal.StringifyJSON(p); err == nil {
		return value
	}
	return fmt.Sprintf("%#v", p)
}

type User struct {
	Name string `json:"name" url:"name"`
	Id   int    `json:"id" url:"id"`

	extraProperties map[string]interface{}
	rawJSON         json.RawMessage
}

func (u *User) GetName() string {
	if u == nil {
		return ""
	}
	return u.Name
}

func (u *User) GetId() int {
	if u == nil {
		return 0
	}
	return u.Id
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

type UserListContainer struct {
	Users []*User `json:"users,omitempty" url:"users,omitempty"`

	extraProperties map[string]interface{}
	rawJSON         json.RawMessage
}

func (u *UserListContainer) GetUsers() []*User {
	if u == nil {
		return nil
	}
	return u.Users
}

func (u *UserListContainer) GetExtraProperties() map[string]interface{} {
	return u.extraProperties
}

func (u *UserListContainer) UnmarshalJSON(data []byte) error {
	type unmarshaler UserListContainer
	var value unmarshaler
	if err := json.Unmarshal(data, &value); err != nil {
		return err
	}
	*u = UserListContainer(value)
	extraProperties, err := internal.ExtractExtraProperties(data, *u)
	if err != nil {
		return err
	}
	u.extraProperties = extraProperties
	u.rawJSON = json.RawMessage(data)
	return nil
}

func (u *UserListContainer) String() string {
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

type UserOptionalListContainer struct {
	Users []*User `json:"users,omitempty" url:"users,omitempty"`

	extraProperties map[string]interface{}
	rawJSON         json.RawMessage
}

func (u *UserOptionalListContainer) GetUsers() []*User {
	if u == nil {
		return nil
	}
	return u.Users
}

func (u *UserOptionalListContainer) GetExtraProperties() map[string]interface{} {
	return u.extraProperties
}

func (u *UserOptionalListContainer) UnmarshalJSON(data []byte) error {
	type unmarshaler UserOptionalListContainer
	var value unmarshaler
	if err := json.Unmarshal(data, &value); err != nil {
		return err
	}
	*u = UserOptionalListContainer(value)
	extraProperties, err := internal.ExtractExtraProperties(data, *u)
	if err != nil {
		return err
	}
	u.extraProperties = extraProperties
	u.rawJSON = json.RawMessage(data)
	return nil
}

func (u *UserOptionalListContainer) String() string {
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

type UserOptionalListPage struct {
	Data *UserOptionalListContainer `json:"data,omitempty" url:"data,omitempty"`
	Next *uuid.UUID                 `json:"next,omitempty" url:"next,omitempty"`

	extraProperties map[string]interface{}
	rawJSON         json.RawMessage
}

func (u *UserOptionalListPage) GetData() *UserOptionalListContainer {
	if u == nil {
		return nil
	}
	return u.Data
}

func (u *UserOptionalListPage) GetNext() *uuid.UUID {
	if u == nil {
		return nil
	}
	return u.Next
}

func (u *UserOptionalListPage) GetExtraProperties() map[string]interface{} {
	return u.extraProperties
}

func (u *UserOptionalListPage) UnmarshalJSON(data []byte) error {
	type unmarshaler UserOptionalListPage
	var value unmarshaler
	if err := json.Unmarshal(data, &value); err != nil {
		return err
	}
	*u = UserOptionalListPage(value)
	extraProperties, err := internal.ExtractExtraProperties(data, *u)
	if err != nil {
		return err
	}
	u.extraProperties = extraProperties
	u.rawJSON = json.RawMessage(data)
	return nil
}

func (u *UserOptionalListPage) String() string {
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

type UserPage struct {
	Data *UserListContainer `json:"data,omitempty" url:"data,omitempty"`
	Next *uuid.UUID         `json:"next,omitempty" url:"next,omitempty"`

	extraProperties map[string]interface{}
	rawJSON         json.RawMessage
}

func (u *UserPage) GetData() *UserListContainer {
	if u == nil {
		return nil
	}
	return u.Data
}

func (u *UserPage) GetNext() *uuid.UUID {
	if u == nil {
		return nil
	}
	return u.Next
}

func (u *UserPage) GetExtraProperties() map[string]interface{} {
	return u.extraProperties
}

func (u *UserPage) UnmarshalJSON(data []byte) error {
	type unmarshaler UserPage
	var value unmarshaler
	if err := json.Unmarshal(data, &value); err != nil {
		return err
	}
	*u = UserPage(value)
	extraProperties, err := internal.ExtractExtraProperties(data, *u)
	if err != nil {
		return err
	}
	u.extraProperties = extraProperties
	u.rawJSON = json.RawMessage(data)
	return nil
}

func (u *UserPage) String() string {
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

type UsernameContainer struct {
	Results []string `json:"results,omitempty" url:"results,omitempty"`

	extraProperties map[string]interface{}
	rawJSON         json.RawMessage
}

func (u *UsernameContainer) GetResults() []string {
	if u == nil {
		return nil
	}
	return u.Results
}

func (u *UsernameContainer) GetExtraProperties() map[string]interface{} {
	return u.extraProperties
}

func (u *UsernameContainer) UnmarshalJSON(data []byte) error {
	type unmarshaler UsernameContainer
	var value unmarshaler
	if err := json.Unmarshal(data, &value); err != nil {
		return err
	}
	*u = UsernameContainer(value)
	extraProperties, err := internal.ExtractExtraProperties(data, *u)
	if err != nil {
		return err
	}
	u.extraProperties = extraProperties
	u.rawJSON = json.RawMessage(data)
	return nil
}

func (u *UsernameContainer) String() string {
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

type WithCursor struct {
	Cursor *string `json:"cursor,omitempty" url:"cursor,omitempty"`

	extraProperties map[string]interface{}
	rawJSON         json.RawMessage
}

func (w *WithCursor) GetCursor() *string {
	if w == nil {
		return nil
	}
	return w.Cursor
}

func (w *WithCursor) GetExtraProperties() map[string]interface{} {
	return w.extraProperties
}

func (w *WithCursor) UnmarshalJSON(data []byte) error {
	type unmarshaler WithCursor
	var value unmarshaler
	if err := json.Unmarshal(data, &value); err != nil {
		return err
	}
	*w = WithCursor(value)
	extraProperties, err := internal.ExtractExtraProperties(data, *w)
	if err != nil {
		return err
	}
	w.extraProperties = extraProperties
	w.rawJSON = json.RawMessage(data)
	return nil
}

func (w *WithCursor) String() string {
	if len(w.rawJSON) > 0 {
		if value, err := internal.StringifyJSON(w.rawJSON); err == nil {
			return value
		}
	}
	if value, err := internal.StringifyJSON(w); err == nil {
		return value
	}
	return fmt.Sprintf("%#v", w)
}

type WithPage struct {
	Page *int `json:"page,omitempty" url:"page,omitempty"`

	extraProperties map[string]interface{}
	rawJSON         json.RawMessage
}

func (w *WithPage) GetPage() *int {
	if w == nil {
		return nil
	}
	return w.Page
}

func (w *WithPage) GetExtraProperties() map[string]interface{} {
	return w.extraProperties
}

func (w *WithPage) UnmarshalJSON(data []byte) error {
	type unmarshaler WithPage
	var value unmarshaler
	if err := json.Unmarshal(data, &value); err != nil {
		return err
	}
	*w = WithPage(value)
	extraProperties, err := internal.ExtractExtraProperties(data, *w)
	if err != nil {
		return err
	}
	w.extraProperties = extraProperties
	w.rawJSON = json.RawMessage(data)
	return nil
}

func (w *WithPage) String() string {
	if len(w.rawJSON) > 0 {
		if value, err := internal.StringifyJSON(w.rawJSON); err == nil {
			return value
		}
	}
	if value, err := internal.StringifyJSON(w); err == nil {
		return value
	}
	return fmt.Sprintf("%#v", w)
}
