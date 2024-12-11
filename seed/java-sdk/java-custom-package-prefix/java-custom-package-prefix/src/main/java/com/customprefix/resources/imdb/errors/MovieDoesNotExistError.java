/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.customprefix.resources.imdb.errors;

import com.customprefix.core.SeedApiApiException;

public final class MovieDoesNotExistError extends SeedApiApiException {
    /**
     * The body of the response that triggered the exception.
     */
    private final String body;

    public MovieDoesNotExistError(String body) {
        super("MovieDoesNotExistError", 404, body);
        this.body = body;
    }

    /**
     * @return the body
     */
    @java.lang.Override
    public String body() {
        return this.body;
    }
}
