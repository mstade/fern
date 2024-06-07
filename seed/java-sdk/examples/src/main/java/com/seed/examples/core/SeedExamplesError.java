/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.seed.examples.core;

/**
 * This class serves as the base exception for all errors in the SDK.
 */
public class SeedExamplesError extends RuntimeException {
    public SeedExamplesError(String message) {
        super(message);
    }

    public SeedExamplesError(String message, Exception e) {
        super(message, e);
    }
}