/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.seed.trace.resources.submission;

import com.fasterxml.jackson.core.type.TypeReference;
import com.seed.trace.core.ClientOptions;
import com.seed.trace.core.ObjectMappers;
import com.seed.trace.core.RequestOptions;
import com.seed.trace.core.SeedTraceApiException;
import com.seed.trace.core.SeedTraceException;
import com.seed.trace.resources.commons.types.Language;
import com.seed.trace.resources.submission.types.ExecutionSessionResponse;
import com.seed.trace.resources.submission.types.GetExecutionSessionStateResponse;
import java.io.IOException;
import java.util.Optional;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class SubmissionClient {
    protected final ClientOptions clientOptions;

    public SubmissionClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
    }

    /**
     * Returns sessionId and execution server URL for session. Spins up server.
     */
    public ExecutionSessionResponse createExecutionSession(Language language) {
        return createExecutionSession(language, null);
    }

    /**
     * Returns sessionId and execution server URL for session. Spins up server.
     */
    public ExecutionSessionResponse createExecutionSession(Language language, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("sessions")
                .addPathSegments("create-session")
                .addPathSegment(language.toString())
                .build();
        Request okhttpRequest = new Request.Builder()
                .url(httpUrl)
                .method("POST", RequestBody.create("", null))
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
                return ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), ExecutionSessionResponse.class);
            }
            String responseBodyString = responseBody != null ? responseBody.string() : "{}";
            throw new SeedTraceApiException(
                    "Error with status code " + response.code(),
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
        } catch (IOException e) {
            throw new SeedTraceException("Network error executing HTTP request", e);
        }
    }

    /**
     * Returns execution server URL for session. Returns empty if session isn't registered.
     */
    public Optional<ExecutionSessionResponse> getExecutionSession(String sessionId) {
        return getExecutionSession(sessionId, null);
    }

    /**
     * Returns execution server URL for session. Returns empty if session isn't registered.
     */
    public Optional<ExecutionSessionResponse> getExecutionSession(String sessionId, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("sessions")
                .addPathSegment(sessionId)
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
                return ObjectMappers.JSON_MAPPER.readValue(
                        responseBody.string(), new TypeReference<Optional<ExecutionSessionResponse>>() {});
            }
            String responseBodyString = responseBody != null ? responseBody.string() : "{}";
            throw new SeedTraceApiException(
                    "Error with status code " + response.code(),
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
        } catch (IOException e) {
            throw new SeedTraceException("Network error executing HTTP request", e);
        }
    }

    /**
     * Stops execution session.
     */
    public void stopExecutionSession(String sessionId) {
        stopExecutionSession(sessionId, null);
    }

    /**
     * Stops execution session.
     */
    public void stopExecutionSession(String sessionId, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("sessions")
                .addPathSegments("stop")
                .addPathSegment(sessionId)
                .build();
        Request okhttpRequest = new Request.Builder()
                .url(httpUrl)
                .method("DELETE", null)
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .build();
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
            throw new SeedTraceApiException(
                    "Error with status code " + response.code(),
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
        } catch (IOException e) {
            throw new SeedTraceException("Network error executing HTTP request", e);
        }
    }

    public GetExecutionSessionStateResponse getExecutionSessionsState() {
        return getExecutionSessionsState(null);
    }

    public GetExecutionSessionStateResponse getExecutionSessionsState(RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("sessions")
                .addPathSegments("execution-sessions-state")
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
                return ObjectMappers.JSON_MAPPER.readValue(
                        responseBody.string(), GetExecutionSessionStateResponse.class);
            }
            String responseBodyString = responseBody != null ? responseBody.string() : "{}";
            throw new SeedTraceApiException(
                    "Error with status code " + response.code(),
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
        } catch (IOException e) {
            throw new SeedTraceException("Network error executing HTTP request", e);
        }
    }
}
