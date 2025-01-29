/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.seed.deepCursorPath.resources.deepcursorpath.types;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.seed.deepCursorPath.core.ObjectMappers;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = C.Builder.class)
public final class C {
    private final Optional<D> d;

    private final Map<String, Object> additionalProperties;

    private C(Optional<D> d, Map<String, Object> additionalProperties) {
        this.d = d;
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("d")
    public Optional<D> getD() {
        return d;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof C && equalTo((C) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(C other) {
        return d.equals(other.d);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.d);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<D> d = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(C other) {
            d(other.getD());
            return this;
        }

        @JsonSetter(value = "d", nulls = Nulls.SKIP)
        public Builder d(Optional<D> d) {
            this.d = d;
            return this;
        }

        public Builder d(D d) {
            this.d = Optional.ofNullable(d);
            return this;
        }

        public C build() {
            return new C(d, additionalProperties);
        }
    }
}
