package ir

import (
	json "encoding/json"
	fmt "fmt"
)

type HttpRequestBody struct {
	Type               string
	InlinedRequestBody *InlinedRequestBody
	Reference          *HttpRequestBodyReference
	FileUpload         *FileUploadRequest
}

func (x *HttpRequestBody) UnmarshalJSON(data []byte) error {
	var unmarshaler struct {
		Type string `json:"type"`
	}
	if err := json.Unmarshal(data, &unmarshaler); err != nil {
		return err
	}
	x.Type = unmarshaler.Type
	switch unmarshaler.Type {
	case "inlinedRequestBody":
		value := new(InlinedRequestBody)
		if err := json.Unmarshal(data, &value); err != nil {
			return err
		}
		x.InlinedRequestBody = value
	case "reference":
		value := new(HttpRequestBodyReference)
		if err := json.Unmarshal(data, &value); err != nil {
			return err
		}
		x.Reference = value
	case "fileUpload":
		value := new(FileUploadRequest)
		if err := json.Unmarshal(data, &value); err != nil {
			return err
		}
		x.FileUpload = value
	}
	return nil
}

func (x HttpRequestBody) MarshalJSON() ([]byte, error) {
	switch x.Type {
	default:
		return nil, fmt.Errorf("invalid type %s in %T", x.Type, x)
	case "inlinedRequestBody":
		var marshaler = struct {
			Type string `json:"type"`
			*InlinedRequestBody
		}{
			Type:               x.Type,
			InlinedRequestBody: x.InlinedRequestBody,
		}
		return json.Marshal(marshaler)
	case "reference":
		var marshaler = struct {
			Type string `json:"type"`
			*HttpRequestBodyReference
		}{
			Type:                     x.Type,
			HttpRequestBodyReference: x.Reference,
		}
		return json.Marshal(marshaler)
	case "fileUpload":
		var marshaler = struct {
			Type string `json:"type"`
			*FileUploadRequest
		}{
			Type:              x.Type,
			FileUploadRequest: x.FileUpload,
		}
		return json.Marshal(marshaler)
	}
}

type HttpRequestBodyVisitor interface {
	VisitInlinedRequestBody(*InlinedRequestBody) error
	VisitReference(*HttpRequestBodyReference) error
	VisitFileUpload(*FileUploadRequest) error
}

func (x *HttpRequestBody) Accept(v HttpRequestBodyVisitor) error {
	switch x.Type {
	default:
		return fmt.Errorf("invalid type %s in %T", x.Type, x)
	case "inlinedRequestBody":
		return v.VisitInlinedRequestBody(x.InlinedRequestBody)
	case "reference":
		return v.VisitReference(x.Reference)
	case "fileUpload":
		return v.VisitFileUpload(x.FileUpload)
	}
}
