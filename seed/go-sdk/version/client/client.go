// This file was auto-generated by Fern from our API Definition.

package client

import (
	core "github.com/version/fern/core"
	internal "github.com/version/fern/internal"
	option "github.com/version/fern/option"
	user "github.com/version/fern/user"
	http "net/http"
)

type Client struct {
	baseURL string
	caller  *internal.Caller
	header  http.Header

	User *user.Client
}

func NewClient(opts ...option.RequestOption) *Client {
	options := core.NewRequestOptions(opts...)
	return &Client{
		baseURL: options.BaseURL,
		caller: internal.NewCaller(
			&internal.CallerParams{
				Client:      options.HTTPClient,
				MaxAttempts: options.MaxAttempts,
			},
		),
		header: options.ToHeader(),
		User:   user.NewClient(opts...),
	}
}
