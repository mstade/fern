package ir

import (
	json "encoding/json"
	fmt "fmt"
)

type SdkResponse struct {
	Type           string
	Json           *JsonResponse
	Streaming      *StreamingResponse
	MaybeStreaming *MaybeStreamingResponse
	FileDownload   *FileDownloadResponse
}

func (x *SdkResponse) UnmarshalJSON(data []byte) error {
	var unmarshaler struct {
		Type string `json:"type"`
	}
	if err := json.Unmarshal(data, &unmarshaler); err != nil {
		return err
	}
	x.Type = unmarshaler.Type
	switch unmarshaler.Type {
	case "json":
		value := new(JsonResponse)
		if err := json.Unmarshal(data, &value); err != nil {
			return err
		}
		x.Json = value
	case "streaming":
		value := new(StreamingResponse)
		if err := json.Unmarshal(data, &value); err != nil {
			return err
		}
		x.Streaming = value
	case "maybeStreaming":
		value := new(MaybeStreamingResponse)
		if err := json.Unmarshal(data, &value); err != nil {
			return err
		}
		x.MaybeStreaming = value
	case "fileDownload":
		value := new(FileDownloadResponse)
		if err := json.Unmarshal(data, &value); err != nil {
			return err
		}
		x.FileDownload = value
	}
	return nil
}

func (x SdkResponse) MarshalJSON() ([]byte, error) {
	switch x.Type {
	default:
		return nil, fmt.Errorf("invalid type %s in %T", x.Type, x)
	case "json":
		var marshaler = struct {
			Type string `json:"type"`
			*JsonResponse
		}{
			Type:         x.Type,
			JsonResponse: x.Json,
		}
		return json.Marshal(marshaler)
	case "streaming":
		var marshaler = struct {
			Type string `json:"type"`
			*StreamingResponse
		}{
			Type:              x.Type,
			StreamingResponse: x.Streaming,
		}
		return json.Marshal(marshaler)
	case "maybeStreaming":
		var marshaler = struct {
			Type string `json:"type"`
			*MaybeStreamingResponse
		}{
			Type:                   x.Type,
			MaybeStreamingResponse: x.MaybeStreaming,
		}
		return json.Marshal(marshaler)
	case "fileDownload":
		var marshaler = struct {
			Type string `json:"type"`
			*FileDownloadResponse
		}{
			Type:                 x.Type,
			FileDownloadResponse: x.FileDownload,
		}
		return json.Marshal(marshaler)
	}
}

type SdkResponseVisitor interface {
	VisitJson(*JsonResponse) error
	VisitStreaming(*StreamingResponse) error
	VisitMaybeStreaming(*MaybeStreamingResponse) error
	VisitFileDownload(*FileDownloadResponse) error
}

func (x *SdkResponse) Accept(v SdkResponseVisitor) error {
	switch x.Type {
	default:
		return fmt.Errorf("invalid type %s in %T", x.Type, x)
	case "json":
		return v.VisitJson(x.Json)
	case "streaming":
		return v.VisitStreaming(x.Streaming)
	case "maybeStreaming":
		return v.VisitMaybeStreaming(x.MaybeStreaming)
	case "fileDownload":
		return v.VisitFileDownload(x.FileDownload)
	}
}
