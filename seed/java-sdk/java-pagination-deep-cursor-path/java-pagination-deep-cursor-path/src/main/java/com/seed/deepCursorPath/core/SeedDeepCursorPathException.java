/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.seed.deepCursorPath.core;

/**
 * This class serves as the base exception for all errors in the SDK.
 */
public class SeedDeepCursorPathException extends RuntimeException {
    public SeedDeepCursorPathException(String message) {
        super(message);
    }

    public SeedDeepCursorPathException(String message, Exception e) {
        super(message, e);
    }
}
