using SeedExhaustive.Core;

namespace SeedExhaustive.Types;

public partial class ObjectClient
{
    private RawClient _client;

    internal ObjectClient(RawClient client)
    {
        _client = client;
    }
}
