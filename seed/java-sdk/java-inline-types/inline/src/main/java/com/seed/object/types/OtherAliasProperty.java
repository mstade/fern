/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.seed.object.types;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.seed.object.core.ObjectMappers;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;

public final class OtherAliasProperty {
    private final Value value;

    private OtherAliasProperty(Value value) {
        this.value = value;
    }

    @JsonValue
    public Value get() {
        return this.value;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        return this == other
                || (other instanceof OtherAliasProperty && this.value.equals(((OtherAliasProperty) other).value));
    }

    @java.lang.Override
    public int hashCode() {
        return value.hashCode();
    }

    @java.lang.Override
    public String toString() {
        return value.toString();
    }

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static OtherAliasProperty of(Value value) {
        return new OtherAliasProperty(value);
    }

    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    @JsonDeserialize(builder = Value.Builder.class)
    public static final class Value {
        private final String prop;

        private final Map<String, Object> additionalProperties;

        private Value(String prop, Map<String, Object> additionalProperties) {
            this.prop = prop;
            this.additionalProperties = additionalProperties;
        }

        @JsonProperty("prop")
        public String getProp() {
            return prop;
        }

        @java.lang.Override
        public boolean equals(Object other) {
            if (this == other) return true;
            return other instanceof Value && equalTo((Value) other);
        }

        @JsonAnyGetter
        public Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
        }

        private boolean equalTo(Value other) {
            return prop.equals(other.prop);
        }

        @java.lang.Override
        public int hashCode() {
            return Objects.hash(this.prop);
        }

        @java.lang.Override
        public String toString() {
            return ObjectMappers.stringify(this);
        }

        public static PropStage builder() {
            return new Builder();
        }

        public interface PropStage {
            _FinalStage prop(@NotNull String prop);

            Builder from(Value other);
        }

        public interface _FinalStage {
            Value build();
        }

        @JsonIgnoreProperties(ignoreUnknown = true)
        public static final class Builder implements PropStage, _FinalStage {
            private String prop;

            @JsonAnySetter
            private Map<String, Object> additionalProperties = new HashMap<>();

            private Builder() {}

            @java.lang.Override
            public Builder from(Value other) {
                prop(other.getProp());
                return this;
            }

            @java.lang.Override
            @JsonSetter("prop")
            public _FinalStage prop(@NotNull String prop) {
                this.prop = Objects.requireNonNull(prop, "prop must not be null");
                return this;
            }

            @java.lang.Override
            public Value build() {
                return new Value(prop, additionalProperties);
            }
        }
    }
}
