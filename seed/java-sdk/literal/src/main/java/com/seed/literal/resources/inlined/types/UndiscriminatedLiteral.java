/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.seed.literal.resources.inlined.types;

import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.seed.literal.core.ObjectMappers;
import java.io.IOException;
import java.util.Objects;

@JsonDeserialize(using = UndiscriminatedLiteral.Deserializer.class)
public final class UndiscriminatedLiteral {
    private final Object value;

    private final int type;

    private UndiscriminatedLiteral(Object value, int type) {
        this.value = value;
        this.type = type;
    }

    @JsonValue
    public Object get() {
        return this.value;
    }

    public <T> T visit(Visitor<T> visitor) {
        if (this.type == 0) {
            return visitor.visit((String) this.value);
        } else if (this.type == 1) {
            return visitor.visit((String) this.value);
        }
        throw new IllegalStateException("Failed to visit value. This should never happen.");
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof UndiscriminatedLiteral && equalTo((UndiscriminatedLiteral) other);
    }

    private boolean equalTo(UndiscriminatedLiteral other) {
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

    public static UndiscriminatedLiteral of(String value) {
        return new UndiscriminatedLiteral(value, 0);
    }

    public static UndiscriminatedLiteral of(String value) {
        return new UndiscriminatedLiteral(value, 1);
    }

    public interface Visitor<T> {
        T visit(String value);

        T visit(String value);
    }

    static final class Deserializer extends StdDeserializer<UndiscriminatedLiteral> {
        Deserializer() {
            super(UndiscriminatedLiteral.class);
        }

        @java.lang.Override
        public UndiscriminatedLiteral deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
            Object value = p.readValueAs(Object.class);
            try {
                return of(ObjectMappers.JSON_MAPPER.convertValue(value, String.class));
            } catch (IllegalArgumentException e) {
            }
            try {
                return of(ObjectMappers.JSON_MAPPER.convertValue(value, new TypeReference<String>() {}));
            } catch (IllegalArgumentException e) {
            }
            throw new JsonParseException(p, "Failed to deserialize");
        }
    }
}
