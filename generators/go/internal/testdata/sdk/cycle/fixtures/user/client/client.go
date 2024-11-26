// This file was auto-generated by Fern from our API Definition.

package client

import (
	core "github.com/fern-api/fern-go/internal/testdata/sdk/cycle/fixtures/core"
	internal "github.com/fern-api/fern-go/internal/testdata/sdk/cycle/fixtures/internal"
	option "github.com/fern-api/fern-go/internal/testdata/sdk/cycle/fixtures/option"
	user "github.com/fern-api/fern-go/internal/testdata/sdk/cycle/fixtures/user/user"
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
