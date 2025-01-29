/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.seed.object.model;

import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.seed.object.core.ObjectMappers;
import java.io.IOException;
import java.util.Objects;

@JsonDeserialize(using = UndiscriminatedUnionTypeWithAliasVariant.Deserializer.class)
public final class UndiscriminatedUnionTypeWithAliasVariant {
    private final Object value;

    private final int type;

    private UndiscriminatedUnionTypeWithAliasVariant(Object value, int type) {
        this.value = value;
        this.type = type;
    }

    @JsonValue
    public Object get() {
        return this.value;
    }

    public <T> T visit(Visitor<T> visitor) {
        if (this.type == 0) {
            return visitor.visit((AliasVariantType) this.value);
        } else if (this.type == 1) {
            return visitor.visit((NonAliasVariant) this.value);
        }
        throw new IllegalStateException("Failed to visit value. This should never happen.");
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof UndiscriminatedUnionTypeWithAliasVariant
                && equalTo((UndiscriminatedUnionTypeWithAliasVariant) other);
    }

    private boolean equalTo(UndiscriminatedUnionTypeWithAliasVariant other) {
        return value.equals(other.value);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.value);
    }

    @java.lang.Override
    public String toString() {
        return this.value.toString();
    }

    public static UndiscriminatedUnionTypeWithAliasVariant of(AliasVariantType value) {
        return new UndiscriminatedUnionTypeWithAliasVariant(value, 0);
    }

    public static UndiscriminatedUnionTypeWithAliasVariant of(NonAliasVariant value) {
        return new UndiscriminatedUnionTypeWithAliasVariant(value, 1);
    }

    public interface Visitor<T> {
        T visit(AliasVariantType value);

        T visit(NonAliasVariant value);
    }

    static final class Deserializer extends StdDeserializer<UndiscriminatedUnionTypeWithAliasVariant> {
        Deserializer() {
            super(UndiscriminatedUnionTypeWithAliasVariant.class);
        }

        @java.lang.Override
        public UndiscriminatedUnionTypeWithAliasVariant deserialize(JsonParser p, DeserializationContext context)
                throws IOException {
            Object value = p.readValueAs(Object.class);
            try {
                return of(ObjectMappers.JSON_MAPPER.convertValue(value, AliasVariantType.class));
            } catch (IllegalArgumentException e) {
            }
            try {
                return of(ObjectMappers.JSON_MAPPER.convertValue(value, NonAliasVariant.class));
            } catch (IllegalArgumentException e) {
            }
            throw new JsonParseException(p, "Failed to deserialize");
        }
    }
}
