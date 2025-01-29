/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.seed.api.types;

import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.seed.api.core.ObjectMappers;
import java.io.IOException;
import java.util.Objects;

@JsonDeserialize(using = ResourceList.Deserializer.class)
public final class ResourceList {
    private final Object value;

    private final int type;

    private ResourceList(Object value, int type) {
        this.value = value;
        this.type = type;
    }

    @JsonValue
    public Object get() {
        return this.value;
    }

    public <T> T visit(Visitor<T> visitor) {
        if (this.type == 0) {
            return visitor.visit((Account) this.value);
        } else if (this.type == 1) {
            return visitor.visit((Patient) this.value);
        } else if (this.type == 2) {
            return visitor.visit((Practitioner) this.value);
        } else if (this.type == 3) {
            return visitor.visit((Script) this.value);
        }
        throw new IllegalStateException("Failed to visit value. This should never happen.");
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof ResourceList && equalTo((ResourceList) other);
    }

    private boolean equalTo(ResourceList other) {
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

    public static ResourceList of(Account value) {
        return new ResourceList(value, 0);
    }

    public static ResourceList of(Patient value) {
        return new ResourceList(value, 1);
    }

    public static ResourceList of(Practitioner value) {
        return new ResourceList(value, 2);
    }

    public static ResourceList of(Script value) {
        return new ResourceList(value, 3);
    }

    public interface Visitor<T> {
        T visit(Account value);

        T visit(Patient value);

        T visit(Practitioner value);

        T visit(Script value);
    }

    static final class Deserializer extends StdDeserializer<ResourceList> {
        Deserializer() {
            super(ResourceList.class);
        }

        @java.lang.Override
        public ResourceList deserialize(JsonParser p, DeserializationContext context) throws IOException {
            Object value = p.readValueAs(Object.class);
            try {
                return of(ObjectMappers.JSON_MAPPER.convertValue(value, Account.class));
            } catch (IllegalArgumentException e) {
            }
            try {
                return of(ObjectMappers.JSON_MAPPER.convertValue(value, Patient.class));
            } catch (IllegalArgumentException e) {
            }
            try {
                return of(ObjectMappers.JSON_MAPPER.convertValue(value, Practitioner.class));
            } catch (IllegalArgumentException e) {
            }
            try {
                return of(ObjectMappers.JSON_MAPPER.convertValue(value, Script.class));
            } catch (IllegalArgumentException e) {
            }
            throw new JsonParseException(p, "Failed to deserialize");
        }
    }
}
