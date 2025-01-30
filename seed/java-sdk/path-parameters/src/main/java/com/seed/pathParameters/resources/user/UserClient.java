/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.seed.pathParameters.resources.user;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.seed.pathParameters.core.ClientOptions;
import com.seed.pathParameters.core.MediaTypes;
import com.seed.pathParameters.core.ObjectMappers;
import com.seed.pathParameters.core.RequestOptions;
import com.seed.pathParameters.core.SeedPathParametersApiException;
import com.seed.pathParameters.core.SeedPathParametersException;
import com.seed.pathParameters.resources.user.requests.GetUsersRequest;
import com.seed.pathParameters.resources.user.requests.SearchUsersRequest;
import com.seed.pathParameters.resources.user.requests.UpdateUserRequest;
import com.seed.pathParameters.resources.user.types.User;
import java.io.IOException;
import java.util.List;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class UserClient {
    protected final ClientOptions clientOptions;

    public UserClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
    }

    public User getUser(String userId) {
        return getUser(userId, GetUsersRequest.builder().build());
    }

    public User getUser(String userId, GetUsersRequest request) {
        return getUser(userId, request, null);
    }

    public User getUser(String userId, GetUsersRequest request, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("user")
                .addPathSegment(userId)
                .build();
        Request.Builder _requestBuilder = new Request.Builder()
                .url(httpUrl)
                .method("GET", null)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json")
                .addHeader("Accept", "application/json");
        Request okhttpRequest = _requestBuilder.build();
        OkHttpClient client = clientOptions.httpClient();
        if (requestOptions != null && requestOptions.getTimeout().isPresent()) {
            client = clientOptions.httpClientWithTimeout(requestOptions);
        }
        try (Response response = client.newCall(okhttpRequest).execute()) {
            ResponseBody responseBody = response.body();
            if (response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), User.class);
            }
            String responseBodyString = responseBody != null ? responseBody.string() : "{}";
            throw new SeedPathParametersApiException(
                    "Error with status code " + response.code(),
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
        } catch (IOException e) {
            throw new SeedPathParametersException("Network error executing HTTP request", e);
        }
    }

    public User createUser(User request) {
        return createUser(request, null);
    }

    public User createUser(User request, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("user")
                .build();
        RequestBody body;
        try {
            body = RequestBody.create(
                    ObjectMappers.JSON_MAPPER.writeValueAsBytes(request), MediaTypes.APPLICATION_JSON);
        } catch (JsonProcessingException e) {
            throw new SeedPathParametersException("Failed to serialize request", e);
        }
        Request okhttpRequest = new Request.Builder()
                .url(httpUrl)
                .method("POST", body)
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
                return ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), User.class);
            }
            String responseBodyString = responseBody != null ? responseBody.string() : "{}";
            throw new SeedPathParametersApiException(
                    "Error with status code " + response.code(),
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
        } catch (IOException e) {
            throw new SeedPathParametersException("Network error executing HTTP request", e);
        }
    }

    public User updateUser(String userId, UpdateUserRequest request) {
        return updateUser(userId, request, null);
    }

    public User updateUser(String userId, UpdateUserRequest request, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("user")
                .addPathSegment(userId)
                .build();
        RequestBody body;
        try {
            body = RequestBody.create(
                    ObjectMappers.JSON_MAPPER.writeValueAsBytes(request), MediaTypes.APPLICATION_JSON);
        } catch (JsonProcessingException e) {
            throw new SeedPathParametersException("Failed to serialize request", e);
        }
        Request okhttpRequest = new Request.Builder()
                .url(httpUrl)
                .method("PATCH", body)
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
                return ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), User.class);
            }
            String responseBodyString = responseBody != null ? responseBody.string() : "{}";
            throw new SeedPathParametersApiException(
                    "Error with status code " + response.code(),
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
        } catch (IOException e) {
            throw new SeedPathParametersException("Network error executing HTTP request", e);
        }
    }

    public List<User> searchUsers(String userId) {
        return searchUsers(userId, SearchUsersRequest.builder().build());
    }

    public List<User> searchUsers(String userId, SearchUsersRequest request) {
        return searchUsers(userId, request, null);
    }

    public List<User> searchUsers(String userId, SearchUsersRequest request, RequestOptions requestOptions) {
        HttpUrl.Builder httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("user")
                .addPathSegment(userId)
                .addPathSegments("search");
        if (request.getLimit().isPresent()) {
            httpUrl.addQueryParameter("limit", request.getLimit().get().toString());
        }
        Request.Builder _requestBuilder = new Request.Builder()
                .url(httpUrl.build())
                .method("GET", null)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json")
                .addHeader("Accept", "application/json");
        Request okhttpRequest = _requestBuilder.build();
        OkHttpClient client = clientOptions.httpClient();
        if (requestOptions != null && requestOptions.getTimeout().isPresent()) {
            client = clientOptions.httpClientWithTimeout(requestOptions);
        }
        try (Response response = client.newCall(okhttpRequest).execute()) {
            ResponseBody responseBody = response.body();
            if (response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), new TypeReference<List<User>>() {});
            }
            String responseBodyString = responseBody != null ? responseBody.string() : "{}";
            throw new SeedPathParametersApiException(
                    "Error with status code " + response.code(),
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
        } catch (IOException e) {
            throw new SeedPathParametersException("Network error executing HTTP request", e);
        }
    }
}
