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
import java.util.Objects;
import java.util.Set;

@JsonDeserialize(using = UndiscriminatedUnionTypeWithAliasSetVariant.Deserializer.class)
public final class UndiscriminatedUnionTypeWithAliasSetVariant {
    private final Object value;

    private final int type;

    private UndiscriminatedUnionTypeWithAliasSetVariant(Object value, int type) {
        this.value = value;
        this.type = type;
    }

    @JsonValue
    public Object get() {
        return this.value;
    }

    public <T> T visit(Visitor<T> visitor) {
        if (this.type == 0) {
            return visitor.visit((Set<AliasVariant>) this.value);
        }
        throw new IllegalStateException("Failed to visit value. This should never happen.");
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof UndiscriminatedUnionTypeWithAliasSetVariant
                && equalTo((UndiscriminatedUnionTypeWithAliasSetVariant) other);
    }

    private boolean equalTo(UndiscriminatedUnionTypeWithAliasSetVariant other) {
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

    public static UndiscriminatedUnionTypeWithAliasSetVariant of(Set<AliasVariant> value) {
        return new UndiscriminatedUnionTypeWithAliasSetVariant(value, 0);
    }

    public interface Visitor<T> {
        T visit(Set<AliasVariant> value);
    }

    static final class Deserializer extends StdDeserializer<UndiscriminatedUnionTypeWithAliasSetVariant> {
        Deserializer() {
            super(UndiscriminatedUnionTypeWithAliasSetVariant.class);
        }

        @java.lang.Override
        public UndiscriminatedUnionTypeWithAliasSetVariant deserialize(JsonParser p, DeserializationContext context)
                throws IOException {
            Object value = p.readValueAs(Object.class);
            try {
                return of(ObjectMappers.JSON_MAPPER.convertValue(value, new TypeReference<Set<AliasVariant>>() {}));
            } catch (IllegalArgumentException e) {
            }
            throw new JsonParseException(p, "Failed to deserialize");
        }
    }
}
