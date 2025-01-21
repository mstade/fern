/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.seed.basicAuthEnvironmentVariables;

import com.seed.basicAuthEnvironmentVariables.core.ClientOptions;
import com.seed.basicAuthEnvironmentVariables.core.Environment;
import java.util.Base64;

public final class SeedBasicAuthEnvironmentVariablesClientBuilder {
    private ClientOptions.Builder clientOptionsBuilder = ClientOptions.builder();

    private String username = System.getenv("USERNAME");

    private String accessToken = System.getenv("PASSWORD");

    private Environment environment;

    public SeedBasicAuthEnvironmentVariablesClientBuilder credentials(String username, String accessToken) {
        this.username = username;
        this.accessToken = accessToken;
        return this;
    }

    public SeedBasicAuthEnvironmentVariablesClientBuilder url(String url) {
        this.environment = Environment.custom(url);
        return this;
    }

    /**
     * Sets the timeout (in seconds) for the client
     */
    public SeedBasicAuthEnvironmentVariablesClientBuilder timeout(int timeout) {
        this.clientOptionsBuilder.timeout(timeout);
        return this;
    }

    public SeedBasicAuthEnvironmentVariablesClient build() {
        if (this.username == null) {
            throw new RuntimeException("Please provide username or set the USERNAME environment variable.");
        }
        if (this.accessToken == null) {
            throw new RuntimeException("Please provide accessToken or set the PASSWORD environment variable.");
        }
        String unencodedToken = username + ":" + accessToken;
        String encodedToken = Base64.getEncoder().encodeToString(unencodedToken.getBytes());
        this.clientOptionsBuilder.addHeader("Authorization", "Bearer " + encodedToken);
        clientOptionsBuilder.environment(this.environment);
        return new SeedBasicAuthEnvironmentVariablesClient(clientOptionsBuilder.build());
    }
}
