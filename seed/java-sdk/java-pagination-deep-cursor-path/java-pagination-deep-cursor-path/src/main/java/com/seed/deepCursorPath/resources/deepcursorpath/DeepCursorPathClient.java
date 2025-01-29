/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.seed.deepCursorPath.resources.deepcursorpath;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.seed.deepCursorPath.core.ClientOptions;
import com.seed.deepCursorPath.core.MediaTypes;
import com.seed.deepCursorPath.core.ObjectMappers;
import com.seed.deepCursorPath.core.RequestOptions;
import com.seed.deepCursorPath.core.SeedDeepCursorPathApiException;
import com.seed.deepCursorPath.core.SeedDeepCursorPathException;
import com.seed.deepCursorPath.core.pagination.SyncPagingIterable;
import com.seed.deepCursorPath.resources.deepcursorpath.types.A;
import com.seed.deepCursorPath.resources.deepcursorpath.types.B;
import com.seed.deepCursorPath.resources.deepcursorpath.types.C;
import com.seed.deepCursorPath.resources.deepcursorpath.types.D;
import com.seed.deepCursorPath.resources.deepcursorpath.types.IndirectionRequired;
import com.seed.deepCursorPath.resources.deepcursorpath.types.InlineA;
import com.seed.deepCursorPath.resources.deepcursorpath.types.InlineC;
import com.seed.deepCursorPath.resources.deepcursorpath.types.InlineD;
import com.seed.deepCursorPath.resources.deepcursorpath.types.MainRequired;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class DeepCursorPathClient {
    protected final ClientOptions clientOptions;

    public DeepCursorPathClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
    }

    public SyncPagingIterable<String> doThing() {
        return doThing(A.builder().build());
    }

    public SyncPagingIterable<String> doThing(A request) {
        return doThing(request, null);
    }

    public SyncPagingIterable<String> doThing(A request, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .build();
        RequestBody body;
        try {
            body = RequestBody.create(
                    ObjectMappers.JSON_MAPPER.writeValueAsBytes(request), MediaTypes.APPLICATION_JSON);
        } catch (JsonProcessingException e) {
            throw new SeedDeepCursorPathException("Failed to serialize request", e);
        }
        Request okhttpRequest = new Request.Builder()
                .url(httpUrl)
                .method("POST", body)
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
                com.seed.deepCursorPath.resources.deepcursorpath.types.Response parsedResponse =
                        ObjectMappers.JSON_MAPPER.readValue(
                                responseBody.string(),
                                com.seed.deepCursorPath.resources.deepcursorpath.types.Response.class);
                Optional<String> startingAfter = parsedResponse.getStartingAfter();
                Optional<D> d = request.getB().map(B::getC).flatMap(C::getD).map(d_ -> D.builder()
                        .from(d_)
                        .startingAfter(startingAfter)
                        .build());
                Optional<C> c = d.flatMap(d_ -> request.getB()
                        .map(B::getC)
                        .map(c_ -> C.builder().from(c_).d(d_).build()));
                Optional<B> b = c.flatMap(c_ ->
                        request.getB().map(b_ -> B.builder().from(b_).c(c_).build()));
                A nextRequest = A.builder().from(request).b(b).build();
                List<String> result = parsedResponse.getResults();
                return new SyncPagingIterable<>(
                        startingAfter.isPresent(), result, () -> doThing(nextRequest, requestOptions));
            }
            String responseBodyString = responseBody != null ? responseBody.string() : "{}";
            throw new SeedDeepCursorPathApiException(
                    "Error with status code " + response.code(),
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
        } catch (IOException e) {
            throw new SeedDeepCursorPathException("Network error executing HTTP request", e);
        }
    }

    public SyncPagingIterable<String> doThingRequired(MainRequired request) {
        return doThingRequired(request, null);
    }

    public SyncPagingIterable<String> doThingRequired(MainRequired request, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .build();
        RequestBody body;
        try {
            body = RequestBody.create(
                    ObjectMappers.JSON_MAPPER.writeValueAsBytes(request), MediaTypes.APPLICATION_JSON);
        } catch (JsonProcessingException e) {
            throw new SeedDeepCursorPathException("Failed to serialize request", e);
        }
        Request okhttpRequest = new Request.Builder()
                .url(httpUrl)
                .method("POST", body)
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
                com.seed.deepCursorPath.resources.deepcursorpath.types.Response parsedResponse =
                        ObjectMappers.JSON_MAPPER.readValue(
                                responseBody.string(),
                                com.seed.deepCursorPath.resources.deepcursorpath.types.Response.class);
                Optional<String> startingAfter = parsedResponse.getStartingAfter();
                IndirectionRequired indirection = IndirectionRequired.builder()
                        .from(com.seed.deepCursorPath.resources.deepcursorpath.types.IndirectionRequired)
                        .startingAfter(startingAfter)
                        .build();
                MainRequired nextRequest = MainRequired.builder()
                        .from(request)
                        .indirection(indirection)
                        .build();
                List<String> result = parsedResponse.getResults();
                return new SyncPagingIterable<>(
                        startingAfter.isPresent(), result, () -> doThingRequired(nextRequest, requestOptions));
            }
            String responseBodyString = responseBody != null ? responseBody.string() : "{}";
            throw new SeedDeepCursorPathApiException(
                    "Error with status code " + response.code(),
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
        } catch (IOException e) {
            throw new SeedDeepCursorPathException("Network error executing HTTP request", e);
        }
    }

    public SyncPagingIterable<String> doThingInline() {
        return doThingInline(InlineA.builder().build());
    }

    public SyncPagingIterable<String> doThingInline(InlineA request) {
        return doThingInline(request, null);
    }

    public SyncPagingIterable<String> doThingInline(InlineA request, RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .build();
        RequestBody body;
        try {
            body = RequestBody.create(
                    ObjectMappers.JSON_MAPPER.writeValueAsBytes(request), MediaTypes.APPLICATION_JSON);
        } catch (JsonProcessingException e) {
            throw new SeedDeepCursorPathException("Failed to serialize request", e);
        }
        Request okhttpRequest = new Request.Builder()
                .url(httpUrl)
                .method("POST", body)
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
                com.seed.deepCursorPath.resources.deepcursorpath.types.Response parsedResponse =
                        ObjectMappers.JSON_MAPPER.readValue(
                                responseBody.string(),
                                com.seed.deepCursorPath.resources.deepcursorpath.types.Response.class);
                Optional<String> startingAfter = parsedResponse.getStartingAfter();
                Optional<InlineD> b = request.getB()
                        .map(B::getC)
                        .flatMap(C::getB)
                        .map(b_ -> InlineD.builder()
                                .from(b_)
                                .startingAfter(startingAfter)
                                .build());
                Optional<InlineC> c = b.flatMap(b_ -> request.getB()
                        .map(B::getC)
                        .map(c_ -> InlineC.builder().from(c_).b(b_).build()));
                Optional<InlineD> b = c.flatMap(c_ -> request.getB()
                        .map(b_ -> InlineD.builder().from(b_).c(c_).build()));
                InlineA nextRequest = InlineA.builder().from(request).b(b).build();
                List<String> result = parsedResponse.getResults();
                return new SyncPagingIterable<>(
                        startingAfter.isPresent(), result, () -> doThingInline(nextRequest, requestOptions));
            }
            String responseBodyString = responseBody != null ? responseBody.string() : "{}";
            throw new SeedDeepCursorPathApiException(
                    "Error with status code " + response.code(),
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
        } catch (IOException e) {
            throw new SeedDeepCursorPathException("Network error executing HTTP request", e);
        }
    }
}
