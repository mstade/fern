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
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.seed.object.core.ObjectMappers;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import org.jetbrains.annotations.NotNull;

public final class UnionTypeWithAliasSetVariant {
    private final Value value;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    private UnionTypeWithAliasSetVariant(Value value) {
        this.value = value;
    }

    public <T> T visit(Visitor<T> visitor) {
        return value.visit(visitor);
    }

    public static UnionTypeWithAliasSetVariant aliasVariant(Set<AliasVariantItem> value) {
        return new UnionTypeWithAliasSetVariant(new AliasVariantValue(value));
    }

    public boolean isAliasVariant() {
        return value instanceof AliasVariantValue;
    }

    public boolean _isUnknown() {
        return value instanceof _UnknownValue;
    }

    public Optional<Set<AliasVariantItem>> getAliasVariant() {
        if (isAliasVariant()) {
            return Optional.of(((AliasVariantValue) value).value);
        }
        return Optional.empty();
    }

    public Optional<Object> _getUnknown() {
        if (_isUnknown()) {
            return Optional.of(((_UnknownValue) value).value);
        }
        return Optional.empty();
    }

    @JsonValue
    private Value getValue() {
        return this.value;
    }

    public interface Visitor<T> {
        T visitAliasVariant(Set<AliasVariantItem> aliasVariant);

        T _visitUnknown(Object unknownType);
    }

    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type", visible = true, defaultImpl = _UnknownValue.class)
    @JsonSubTypes(@JsonSubTypes.Type(AliasVariantValue.class))
    @JsonIgnoreProperties(ignoreUnknown = true)
    private interface Value {
        <T> T visit(Visitor<T> visitor);
    }

    @JsonTypeName("aliasVariant")
    private static final class AliasVariantValue implements Value {
        @JsonProperty("value")
        private Set<AliasVariantItem> value;

        @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
        private AliasVariantValue(@JsonProperty("value") Set<AliasVariantItem> value) {
            this.value = value;
        }

        @java.lang.Override
        public <T> T visit(Visitor<T> visitor) {
            return visitor.visitAliasVariant(value);
        }

        @java.lang.Override
        public boolean equals(Object other) {
            if (this == other) return true;
            return other instanceof AliasVariantValue && equalTo((AliasVariantValue) other);
        }

        private boolean equalTo(AliasVariantValue other) {
            return value.equals(other.value);
        }

        @java.lang.Override
        public int hashCode() {
            return Objects.hash(this.value);
        }

        @java.lang.Override
        public String toString() {
            return "UnionTypeWithAliasSetVariant{" + "value: " + value + "}";
        }
    }

    private static final class _UnknownValue implements Value {
        private String type;

        @JsonValue
        private Object value;

        @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
        private _UnknownValue(@JsonProperty("value") Object value) {}

        @java.lang.Override
        public <T> T visit(Visitor<T> visitor) {
            return visitor._visitUnknown(value);
        }

        @java.lang.Override
        public boolean equals(Object other) {
            if (this == other) return true;
            return other instanceof _UnknownValue && equalTo((_UnknownValue) other);
        }

        private boolean equalTo(_UnknownValue other) {
            return type.equals(other.type) && value.equals(other.value);
        }

        @java.lang.Override
        public int hashCode() {
            return Objects.hash(this.type, this.value);
        }

        @java.lang.Override
        public String toString() {
            return "UnionTypeWithAliasSetVariant{" + "type: " + type + ", value: " + value + "}";
        }
    }

    @JsonInclude(JsonInclude.Include.NON_ABSENT)
    @JsonDeserialize(builder = AliasVariantItem.Builder.class)
    public static final class AliasVariantItem {
        private final String prop;

        private final Map<String, Object> additionalProperties;

        private AliasVariantItem(String prop, Map<String, Object> additionalProperties) {
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
            return other instanceof AliasVariantItem && equalTo((AliasVariantItem) other);
        }

        @JsonAnyGetter
        public Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
        }

        private boolean equalTo(AliasVariantItem other) {
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

            Builder from(AliasVariantItem other);
        }

        public interface _FinalStage {
            AliasVariantItem build();
        }

        @JsonIgnoreProperties(ignoreUnknown = true)
        public static final class Builder implements PropStage, _FinalStage {
            private String prop;

            @JsonAnySetter
            private Map<String, Object> additionalProperties = new HashMap<>();

            private Builder() {}

            @java.lang.Override
            public Builder from(AliasVariantItem other) {
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
            public AliasVariantItem build() {
                return new AliasVariantItem(prop, additionalProperties);
            }
        }
    }
}
