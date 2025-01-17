/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.seed.object.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.seed.object.core.ObjectMappers;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = ObjectTypeWithListAliasType.Builder.class)
public final class ObjectTypeWithListAliasType {
    private final List<AliasPropertyType> prop;

    private ObjectTypeWithListAliasType(List<AliasPropertyType> prop) {
        this.prop = prop;
    }

    @JsonProperty("prop")
    public List<AliasPropertyType> getProp() {
        return prop;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof ObjectTypeWithListAliasType && equalTo((ObjectTypeWithListAliasType) other);
    }

    private boolean equalTo(ObjectTypeWithListAliasType other) {
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
        private List<AliasPropertyType> prop = new ArrayList<>();

        private Builder() {}

        public Builder from(ObjectTypeWithListAliasType other) {
            prop(other.getProp());
            return this;
        }

        @JsonSetter(value = "prop", nulls = Nulls.SKIP)
        public Builder prop(List<AliasPropertyType> prop) {
            this.prop.clear();
            this.prop.addAll(prop);
            return this;
        }

        public Builder addProp(AliasPropertyType prop) {
            this.prop.add(prop);
            return this;
        }

        public Builder addAllProp(List<AliasPropertyType> prop) {
            this.prop.addAll(prop);
            return this;
        }

        public ObjectTypeWithListAliasType build() {
            return new ObjectTypeWithListAliasType(prop);
        }
    }
}
