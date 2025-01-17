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
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import org.jetbrains.annotations.NotNull;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = ObjectTypeWithSetAliasType.Builder.class)
public final class ObjectTypeWithSetAliasType {
    private final Set<PropItem> prop;

    private final Map<String, Object> additionalProperties;

    private ObjectTypeWithSetAliasType(Set<PropItem> prop, Map<String, Object> additionalProperties) {
        this.prop = prop;
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("prop")
    public Set<PropItem> getProp() {
        return prop;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof ObjectTypeWithSetAliasType && equalTo((ObjectTypeWithSetAliasType) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(ObjectTypeWithSetAliasType other) {
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
        private Set<PropItem> prop = new LinkedHashSet<>();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(ObjectTypeWithSetAliasType other) {
            prop(other.getProp());
            return this;
        }

        @JsonSetter(value = "prop", nulls = Nulls.SKIP)
        public Builder prop(Set<PropItem> prop) {
            this.prop.clear();
            this.prop.addAll(prop);
            return this;
        }

        public Builder addProp(PropItem prop) {
            this.prop.add(prop);
            return this;
        }

        public Builder addAllProp(Set<PropItem> prop) {
            this.prop.addAll(prop);
            return this;
        }

        public ObjectTypeWithSetAliasType build() {
            return new ObjectTypeWithSetAliasType(prop, additionalProperties);
        }
    }

    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    @JsonDeserialize(builder = PropItem.Builder.class)
    public static final class PropItem {
        private final String prop;

        private final Map<String, Object> additionalProperties;

        private PropItem(String prop, Map<String, Object> additionalProperties) {
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
            return other instanceof PropItem && equalTo((PropItem) other);
        }

        @JsonAnyGetter
        public Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
        }

        private boolean equalTo(PropItem other) {
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

            Builder from(PropItem other);
        }

        public interface _FinalStage {
            PropItem build();
        }

        @JsonIgnoreProperties(ignoreUnknown = true)
        public static final class Builder implements PropStage, _FinalStage {
            private String prop;

            @JsonAnySetter
            private Map<String, Object> additionalProperties = new HashMap<>();

            private Builder() {}

            @java.lang.Override
            public Builder from(PropItem other) {
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
            public PropItem build() {
                return new PropItem(prop, additionalProperties);
            }
        }
    }
}
