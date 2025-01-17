/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.seed.object.types;

import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.seed.object.core.ObjectMappers;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

@JsonDeserialize(using = UndiscriminatedUnionTypeWithAliasListVariant.Deserializer.class)
public final class UndiscriminatedUnionTypeWithAliasListVariant {
    private final Object value;

    private final int type;

    private UndiscriminatedUnionTypeWithAliasListVariant(Object value, int type) {
        this.value = value;
        this.type = type;
    }

    @JsonValue
    public Object get() {
        return this.value;
    }

    public <T> T visit(Visitor<T> visitor) {
        if (this.type == 0) {
            return visitor.visit((List<AliasVariant>) this.value);
        }
        throw new IllegalStateException("Failed to visit value. This should never happen.");
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof UndiscriminatedUnionTypeWithAliasListVariant
                && equalTo((UndiscriminatedUnionTypeWithAliasListVariant) other);
    }

    private boolean equalTo(UndiscriminatedUnionTypeWithAliasListVariant other) {
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

    public static UndiscriminatedUnionTypeWithAliasListVariant of(List<AliasVariant> value) {
        return new UndiscriminatedUnionTypeWithAliasListVariant(value, 0);
    }

    public interface Visitor<T> {
        T visit(List<AliasVariant> value);
    }

    static final class Deserializer extends StdDeserializer<UndiscriminatedUnionTypeWithAliasListVariant> {
        Deserializer() {
            super(UndiscriminatedUnionTypeWithAliasListVariant.class);
        }

        @java.lang.Override
        public UndiscriminatedUnionTypeWithAliasListVariant deserialize(JsonParser p, DeserializationContext ctxt)
                throws IOException {
            Object value = p.readValueAs(Object.class);
            try {
                return of(ObjectMappers.JSON_MAPPER.convertValue(value, new TypeReference<List<AliasVariant>>() {}));
            } catch (IllegalArgumentException e) {
            }
            throw new JsonParseException(p, "Failed to deserialize");
        }
    }
}
