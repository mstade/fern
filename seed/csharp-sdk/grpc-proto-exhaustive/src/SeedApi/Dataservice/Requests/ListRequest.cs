using Proto = Data.V1.Grpc;

#nullable enable

namespace SeedApi;

public record ListRequest
{
    public string? Prefix { get; set; }

    public uint? Limit { get; set; }

    public string? PaginationToken { get; set; }

    public string? Namespace { get; set; }

    /// <summary>
    /// Maps the ListRequest type into its Protobuf-equivalent representation.
    /// </summary>
    internal Proto.ListRequest ToProto()
    {
        var result = new Proto.ListRequest();
        if (Prefix != null)
        {
            result.Prefix = Prefix ?? "";
        }
        if (Limit != null)
        {
            result.Limit = Limit ?? 0U;
        }
        if (PaginationToken != null)
        {
            result.PaginationToken = PaginationToken ?? "";
        }
        if (Namespace != null)
        {
            result.Namespace = Namespace ?? "";
        }
        return result;
    }
}
