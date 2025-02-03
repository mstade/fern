using System;

namespace SeedUnknownAsAny;

/// <summary>
/// Base exception class for all exceptions thrown by the SDK.
/// </summary>
public class SeedUnknownAsAnyException(string message, Exception? innerException = null)
    : Exception(message, innerException);
