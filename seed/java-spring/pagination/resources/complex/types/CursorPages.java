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
import java.lang.Integer;
import java.lang.Object;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(
    builder = CursorPages.Builder.class
)
public final class CursorPages {
  private final Optional<StartingAfterPaging> next;

  private final Optional<Integer> page;

  private final Optional<Integer> perPage;

  private final Optional<Integer> totalPages;

  private CursorPages(Optional<StartingAfterPaging> next, Optional<Integer> page,
      Optional<Integer> perPage, Optional<Integer> totalPages) {
    this.next = next;
    this.page = page;
    this.perPage = perPage;
    this.totalPages = totalPages;
  }

  @JsonProperty("next")
  public Optional<StartingAfterPaging> getNext() {
    return next;
  }

  @JsonProperty("page")
  public Optional<Integer> getPage() {
    return page;
  }

  @JsonProperty("per_page")
  public Optional<Integer> getPerPage() {
    return perPage;
  }

  @JsonProperty("total_pages")
  public Optional<Integer> getTotalPages() {
    return totalPages;
  }

  @JsonProperty("type")
  public String getType() {
    return "pages";
  }

  @java.lang.Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof CursorPages && equalTo((CursorPages) other);
  }

  private boolean equalTo(CursorPages other) {
    return next.equals(other.next) && page.equals(other.page) && perPage.equals(other.perPage) && totalPages.equals(other.totalPages);
  }

  @java.lang.Override
  public int hashCode() {
    return Objects.hash(this.next, this.page, this.perPage, this.totalPages);
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
    private Optional<StartingAfterPaging> next = Optional.empty();

    private Optional<Integer> page = Optional.empty();

    private Optional<Integer> perPage = Optional.empty();

    private Optional<Integer> totalPages = Optional.empty();

    private Builder() {
    }

    public Builder from(CursorPages other) {
      next(other.getNext());
      page(other.getPage());
      perPage(other.getPerPage());
      totalPages(other.getTotalPages());
      return this;
    }

    @JsonSetter(
        value = "next",
        nulls = Nulls.SKIP
    )
    public Builder next(Optional<StartingAfterPaging> next) {
      this.next = next;
      return this;
    }

    public Builder next(StartingAfterPaging next) {
      this.next = Optional.ofNullable(next);
      return this;
    }

    @JsonSetter(
        value = "page",
        nulls = Nulls.SKIP
    )
    public Builder page(Optional<Integer> page) {
      this.page = page;
      return this;
    }

    public Builder page(Integer page) {
      this.page = Optional.ofNullable(page);
      return this;
    }

    @JsonSetter(
        value = "per_page",
        nulls = Nulls.SKIP
    )
    public Builder perPage(Optional<Integer> perPage) {
      this.perPage = perPage;
      return this;
    }

    public Builder perPage(Integer perPage) {
      this.perPage = Optional.ofNullable(perPage);
      return this;
    }

    @JsonSetter(
        value = "total_pages",
        nulls = Nulls.SKIP
    )
    public Builder totalPages(Optional<Integer> totalPages) {
      this.totalPages = totalPages;
      return this;
    }

    public Builder totalPages(Integer totalPages) {
      this.totalPages = Optional.ofNullable(totalPages);
      return this;
    }

    public CursorPages build() {
      return new CursorPages(next, page, perPage, totalPages);
    }
  }
}
