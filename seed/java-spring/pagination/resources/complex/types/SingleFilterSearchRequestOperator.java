/**
 * This file was auto-generated by Fern from our API Definition.
 */

package resources.complex.types;

import com.fasterxml.jackson.annotation.JsonValue;
import java.lang.String;

public enum SingleFilterSearchRequestOperator {
  EQUALS("="),

  NOT_EQUALS("!="),

  IN("IN"),

  NOT_IN("NIN"),

  LESS_THAN("<"),

  GREATER_THAN(">"),

  CONTAINS("~"),

  DOES_NOT_CONTAIN("!~"),

  STARTS_WITH("^"),

  ENDS_WITH("$");

  private final String value;

  SingleFilterSearchRequestOperator(String value) {
    this.value = value;
  }

  @JsonValue
  @java.lang.Override
  public String toString() {
    return this.value;
  }
}
