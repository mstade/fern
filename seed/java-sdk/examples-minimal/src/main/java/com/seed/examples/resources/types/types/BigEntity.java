/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.seed.examples.resources.types.types;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.seed.examples.core.ObjectMappers;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = BigEntity.Builder.class)
public final class BigEntity {
    private final Optional<ExtendedMovie> extendedMovie;

    private final Optional<Test> test;

    private final Map<String, Object> additionalProperties;

    private BigEntity(
            Optional<ExtendedMovie> extendedMovie, Optional<Test> test, Map<String, Object> additionalProperties) {
        this.extendedMovie = extendedMovie;
        this.test = test;
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("extendedMovie")
    public Optional<ExtendedMovie> getExtendedMovie() {
        return extendedMovie;
    }

    @JsonProperty("test")
    public Optional<Test> getTest() {
        return test;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof BigEntity && equalTo((BigEntity) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(BigEntity other) {
        return extendedMovie.equals(other.extendedMovie) && test.equals(other.test);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.extendedMovie, this.test);
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
        private Optional<ExtendedMovie> extendedMovie = Optional.empty();

        private Optional<Test> test = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(BigEntity other) {
            extendedMovie(other.getExtendedMovie());
            test(other.getTest());
            return this;
        }

        @JsonSetter(value = "extendedMovie", nulls = Nulls.SKIP)
        public Builder extendedMovie(Optional<ExtendedMovie> extendedMovie) {
            this.extendedMovie = extendedMovie;
            return this;
        }

        public Builder extendedMovie(ExtendedMovie extendedMovie) {
            this.extendedMovie = Optional.ofNullable(extendedMovie);
            return this;
        }

        @JsonSetter(value = "test", nulls = Nulls.SKIP)
        public Builder test(Optional<Test> test) {
            this.test = test;
            return this;
        }

        public Builder test(Test test) {
            this.test = Optional.ofNullable(test);
            return this;
        }

        public BigEntity build() {
            return new BigEntity(extendedMovie, test, additionalProperties);
        }
    }
}
