/**
 * This file was auto-generated by Fern from our API Definition.
 */

package com.fern.sdk.resources.endpoints.params;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fern.sdk.core.ClientOptions;
import com.fern.sdk.core.MediaTypes;
import com.fern.sdk.core.ObjectMappers;
import com.fern.sdk.core.RequestOptions;
import com.fern.sdk.core.SeedExhaustiveApiException;
import com.fern.sdk.core.SeedExhaustiveException;
import com.fern.sdk.resources.endpoints.params.requests.GetWithInlinePath;
import com.fern.sdk.resources.endpoints.params.requests.GetWithInlinePathAndQuery;
import com.fern.sdk.resources.endpoints.params.requests.GetWithMultipleQuery;
import com.fern.sdk.resources.endpoints.params.requests.GetWithPathAndQuery;
import com.fern.sdk.resources.endpoints.params.requests.GetWithQuery;
import com.fern.sdk.resources.endpoints.params.requests.ModifyResourceAtInlinedPath;
import java.io.IOException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.String;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class ParamsClient {
  protected final ClientOptions clientOptions;

  public ParamsClient(ClientOptions clientOptions) {
    this.clientOptions = clientOptions;
  }

  /**
   * GET with path param
   */
  public String getWithPath(String param) {
    return getWithPath(param,null);
  }

  /**
   * GET with path param
   */
  public String getWithPath(String param, RequestOptions requestOptions) {
    HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl()).newBuilder()
      .addPathSegments("params")
      .addPathSegments("path")
      .addPathSegment(param)
      .build();
    Request okhttpRequest = new Request.Builder()
      .url(httpUrl)
      .method("GET", null)
      .headers(Headers.of(clientOptions.headers(requestOptions)))
      .addHeader("Content-Type", "application/json")
      .addHeader("Accept", "application/json")
      .build();
    OkHttpClient client = clientOptions.httpClient();
    if (requestOptions != null && requestOptions.getTimeout().isPresent()) {
      client = clientOptions.httpClientWithTimeout(requestOptions);
    }
    try (Response response = client.newCall(okhttpRequest).execute()) {
      ResponseBody responseBody = response.body();
      if (response.isSuccessful()) {
        return ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), String.class);
      }
      String responseBodyString = responseBody != null ? responseBody.string() : "{}";
      throw new SeedExhaustiveApiException("Error with status code " + response.code(), response.code(), ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
    }
    catch (IOException e) {
      throw new SeedExhaustiveException("Network error executing HTTP request", e);
    }
  }

  /**
   * GET with path param
   */
  public String getWithInlinePath(String param, GetWithInlinePath request) {
    return getWithInlinePath(param,request,null);
  }

  /**
   * GET with path param
   */
  public String getWithInlinePath(String param, GetWithInlinePath request,
      RequestOptions requestOptions) {
    HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl()).newBuilder()
      .addPathSegments("params")
      .addPathSegments("path")
      .addPathSegment(param)
      .build();
    Request.Builder _requestBuilder = new Request.Builder()
      .url(httpUrl)
      .method("GET", null)
      .headers(Headers.of(clientOptions.headers(requestOptions)))
      .addHeader("Content-Type", "application/json").addHeader("Accept", "application/json");
    Request okhttpRequest = _requestBuilder.build();
    OkHttpClient client = clientOptions.httpClient();
    if (requestOptions != null && requestOptions.getTimeout().isPresent()) {
      client = clientOptions.httpClientWithTimeout(requestOptions);
    }
    try (Response response = client.newCall(okhttpRequest).execute()) {
      ResponseBody responseBody = response.body();
      if (response.isSuccessful()) {
        return ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), String.class);
      }
      String responseBodyString = responseBody != null ? responseBody.string() : "{}";
      throw new SeedExhaustiveApiException("Error with status code " + response.code(), response.code(), ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
    }
    catch (IOException e) {
      throw new SeedExhaustiveException("Network error executing HTTP request", e);
    }
  }

  /**
   * GET with query param
   */
  public void getWithQuery(GetWithQuery request) {
    getWithQuery(request,null);
  }

  /**
   * GET with query param
   */
  public void getWithQuery(GetWithQuery request, RequestOptions requestOptions) {
    HttpUrl.Builder httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl()).newBuilder()
      .addPathSegments("params")
      ;httpUrl.addQueryParameter("query", request.getQuery());
      httpUrl.addQueryParameter("number", Integer.toString(request.getNumber()));
      Request.Builder _requestBuilder = new Request.Builder()
        .url(httpUrl.build())
        .method("GET", null)
        .headers(Headers.of(clientOptions.headers(requestOptions)));
      Request okhttpRequest = _requestBuilder.build();
      OkHttpClient client = clientOptions.httpClient();
      if (requestOptions != null && requestOptions.getTimeout().isPresent()) {
        client = clientOptions.httpClientWithTimeout(requestOptions);
      }
      try (Response response = client.newCall(okhttpRequest).execute()) {
        ResponseBody responseBody = response.body();
        if (response.isSuccessful()) {
          return;
        }
        String responseBodyString = responseBody != null ? responseBody.string() : "{}";
        throw new SeedExhaustiveApiException("Error with status code " + response.code(), response.code(), ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
      }
      catch (IOException e) {
        throw new SeedExhaustiveException("Network error executing HTTP request", e);
      }
    }

    /**
     * GET with multiple of same query param
     */
    public void getWithAllowMultipleQuery(GetWithMultipleQuery request) {
      getWithAllowMultipleQuery(request,null);
    }

    /**
     * GET with multiple of same query param
     */
    public void getWithAllowMultipleQuery(GetWithMultipleQuery request,
        RequestOptions requestOptions) {
      HttpUrl.Builder httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl()).newBuilder()
        .addPathSegments("params")
        ;httpUrl.addQueryParameter("query", request.getQuery());
        httpUrl.addQueryParameter("numer", Integer.toString(request.getNumer()));
        Request.Builder _requestBuilder = new Request.Builder()
          .url(httpUrl.build())
          .method("GET", null)
          .headers(Headers.of(clientOptions.headers(requestOptions)));
        Request okhttpRequest = _requestBuilder.build();
        OkHttpClient client = clientOptions.httpClient();
        if (requestOptions != null && requestOptions.getTimeout().isPresent()) {
          client = clientOptions.httpClientWithTimeout(requestOptions);
        }
        try (Response response = client.newCall(okhttpRequest).execute()) {
          ResponseBody responseBody = response.body();
          if (response.isSuccessful()) {
            return;
          }
          String responseBodyString = responseBody != null ? responseBody.string() : "{}";
          throw new SeedExhaustiveApiException("Error with status code " + response.code(), response.code(), ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
        }
        catch (IOException e) {
          throw new SeedExhaustiveException("Network error executing HTTP request", e);
        }
      }

      /**
       * GET with path and query params
       */
      public void getWithPathAndQuery(String param, GetWithPathAndQuery request) {
        getWithPathAndQuery(param,request,null);
      }

      /**
       * GET with path and query params
       */
      public void getWithPathAndQuery(String param, GetWithPathAndQuery request,
          RequestOptions requestOptions) {
        HttpUrl.Builder httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl()).newBuilder()
          .addPathSegments("params")
          .addPathSegments("path-query")
          .addPathSegment(param);httpUrl.addQueryParameter("query", request.getQuery());
          Request.Builder _requestBuilder = new Request.Builder()
            .url(httpUrl.build())
            .method("GET", null)
            .headers(Headers.of(clientOptions.headers(requestOptions)));
          Request okhttpRequest = _requestBuilder.build();
          OkHttpClient client = clientOptions.httpClient();
          if (requestOptions != null && requestOptions.getTimeout().isPresent()) {
            client = clientOptions.httpClientWithTimeout(requestOptions);
          }
          try (Response response = client.newCall(okhttpRequest).execute()) {
            ResponseBody responseBody = response.body();
            if (response.isSuccessful()) {
              return;
            }
            String responseBodyString = responseBody != null ? responseBody.string() : "{}";
            throw new SeedExhaustiveApiException("Error with status code " + response.code(), response.code(), ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
          }
          catch (IOException e) {
            throw new SeedExhaustiveException("Network error executing HTTP request", e);
          }
        }

        /**
         * GET with path and query params
         */
        public void getWithInlinePathAndQuery(String param, GetWithInlinePathAndQuery request) {
          getWithInlinePathAndQuery(param,request,null);
        }

        /**
         * GET with path and query params
         */
        public void getWithInlinePathAndQuery(String param, GetWithInlinePathAndQuery request,
            RequestOptions requestOptions) {
          HttpUrl.Builder httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl()).newBuilder()
            .addPathSegments("params")
            .addPathSegments("path-query")
            .addPathSegment(param);httpUrl.addQueryParameter("query", request.getQuery());
            Request.Builder _requestBuilder = new Request.Builder()
              .url(httpUrl.build())
              .method("GET", null)
              .headers(Headers.of(clientOptions.headers(requestOptions)));
            Request okhttpRequest = _requestBuilder.build();
            OkHttpClient client = clientOptions.httpClient();
            if (requestOptions != null && requestOptions.getTimeout().isPresent()) {
              client = clientOptions.httpClientWithTimeout(requestOptions);
            }
            try (Response response = client.newCall(okhttpRequest).execute()) {
              ResponseBody responseBody = response.body();
              if (response.isSuccessful()) {
                return;
              }
              String responseBodyString = responseBody != null ? responseBody.string() : "{}";
              throw new SeedExhaustiveApiException("Error with status code " + response.code(), response.code(), ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
            }
            catch (IOException e) {
              throw new SeedExhaustiveException("Network error executing HTTP request", e);
            }
          }

          /**
           * PUT to update with path param
           */
          public String modifyWithPath(String param, String request) {
            return modifyWithPath(param,request,null);
          }

          /**
           * PUT to update with path param
           */
          public String modifyWithPath(String param, String request,
              RequestOptions requestOptions) {
            HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl()).newBuilder()
              .addPathSegments("params")
              .addPathSegments("path")
              .addPathSegment(param)
              .build();
            RequestBody body;
            try {
              body = RequestBody.create(ObjectMappers.JSON_MAPPER.writeValueAsBytes(request), MediaTypes.APPLICATION_JSON);
            }
            catch(JsonProcessingException e) {
              throw new SeedExhaustiveException("Failed to serialize request", e);
            }
            Request okhttpRequest = new Request.Builder()
              .url(httpUrl)
              .method("PUT", body)
              .headers(Headers.of(clientOptions.headers(requestOptions)))
              .addHeader("Content-Type", "application/json")
              .build();
            OkHttpClient client = clientOptions.httpClient();
            if (requestOptions != null && requestOptions.getTimeout().isPresent()) {
              client = clientOptions.httpClientWithTimeout(requestOptions);
            }
            try (Response response = client.newCall(okhttpRequest).execute()) {
              ResponseBody responseBody = response.body();
              if (response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), String.class);
              }
              String responseBodyString = responseBody != null ? responseBody.string() : "{}";
              throw new SeedExhaustiveApiException("Error with status code " + response.code(), response.code(), ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
            }
            catch (IOException e) {
              throw new SeedExhaustiveException("Network error executing HTTP request", e);
            }
          }

          /**
           * PUT to update with path param
           */
          public String modifyWithInlinePath(String param, ModifyResourceAtInlinedPath request) {
            return modifyWithInlinePath(param,request,null);
          }

          /**
           * PUT to update with path param
           */
          public String modifyWithInlinePath(String param, ModifyResourceAtInlinedPath request,
              RequestOptions requestOptions) {
            HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl()).newBuilder()
              .addPathSegments("params")
              .addPathSegments("path")
              .addPathSegment(param)
              .build();
            RequestBody body;
            try {
              body = RequestBody.create(ObjectMappers.JSON_MAPPER.writeValueAsBytes(request), MediaTypes.APPLICATION_JSON);
            }
            catch(JsonProcessingException e) {
              throw new SeedExhaustiveException("Failed to serialize request", e);
            }
            Request okhttpRequest = new Request.Builder()
              .url(httpUrl)
              .method("PUT", body)
              .headers(Headers.of(clientOptions.headers(requestOptions)))
              .addHeader("Content-Type", "application/json")
              .addHeader("Accept", "application/json")
              .build();
            OkHttpClient client = clientOptions.httpClient();
            if (requestOptions != null && requestOptions.getTimeout().isPresent()) {
              client = clientOptions.httpClientWithTimeout(requestOptions);
            }
            try (Response response = client.newCall(okhttpRequest).execute()) {
              ResponseBody responseBody = response.body();
              if (response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), String.class);
              }
              String responseBodyString = responseBody != null ? responseBody.string() : "{}";
              throw new SeedExhaustiveApiException("Error with status code " + response.code(), response.code(), ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
            }
            catch (IOException e) {
              throw new SeedExhaustiveException("Network error executing HTTP request", e);
            }
          }
        }
