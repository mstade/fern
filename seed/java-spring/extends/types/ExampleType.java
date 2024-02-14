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

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(
    builder = ExampleType.Builder.class
)
public final class ExampleType implements IDocs {
  private final String docs;

  private final String name;

  private ExampleType(String docs, String name) {
    this.docs = docs;
    this.name = name;
  }

  @JsonProperty("docs")
  @java.lang.Override
  public String getDocs() {
    return docs;
  }

  @JsonProperty("name")
  public String getName() {
    return name;
  }

  @java.lang.Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof ExampleType && equalTo((ExampleType) other);
  }

  private boolean equalTo(ExampleType other) {
    return docs.equals(other.docs) && name.equals(other.name);
  }

  @java.lang.Override
  public int hashCode() {
    return Objects.hash(this.docs, this.name);
  }

  @java.lang.Override
  public String toString() {
    return ObjectMappers.stringify(this);
  }

  public static DocsStage builder() {
    return new Builder();
  }

  public interface DocsStage {
    NameStage docs(String docs);

    Builder from(ExampleType other);
  }

  public interface NameStage {
    _FinalStage name(String name);
  }

  public interface _FinalStage {
    ExampleType build();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements DocsStage, NameStage, _FinalStage {
    private String docs;

    private String name;

    private Builder() {
    }

    @java.lang.Override
    public Builder from(ExampleType other) {
      docs(other.getDocs());
      name(other.getName());
      return this;
    }

    @java.lang.Override
    @JsonSetter("docs")
    public NameStage docs(String docs) {
      this.docs = docs;
      return this;
    }

    @java.lang.Override
    @JsonSetter("name")
    public _FinalStage name(String name) {
      this.name = name;
      return this;
    }

    @java.lang.Override
    public ExampleType build() {
      return new ExampleType(docs, name);
    }
  }
}