/**
 * This file was auto-generated by Fern from our API Definition.
 */

package types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import core.ObjectMappers;
import java.lang.Object;
import java.lang.String;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(
    builder = OtherAliasPropertyType.Builder.class
)
public final class OtherAliasPropertyType {
  private final String prop;

  private OtherAliasPropertyType(String prop) {
    this.prop = prop;
  }

  @JsonProperty("prop")
  public String getProp() {
    return prop;
  }

  @java.lang.Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof OtherAliasPropertyType && equalTo((OtherAliasPropertyType) other);
  }

  private boolean equalTo(OtherAliasPropertyType other) {
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

    Builder from(OtherAliasPropertyType other);
  }

  public interface _FinalStage {
    OtherAliasPropertyType build();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements PropStage, _FinalStage {
    private String prop;

    private Builder() {
    }

    @java.lang.Override
    public Builder from(OtherAliasPropertyType other) {
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
    public OtherAliasPropertyType build() {
      return new OtherAliasPropertyType(prop);
    }
  }
}
