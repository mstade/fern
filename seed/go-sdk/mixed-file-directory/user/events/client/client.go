// This file was auto-generated by Fern from our API Definition.

package client

import (
	context "context"
	core "github.com/mixed-file-directory/fern/core"
	internal "github.com/mixed-file-directory/fern/internal"
	option "github.com/mixed-file-directory/fern/option"
	user "github.com/mixed-file-directory/fern/user"
	metadata "github.com/mixed-file-directory/fern/user/events/metadata"
	http "net/http"
)

type Client struct {
	baseURL string
	caller  *internal.Caller
	header  http.Header

	Metadata *metadata.Client
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
		header:   options.ToHeader(),
		Metadata: metadata.NewClient(opts...),
	}
}

// List all user events.
func (c *Client) ListEvents(
	ctx context.Context,
	request *user.ListUserEventsRequest,
	opts ...option.RequestOption,
) ([]*user.Event, error) {
	options := core.NewRequestOptions(opts...)
	baseURL := internal.ResolveBaseURL(
		options.BaseURL,
		c.baseURL,
		"",
	)
	endpointURL := baseURL + "/users/events/"
	queryParams, err := internal.QueryValues(request)
	if err != nil {
		return nil, err
	}
	if len(queryParams) > 0 {
		endpointURL += "?" + queryParams.Encode()
	}
	headers := internal.MergeHeaders(
		c.header.Clone(),
		options.ToHeader(),
	)

	var response []*user.Event
	if err := c.caller.Call(
		ctx,
		&internal.CallParams{
			URL:             endpointURL,
			Method:          http.MethodGet,
			Headers:         headers,
			MaxAttempts:     options.MaxAttempts,
			BodyProperties:  options.BodyProperties,
			QueryParameters: options.QueryParameters,
			Client:          options.HTTPClient,
			Response:        &response,
		},
	); err != nil {
		return nil, err
	}
	return response, nil
}
