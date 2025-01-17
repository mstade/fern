/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.seed.object.types;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.seed.object.core.ObjectMappers;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = AliasPropertyType.Builder.class)
public final class AliasPropertyType {
    private final String prop;

    private final Map<String, Object> additionalProperties;

    private AliasPropertyType(String prop, Map<String, Object> additionalProperties) {
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
        return other instanceof AliasPropertyType && equalTo((AliasPropertyType) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(AliasPropertyType other) {
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

        Builder from(AliasPropertyType other);
    }

    public interface _FinalStage {
        AliasPropertyType build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements PropStage, _FinalStage {
        private String prop;

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @java.lang.Override
        public Builder from(AliasPropertyType other) {
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
        public AliasPropertyType build() {
            return new AliasPropertyType(prop, additionalProperties);
        }
    }
}
