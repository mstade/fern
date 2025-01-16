/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.seed.nullable.resources.nullable.types;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.seed.nullable.core.ObjectMappers;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import org.jetbrains.annotations.NotNull;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = User.Builder.class)
public final class User {
    private final String name;

    private final Optional<List<String>> tags;

    private final Optional<Metadata> metadata;

    private final Map<String, Object> additionalProperties;

    private User(
            String name,
            Optional<List<String>> tags,
            Optional<Metadata> metadata,
            Map<String, Object> additionalProperties) {
        this.name = name;
        this.tags = tags;
        this.metadata = metadata;
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("tags")
    public Optional<List<String>> getTags() {
        return tags;
    }

    @JsonProperty("metadata")
    public Optional<Metadata> getMetadata() {
        return metadata;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof User && equalTo((User) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(User other) {
        return name.equals(other.name) && tags.equals(other.tags) && metadata.equals(other.metadata);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.name, this.tags, this.metadata);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static NameStage builder() {
        return new Builder();
    }

    public interface NameStage {
        _FinalStage name(@NotNull String name);

        Builder from(User other);
    }

    public interface _FinalStage {
        User build();

        _FinalStage tags(Optional<List<String>> tags);

        _FinalStage tags(List<String> tags);

        _FinalStage metadata(Optional<Metadata> metadata);

        _FinalStage metadata(Metadata metadata);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements NameStage, _FinalStage {
        private String name;

        private Optional<Metadata> metadata = Optional.empty();

        private Optional<List<String>> tags = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @java.lang.Override
        public Builder from(User other) {
            name(other.getName());
            tags(other.getTags());
            metadata(other.getMetadata());
            return this;
        }

        @java.lang.Override
        @JsonSetter("name")
        public _FinalStage name(@NotNull String name) {
            this.name = Objects.requireNonNull(name, "name must not be null");
            return this;
        }

        @java.lang.Override
        public _FinalStage metadata(Metadata metadata) {
            this.metadata = Optional.ofNullable(metadata);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "metadata", nulls = Nulls.SKIP)
        public _FinalStage metadata(Optional<Metadata> metadata) {
            this.metadata = metadata;
            return this;
        }

        @java.lang.Override
        public _FinalStage tags(List<String> tags) {
            this.tags = Optional.ofNullable(tags);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "tags", nulls = Nulls.SKIP)
        public _FinalStage tags(Optional<List<String>> tags) {
            this.tags = tags;
            return this;
        }

        @java.lang.Override
        public User build() {
            return new User(name, tags, metadata, additionalProperties);
        }
    }
}
