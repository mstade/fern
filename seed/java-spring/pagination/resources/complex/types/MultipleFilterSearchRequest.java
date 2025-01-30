/**
 * This file was auto-generated by Fern from our API Definition.
 */

package resources.complex.types;

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
    builder = MultipleFilterSearchRequest.Builder.class
)
public final class MultipleFilterSearchRequest {
  private final Optional<MultipleFilterSearchRequestOperator> operator;

  private final Optional<MultipleFilterSearchRequestValue> value;

  private MultipleFilterSearchRequest(Optional<MultipleFilterSearchRequestOperator> operator,
      Optional<MultipleFilterSearchRequestValue> value) {
    this.operator = operator;
    this.value = value;
  }

  @JsonProperty("operator")
  public Optional<MultipleFilterSearchRequestOperator> getOperator() {
    return operator;
  }

  @JsonProperty("value")
  public Optional<MultipleFilterSearchRequestValue> getValue() {
    return value;
  }

  @java.lang.Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof MultipleFilterSearchRequest && equalTo((MultipleFilterSearchRequest) other);
  }

  private boolean equalTo(MultipleFilterSearchRequest other) {
    return operator.equals(other.operator) && value.equals(other.value);
  }

  @java.lang.Override
  public int hashCode() {
    return Objects.hash(this.operator, this.value);
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
    private Optional<MultipleFilterSearchRequestOperator> operator = Optional.empty();

    private Optional<MultipleFilterSearchRequestValue> value = Optional.empty();

    private Builder() {
    }

    public Builder from(MultipleFilterSearchRequest other) {
      operator(other.getOperator());
      value(other.getValue());
      return this;
    }

    @JsonSetter(
        value = "operator",
        nulls = Nulls.SKIP
    )
    public Builder operator(Optional<MultipleFilterSearchRequestOperator> operator) {
      this.operator = operator;
      return this;
    }

    public Builder operator(MultipleFilterSearchRequestOperator operator) {
      this.operator = Optional.ofNullable(operator);
      return this;
    }

    @JsonSetter(
        value = "value",
        nulls = Nulls.SKIP
    )
    public Builder value(Optional<MultipleFilterSearchRequestValue> value) {
      this.value = value;
      return this;
    }

    public Builder value(MultipleFilterSearchRequestValue value) {
      this.value = Optional.ofNullable(value);
      return this;
    }

    public MultipleFilterSearchRequest build() {
      return new MultipleFilterSearchRequest(operator, value);
    }
  }
}
