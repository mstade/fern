/**
 * This file was auto-generated by Fern from our API Definition.
 */

package resources.deepcursorpath.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import core.ObjectMappers;
import java.lang.Object;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(
    builder = D.Builder.class
)
public final class D {
  private final Optional<String> startingAfter;

  private D(Optional<String> startingAfter) {
    this.startingAfter = startingAfter;
  }

  @JsonProperty("starting_after")
  public Optional<String> getStartingAfter() {
    return startingAfter;
  }

  @java.lang.Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof D && equalTo((D) other);
  }

  private boolean equalTo(D other) {
    return startingAfter.equals(other.startingAfter);
  }

  @java.lang.Override
  public int hashCode() {
    return Objects.hash(this.startingAfter);
  }

  @java.lang.Override
  public String toString() {
    return ObjectMappers.stringify(this);
  }

  public static Builder builder() {
    return new Builder();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder {
    private Optional<String> startingAfter = Optional.empty();

    private Builder() {
    }

    public Builder from(D other) {
      startingAfter(other.getStartingAfter());
      return this;
    }

    @JsonSetter(
        value = "starting_after",
        nulls = Nulls.SKIP
    )
    public Builder startingAfter(Optional<String> startingAfter) {
      this.startingAfter = startingAfter;
      return this;
    }

    public Builder startingAfter(String startingAfter) {
      this.startingAfter = Optional.ofNullable(startingAfter);
      return this;
    }

    public D build() {
      return new D(startingAfter);
    }
  }
}
