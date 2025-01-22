using System;

#nullable enable

namespace SeedNullable;

/// <summary>
/// Base exception class for all exceptions thrown by the SDK.
/// </summary>
public class SeedNullableException(string message, Exception? innerException = null)
    : Exception(message, innerException) { }
