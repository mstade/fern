package ir

import (
	json "encoding/json"
	fmt "fmt"
)

type HttpResponse struct {
	Type         string
	Json         *JsonResponse
	FileDownload *FileDownloadResponse
}

func (x *HttpResponse) UnmarshalJSON(data []byte) error {
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
	case "fileDownload":
		value := new(FileDownloadResponse)
		if err := json.Unmarshal(data, &value); err != nil {
			return err
		}
		x.FileDownload = value
	}
	return nil
}

func (x HttpResponse) MarshalJSON() ([]byte, error) {
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

type HttpResponseVisitor interface {
	VisitJson(*JsonResponse) error
	VisitFileDownload(*FileDownloadResponse) error
}

func (x *HttpResponse) Accept(v HttpResponseVisitor) error {
	switch x.Type {
	default:
		return fmt.Errorf("invalid type %s in %T", x.Type, x)
	case "json":
		return v.VisitJson(x.Json)
	case "fileDownload":
		return v.VisitFileDownload(x.FileDownload)
	}
}
