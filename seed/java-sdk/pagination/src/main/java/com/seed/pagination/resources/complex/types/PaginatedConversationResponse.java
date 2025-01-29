/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.seed.pagination.resources.complex.types;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.seed.pagination.core.ObjectMappers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = PaginatedConversationResponse.Builder.class)
public final class PaginatedConversationResponse {
    private final List<Conversation> conversations;

    private final Optional<CursorPages> pages;

    private final int totalCount;

    private final Map<String, Object> additionalProperties;

    private PaginatedConversationResponse(
            List<Conversation> conversations,
            Optional<CursorPages> pages,
            int totalCount,
            Map<String, Object> additionalProperties) {
        this.conversations = conversations;
        this.pages = pages;
        this.totalCount = totalCount;
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("conversations")
    public List<Conversation> getConversations() {
        return conversations;
    }

    @JsonProperty("pages")
    public Optional<CursorPages> getPages() {
        return pages;
    }

    @JsonProperty("total_count")
    public int getTotalCount() {
        return totalCount;
    }

    @JsonProperty("type")
    public String getType() {
        return "conversation.list";
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof PaginatedConversationResponse && equalTo((PaginatedConversationResponse) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(PaginatedConversationResponse other) {
        return conversations.equals(other.conversations) && pages.equals(other.pages) && totalCount == other.totalCount;
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.conversations, this.pages, this.totalCount);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static TotalCountStage builder() {
        return new Builder();
    }

    public interface TotalCountStage {
        _FinalStage totalCount(int totalCount);

        Builder from(PaginatedConversationResponse other);
    }

    public interface _FinalStage {
        PaginatedConversationResponse build();

        _FinalStage conversations(List<Conversation> conversations);

        _FinalStage addConversations(Conversation conversations);

        _FinalStage addAllConversations(List<Conversation> conversations);

        _FinalStage pages(Optional<CursorPages> pages);

        _FinalStage pages(CursorPages pages);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements TotalCountStage, _FinalStage {
        private int totalCount;

        private Optional<CursorPages> pages = Optional.empty();

        private List<Conversation> conversations = new ArrayList<>();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @java.lang.Override
        public Builder from(PaginatedConversationResponse other) {
            conversations(other.getConversations());
            pages(other.getPages());
            totalCount(other.getTotalCount());
            return this;
        }

        @java.lang.Override
        @JsonSetter("total_count")
        public _FinalStage totalCount(int totalCount) {
            this.totalCount = totalCount;
            return this;
        }

        @java.lang.Override
        public _FinalStage pages(CursorPages pages) {
            this.pages = Optional.ofNullable(pages);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "pages", nulls = Nulls.SKIP)
        public _FinalStage pages(Optional<CursorPages> pages) {
            this.pages = pages;
            return this;
        }

        @java.lang.Override
        public _FinalStage addAllConversations(List<Conversation> conversations) {
            this.conversations.addAll(conversations);
            return this;
        }

        @java.lang.Override
        public _FinalStage addConversations(Conversation conversations) {
            this.conversations.add(conversations);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "conversations", nulls = Nulls.SKIP)
        public _FinalStage conversations(List<Conversation> conversations) {
            this.conversations.clear();
            this.conversations.addAll(conversations);
            return this;
        }

        @java.lang.Override
        public PaginatedConversationResponse build() {
            return new PaginatedConversationResponse(conversations, pages, totalCount, additionalProperties);
        }
    }
}
