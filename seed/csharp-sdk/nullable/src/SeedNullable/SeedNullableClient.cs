using SeedNullable.Core;

#nullable enable

namespace SeedNullable;

public partial class SeedNullableClient
{
    private RawClient _client;

    public SeedNullableClient(ClientOptions? clientOptions = null)
    {
        var defaultHeaders = new Headers(
            new Dictionary<string, string>()
            {
                { "X-Fern-Language", "C#" },
                { "X-Fern-SDK-Name", "SeedNullable" },
                { "X-Fern-SDK-Version", Version.Current },
                { "User-Agent", "Fernnullable/0.0.1" },
            }
        );
        clientOptions ??= new ClientOptions();
        foreach (var header in defaultHeaders)
        {
            if (!clientOptions.Headers.ContainsKey(header.Key))
            {
                clientOptions.Headers[header.Key] = header.Value;
            }
        }
        _client = new RawClient(clientOptions);
        Nullable = new NullableClient(_client);
    }

    public NullableClient Nullable { get; init; }
}
