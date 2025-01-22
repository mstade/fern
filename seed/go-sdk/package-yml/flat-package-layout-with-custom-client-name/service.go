// This file was auto-generated by Fern from our API Definition.

package packageyml

import (
	context "context"
	core "github.com/package-yml/fern/core"
	internal "github.com/package-yml/fern/internal"
	option "github.com/package-yml/fern/option"
	http "net/http"
)

type ServiceClient struct {
	baseURL string
	caller  *internal.Caller
	header  http.Header
}

func NewServiceClient(opts ...option.RequestOption) *ServiceClient {
	options := core.NewRequestOptions(opts...)
	return &ServiceClient{
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

func (s *ServiceClient) Nop(
	ctx context.Context,
	id string,
	nestedId string,
	opts ...option.RequestOption,
) error {
	options := core.NewRequestOptions(opts...)
	baseURL := internal.ResolveBaseURL(
		options.BaseURL,
		s.baseURL,
		"",
	)
	endpointURL := internal.EncodeURL(
		baseURL+"/%v//%v",
		id,
		nestedId,
	)
	headers := internal.MergeHeaders(
		s.header.Clone(),
		options.ToHeader(),
	)

	if err := s.caller.Call(
		ctx,
		&internal.CallParams{
			URL:             endpointURL,
			Method:          http.MethodGet,
			Headers:         headers,
			MaxAttempts:     options.MaxAttempts,
			BodyProperties:  options.BodyProperties,
			QueryParameters: options.QueryParameters,
			Client:          options.HTTPClient,
		},
	); err != nil {
		return err
	}
	return nil
}
