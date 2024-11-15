// This file was auto-generated by Fern from our API Definition.

package auth

import (
	context "context"
	core "github.com/fern-api/fern-go/internal/testdata/sdk/multi-environments/fixtures/core"
	internal "github.com/fern-api/fern-go/internal/testdata/sdk/multi-environments/fixtures/internal"
	option "github.com/fern-api/fern-go/internal/testdata/sdk/multi-environments/fixtures/option"
	http "net/http"
)

type Client struct {
	baseURL string
	caller  *internal.Caller
	header  http.Header
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
	}
}

func (c *Client) GetAuth(
	ctx context.Context,
	opts ...option.RequestOption,
) (string, error) {
	options := core.NewRequestOptions(opts...)

	baseURL := "https://auth.yoursite.com"
	if c.baseURL != "" {
		baseURL = c.baseURL
	}
	if options.BaseURL != "" {
		baseURL = options.BaseURL
	}
	endpointURL := baseURL + "/auth"

	headers := internal.MergeHeaders(c.header.Clone(), options.ToHeader())

	var response string
	if err := c.caller.Call(
		ctx,
		&internal.CallParams{
			URL:             endpointURL,
			Method:          http.MethodGet,
			MaxAttempts:     options.MaxAttempts,
			Headers:         headers,
			BodyProperties:  options.BodyProperties,
			QueryParameters: options.QueryParameters,
			Client:          options.HTTPClient,
			Response:        &response,
		},
	); err != nil {
		return "", err
	}
	return response, nil
}

func (c *Client) ListAuth(
	ctx context.Context,
	opts ...option.RequestOption,
) ([]string, error) {
	options := core.NewRequestOptions(opts...)

	baseURL := "https://auth.yoursite.com"
	if c.baseURL != "" {
		baseURL = c.baseURL
	}
	if options.BaseURL != "" {
		baseURL = options.BaseURL
	}
	endpointURL := baseURL + "/auth/list"

	headers := internal.MergeHeaders(c.header.Clone(), options.ToHeader())

	var response []string
	if err := c.caller.Call(
		ctx,
		&internal.CallParams{
			URL:             endpointURL,
			Method:          http.MethodGet,
			MaxAttempts:     options.MaxAttempts,
			Headers:         headers,
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

func (c *Client) ListPlants(
	ctx context.Context,
	opts ...option.RequestOption,
) ([]string, error) {
	options := core.NewRequestOptions(opts...)

	baseURL := "https://plants.yoursite.com"
	if c.baseURL != "" {
		baseURL = c.baseURL
	}
	if options.BaseURL != "" {
		baseURL = options.BaseURL
	}
	endpointURL := baseURL + "/auth/plants"

	headers := internal.MergeHeaders(c.header.Clone(), options.ToHeader())

	var response []string
	if err := c.caller.Call(
		ctx,
		&internal.CallParams{
			URL:             endpointURL,
			Method:          http.MethodGet,
			MaxAttempts:     options.MaxAttempts,
			Headers:         headers,
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
