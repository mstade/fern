/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.seed.crossPackageTypeNames.resources.foo;

import com.seed.crossPackageTypeNames.core.ClientOptions;
import com.seed.crossPackageTypeNames.core.MediaTypes;
import com.seed.crossPackageTypeNames.core.ObjectMappers;
import com.seed.crossPackageTypeNames.core.RequestOptions;
import com.seed.crossPackageTypeNames.core.SeedCrossPackageTypeNamesApiException;
import com.seed.crossPackageTypeNames.core.SeedCrossPackageTypeNamesException;
import com.seed.crossPackageTypeNames.resources.foo.requests.FindRequest;
import com.seed.crossPackageTypeNames.resources.foo.types.ImportingType;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class FooClient {
    protected final ClientOptions clientOptions;

    public FooClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
    }

    public ImportingType find(FindRequest request) {
        return find(request, null);
    }

    public ImportingType find(FindRequest request, RequestOptions requestOptions) {
        HttpUrl.Builder httpUrl =
                HttpUrl.parse(this.clientOptions.environment().getUrl()).newBuilder();

        if (request.getOptionalString().isPresent()) {
            httpUrl.addQueryParameter(
                    "optionalString", request.getOptionalString().get());
        }
        Map<String, Object> properties = new HashMap<>();
        if (request.getPublicProperty().isPresent()) {
            properties.put("publicProperty", request.getPublicProperty());
        }
        if (request.getPrivateProperty().isPresent()) {
            properties.put("privateProperty", request.getPrivateProperty());
        }
        RequestBody body;
        try {
            body = RequestBody.create(
                    ObjectMappers.JSON_MAPPER.writeValueAsBytes(properties), MediaTypes.APPLICATION_JSON);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Request.Builder _requestBuilder = new Request.Builder()
                .url(httpUrl.build())
                .method("POST", body)
                .addHeader("Accept", "application/json")
                .headers(Headers.of(clientOptions.headers(requestOptions)))
                .addHeader("Content-Type", "application/json");
        Request okhttpRequest = _requestBuilder.build();
        OkHttpClient client = clientOptions.httpClient();
        if (requestOptions != null && requestOptions.getTimeout().isPresent()) {
            client = clientOptions.httpClientWithTimeout(requestOptions);
        }
        try (Response response = client.newCall(okhttpRequest).execute()) {
            ResponseBody responseBody = response.body();
            if (response.isSuccessful()) {
                return ObjectMappers.JSON_MAPPER.readValue(responseBody.string(), ImportingType.class);
            }
            String responseBodyString = responseBody != null ? responseBody.string() : "{}";
            throw new SeedCrossPackageTypeNamesApiException(
                    "Error with status code " + response.code(),
                    response.code(),
                    ObjectMappers.JSON_MAPPER.readValue(responseBodyString, Object.class));
        } catch (IOException e) {
            throw new SeedCrossPackageTypeNamesException("Network error executing HTTP request", e);
        }
    }
}
