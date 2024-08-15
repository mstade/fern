/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.seed.anyAuth.resources.auth.requests;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.seed.anyAuth.core.ObjectMappers;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = GetTokenRequest.Builder.class)
public final class GetTokenRequest {
    private final String clientId;

    private final String clientSecret;

    private final Optional<String> scope;

    private final Map<String, Object> additionalProperties;

    private GetTokenRequest(
            String clientId, String clientSecret, Optional<String> scope, Map<String, Object> additionalProperties) {
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.scope = scope;
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("client_id")
    public String getClientId() {
        return clientId;
    }

    @JsonProperty("client_secret")
    public String getClientSecret() {
        return clientSecret;
    }

    @JsonProperty("audience")
    public String getAudience() {
        return "https://api.example.com";
    }

    @JsonProperty("grant_type")
    public String getGrantType() {
        return "client_credentials";
    }

    @JsonProperty("scope")
    public Optional<String> getScope() {
        return scope;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof GetTokenRequest && equalTo((GetTokenRequest) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(GetTokenRequest other) {
        return clientId.equals(other.clientId) && clientSecret.equals(other.clientSecret) && scope.equals(other.scope);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.clientId, this.clientSecret, this.scope);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static ClientIdStage builder() {
        return new Builder();
    }

    public interface ClientIdStage {
        ClientSecretStage clientId(String clientId);

        Builder from(GetTokenRequest other);
    }

    public interface ClientSecretStage {
        _FinalStage clientSecret(String clientSecret);
    }

    public interface _FinalStage {
        GetTokenRequest build();

        _FinalStage scope(Optional<String> scope);

        _FinalStage scope(String scope);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements ClientIdStage, ClientSecretStage, _FinalStage {
        private String clientId;

        private String clientSecret;

        private Optional<String> scope = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @java.lang.Override
        public Builder from(GetTokenRequest other) {
            clientId(other.getClientId());
            clientSecret(other.getClientSecret());
            scope(other.getScope());
            return this;
        }

        @java.lang.Override
        @JsonSetter("client_id")
        public ClientSecretStage clientId(String clientId) {
            this.clientId = clientId;
            return this;
        }

        @java.lang.Override
        @JsonSetter("client_secret")
        public _FinalStage clientSecret(String clientSecret) {
            this.clientSecret = clientSecret;
            return this;
        }

        @java.lang.Override
        public _FinalStage scope(String scope) {
            this.scope = Optional.ofNullable(scope);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "scope", nulls = Nulls.SKIP)
        public _FinalStage scope(Optional<String> scope) {
            this.scope = scope;
            return this;
        }

        @java.lang.Override
        public GetTokenRequest build() {
            return new GetTokenRequest(clientId, clientSecret, scope, additionalProperties);
        }
    }
}
