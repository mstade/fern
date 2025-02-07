/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.seed.examples.resources.types.types;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.seed.examples.core.ObjectMappers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = ExtendedMovie.Builder.class)
public final class ExtendedMovie implements IMovie {
    private final String foo;

    private final int bar;

    private final List<String> cast;

    private final Map<String, Object> additionalProperties;

    private ExtendedMovie(String foo, int bar, List<String> cast, Map<String, Object> additionalProperties) {
        this.foo = foo;
        this.bar = bar;
        this.cast = cast;
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("foo")
    @java.lang.Override
    public String getFoo() {
        return foo;
    }

    @JsonProperty("bar")
    @java.lang.Override
    public int getBar() {
        return bar;
    }

    @JsonProperty("cast")
    public List<String> getCast() {
        return cast;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof ExtendedMovie && equalTo((ExtendedMovie) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(ExtendedMovie other) {
        return foo.equals(other.foo) && bar == other.bar && cast.equals(other.cast);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.foo, this.bar, this.cast);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static FooStage builder() {
        return new Builder();
    }

    public interface FooStage {
        BarStage foo(@NotNull String foo);

        Builder from(ExtendedMovie other);
    }

    public interface BarStage {
        _FinalStage bar(int bar);
    }

    public interface _FinalStage {
        ExtendedMovie build();

        _FinalStage cast(List<String> cast);

        _FinalStage addCast(String cast);

        _FinalStage addAllCast(List<String> cast);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements FooStage, BarStage, _FinalStage {
        private String foo;

        private int bar;

        private List<String> cast = new ArrayList<>();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @java.lang.Override
        public Builder from(ExtendedMovie other) {
            foo(other.getFoo());
            bar(other.getBar());
            cast(other.getCast());
            return this;
        }

        @java.lang.Override
        @JsonSetter("foo")
        public BarStage foo(@NotNull String foo) {
            this.foo = Objects.requireNonNull(foo, "foo must not be null");
            return this;
        }

        @java.lang.Override
        @JsonSetter("bar")
        public _FinalStage bar(int bar) {
            this.bar = bar;
            return this;
        }

        @java.lang.Override
        public _FinalStage addAllCast(List<String> cast) {
            this.cast.addAll(cast);
            return this;
        }

        @java.lang.Override
        public _FinalStage addCast(String cast) {
            this.cast.add(cast);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "cast", nulls = Nulls.SKIP)
        public _FinalStage cast(List<String> cast) {
            this.cast.clear();
            this.cast.addAll(cast);
            return this;
        }

        @java.lang.Override
        public ExtendedMovie build() {
            return new ExtendedMovie(foo, bar, cast, additionalProperties);
        }
    }
}
