/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.seed.exhaustive.resources.noreqbody;

import com.seed.exhaustive.core.ClientOptions;
import com.seed.exhaustive.core.ObjectMappers;
import com.seed.exhaustive.core.RequestOptions;
import com.seed.exhaustive.core.SeedExhaustiveApiException;
import com.seed.exhaustive.core.SeedExhaustiveException;
import com.seed.exhaustive.resources.types.object.types.ObjectWithOptionalField;
import java.io.IOException;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class NoReqBodyClient {
    protected final ClientOptions clientOptions;

    public NoReqBodyClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
    }

    public ObjectWithOptionalField getWithNoRequestBody() {
        return getWithNoRequestBody(null);
    }

    public ObjectWithOptionalField getWithNoRequestBody(RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("no-req-body")
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
                return ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), ObjectWithOptionalField.class);
            }
            String responseBodyString = responseBody != null ? responseBody.string() : "{}";
            throw new SeedExhaustiveApiException(
                    "Error with status code " + response.code(),
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
        } catch (IOException e) {
            throw new SeedExhaustiveException("Network error executing HTTP request", e);
        }
    }

    public String postWithNoRequestBody() {
        return postWithNoRequestBody(null);
    }

    public String postWithNoRequestBody(RequestOptions requestOptions) {
        HttpUrl httpUrl = HttpUrl.parse(this.clientOptions.environment().getUrl())
                .newBuilder()
                .addPathSegments("no-req-body")
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
                return ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), String.class);
            }
            String responseBodyString = responseBody != null ? responseBody.string() : "{}";
            throw new SeedExhaustiveApiException(
                    "Error with status code " + response.code(),
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
        } catch (IOException e) {
            throw new SeedExhaustiveException("Network error executing HTTP request", e);
        }
    }
}
