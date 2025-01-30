/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.seed.deepCursorPath.model.deep.cursor.path;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.seed.deepCursorPath.core.ObjectMappers;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = A.Builder.class)
public final class A {
    private final Optional<B> b;

    private A(Optional<B> b) {
        this.b = b;
    }

    @JsonProperty("b")
    public Optional<B> getB() {
        return b;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof A && equalTo((A) other);
    }

    private boolean equalTo(A other) {
        return b.equals(other.b);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.b);
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
        private Optional<B> b = Optional.empty();

        private Builder() {}

        public Builder from(A other) {
            b(other.getB());
            return this;
        }

        @JsonSetter(value = "b", nulls = Nulls.SKIP)
        public Builder b(Optional<B> b) {
            this.b = b;
            return this;
        }

        public Builder b(B b) {
            this.b = Optional.ofNullable(b);
            return this;
        }

        public A build() {
            return new A(b);
        }
    }
}
