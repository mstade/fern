/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.seed.examples.model.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.seed.examples.core.ObjectMappers;
import com.seed.examples.model.Type;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = ResponseType.Builder.class)
public final class ResponseType {
    private final Type type;

    private ResponseType(Type type) {
        this.type = type;
    }

    @JsonProperty("type")
    public Type getType() {
        return type;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof ResponseType && equalTo((ResponseType) other);
    }

    private boolean equalTo(ResponseType other) {
        return type.equals(other.type);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.type);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static TypeStage builder() {
        return new Builder();
    }

    public interface TypeStage {
        _FinalStage type(Type type);

        Builder from(ResponseType other);
    }

    public interface _FinalStage {
        ResponseType build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements TypeStage, _FinalStage {
        private Type type;

        private Builder() {}

        @java.lang.Override
        public Builder from(ResponseType other) {
            type(other.getType());
            return this;
        }

        @java.lang.Override
        @JsonSetter("type")
        public _FinalStage type(Type type) {
            this.type = type;
            return this;
        }

        @java.lang.Override
        public ResponseType build() {
            return new ResponseType(type);
        }
    }
}
