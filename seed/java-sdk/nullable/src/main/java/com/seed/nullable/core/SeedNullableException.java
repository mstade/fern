/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.seed.nullable.core;

/**
 * This class serves as the base exception for all errors in the SDK.
 */
public class SeedNullableException extends RuntimeException {
    public SeedNullableException(String message) {
        super(message);
    }

    public SeedNullableException(String message, Exception e) {
        super(message, e);
    }
}
