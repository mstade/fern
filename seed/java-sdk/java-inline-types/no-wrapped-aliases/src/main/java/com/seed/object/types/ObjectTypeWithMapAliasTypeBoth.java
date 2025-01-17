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
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.seed.object.core.ObjectMappers;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = ObjectTypeWithMapAliasTypeBoth.Builder.class)
public final class ObjectTypeWithMapAliasTypeBoth {
    private final Map<PropKey, PropValue> prop;

    private final Map<String, Object> additionalProperties;

    private ObjectTypeWithMapAliasTypeBoth(Map<PropKey, PropValue> prop, Map<String, Object> additionalProperties) {
        this.prop = prop;
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("prop")
    public Map<PropKey, PropValue> getProp() {
        return prop;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof ObjectTypeWithMapAliasTypeBoth && equalTo((ObjectTypeWithMapAliasTypeBoth) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(ObjectTypeWithMapAliasTypeBoth other) {
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

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Map<PropKey, PropValue> prop = new LinkedHashMap<>();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(ObjectTypeWithMapAliasTypeBoth other) {
            prop(other.getProp());
            return this;
        }

        @JsonSetter(value = "prop", nulls = Nulls.SKIP)
        public Builder prop(Map<PropKey, PropValue> prop) {
            this.prop.clear();
            this.prop.putAll(prop);
            return this;
        }

        public Builder putAllProp(Map<PropKey, PropValue> prop) {
            this.prop.putAll(prop);
            return this;
        }

        public Builder prop(PropKey key, PropValue value) {
            this.prop.put(key, value);
            return this;
        }

        public ObjectTypeWithMapAliasTypeBoth build() {
            return new ObjectTypeWithMapAliasTypeBoth(prop, additionalProperties);
        }
    }

    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    @JsonDeserialize(builder = PropKey.Builder.class)
    public static final class PropKey {
        private final String prop;

        private final Map<String, Object> additionalProperties;

        private PropKey(String prop, Map<String, Object> additionalProperties) {
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
            return other instanceof PropKey && equalTo((PropKey) other);
        }

        @JsonAnyGetter
        public Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
        }

        private boolean equalTo(PropKey other) {
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

            Builder from(PropKey other);
        }

        public interface _FinalStage {
            PropKey build();
        }

        @JsonIgnoreProperties(ignoreUnknown = true)
        public static final class Builder implements PropStage, _FinalStage {
            private String prop;

            @JsonAnySetter
            private Map<String, Object> additionalProperties = new HashMap<>();

            private Builder() {}

            @java.lang.Override
            public Builder from(PropKey other) {
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
            public PropKey build() {
                return new PropKey(prop, additionalProperties);
            }
        }
    }

    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    @JsonDeserialize(builder = PropValue.Builder.class)
    public static final class PropValue {
        private final String prop;

        private final Map<String, Object> additionalProperties;

        private PropValue(String prop, Map<String, Object> additionalProperties) {
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
            return other instanceof PropValue && equalTo((PropValue) other);
        }

        @JsonAnyGetter
        public Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
        }

        private boolean equalTo(PropValue other) {
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

            Builder from(PropValue other);
        }

        public interface _FinalStage {
            PropValue build();
        }

        @JsonIgnoreProperties(ignoreUnknown = true)
        public static final class Builder implements PropStage, _FinalStage {
            private String prop;

            @JsonAnySetter
            private Map<String, Object> additionalProperties = new HashMap<>();

            private Builder() {}

            @java.lang.Override
            public Builder from(PropValue other) {
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
            public PropValue build() {
                return new PropValue(prop, additionalProperties);
            }
        }
    }
}
