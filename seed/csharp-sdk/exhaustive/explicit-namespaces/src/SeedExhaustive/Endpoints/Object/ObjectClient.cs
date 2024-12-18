using System.Net.Http;
using System.Text.Json;
using System.Threading;
using SeedExhaustive;
using SeedExhaustive.Core;
using SeedExhaustive.Types.Object;

#nullable enable

namespace SeedExhaustive.Endpoints.Object;

public partial class ObjectClient
{
    private RawClient _client;

    internal ObjectClient(RawClient client)
    {
        _client = client;
    }

    /// <example>
    /// <code>
    /// await client.Endpoints.Object.GetAndReturnWithOptionalFieldAsync(
    ///     new ObjectWithOptionalField
    ///     {
    ///         String = null,
    ///         Integer = null,
    ///         Long = null,
    ///         Double = null,
    ///         Bool = null,
    ///         Datetime = null,
    ///         Date = null,
    ///         Uuid = null,
    ///         Base64 = null,
    ///         List = null,
    ///         Set = null,
    ///         Map = null,
    ///         Bigint = null,
    ///     }
    /// );
    /// </code>
    /// </example>
    public async Task<ObjectWithOptionalField> GetAndReturnWithOptionalFieldAsync(
        ObjectWithOptionalField request,
        RequestOptions? options = null,
        CancellationToken cancellationToken = default
    )
    {
        var response = await _client.MakeRequestAsync(
            new RawClient.JsonApiRequest
            {
                BaseUrl = _client.Options.BaseUrl,
                Method = HttpMethod.Post,
                Path = "/object/get-and-return-with-optional-field",
                Body = request,
                Options = options,
            },
            cancellationToken
        );
        var responseBody = await response.Raw.Content.ReadAsStringAsync();
        if (response.StatusCode is >= 200 and < 400)
        {
            try
            {
                return JsonUtils.Deserialize<ObjectWithOptionalField>(responseBody)!;
            }
            catch (JsonException e)
            {
                throw new SeedExhaustiveException("Failed to deserialize response", e);
            }
        }

        throw new SeedExhaustiveApiException(
            $"Error with status code {response.StatusCode}",
            response.StatusCode,
            responseBody
        );
    }

    /// <example>
    /// <code>
    /// await client.Endpoints.Object.GetAndReturnWithRequiredFieldAsync(
    ///     new ObjectWithRequiredField { String = "string" }
    /// );
    /// </code>
    /// </example>
    public async Task<ObjectWithRequiredField> GetAndReturnWithRequiredFieldAsync(
        ObjectWithRequiredField request,
        RequestOptions? options = null,
        CancellationToken cancellationToken = default
    )
    {
        var response = await _client.MakeRequestAsync(
            new RawClient.JsonApiRequest
            {
                BaseUrl = _client.Options.BaseUrl,
                Method = HttpMethod.Post,
                Path = "/object/get-and-return-with-required-field",
                Body = request,
                Options = options,
            },
            cancellationToken
        );
        var responseBody = await response.Raw.Content.ReadAsStringAsync();
        if (response.StatusCode is >= 200 and < 400)
        {
            try
            {
                return JsonUtils.Deserialize<ObjectWithRequiredField>(responseBody)!;
            }
            catch (JsonException e)
            {
                throw new SeedExhaustiveException("Failed to deserialize response", e);
            }
        }

        throw new SeedExhaustiveApiException(
            $"Error with status code {response.StatusCode}",
            response.StatusCode,
            responseBody
        );
    }

    /// <example>
    /// <code>
    /// await client.Endpoints.Object.GetAndReturnWithMapOfMapAsync(
    ///     new ObjectWithMapOfMap
    ///     {
    ///         Map = new Dictionary&lt;string, Dictionary&lt;string, string&gt;&gt;()
    ///         {
    ///             {
    ///                 "map",
    ///                 new Dictionary&lt;string, string&gt;() { { "map", "map" } }
    ///             },
    ///         },
    ///     }
    /// );
    /// </code>
    /// </example>
    public async Task<ObjectWithMapOfMap> GetAndReturnWithMapOfMapAsync(
        ObjectWithMapOfMap request,
        RequestOptions? options = null,
        CancellationToken cancellationToken = default
    )
    {
        var response = await _client.MakeRequestAsync(
            new RawClient.JsonApiRequest
            {
                BaseUrl = _client.Options.BaseUrl,
                Method = HttpMethod.Post,
                Path = "/object/get-and-return-with-map-of-map",
                Body = request,
                Options = options,
            },
            cancellationToken
        );
        var responseBody = await response.Raw.Content.ReadAsStringAsync();
        if (response.StatusCode is >= 200 and < 400)
        {
            try
            {
                return JsonUtils.Deserialize<ObjectWithMapOfMap>(responseBody)!;
            }
            catch (JsonException e)
            {
                throw new SeedExhaustiveException("Failed to deserialize response", e);
            }
        }

        throw new SeedExhaustiveApiException(
            $"Error with status code {response.StatusCode}",
            response.StatusCode,
            responseBody
        );
    }

    /// <example>
    /// <code>
    /// await client.Endpoints.Object.GetAndReturnNestedWithOptionalFieldAsync(
    ///     new NestedObjectWithOptionalField { String = null, NestedObject = null }
    /// );
    /// </code>
    /// </example>
    public async Task<NestedObjectWithOptionalField> GetAndReturnNestedWithOptionalFieldAsync(
        NestedObjectWithOptionalField request,
        RequestOptions? options = null,
        CancellationToken cancellationToken = default
    )
    {
        var response = await _client.MakeRequestAsync(
            new RawClient.JsonApiRequest
            {
                BaseUrl = _client.Options.BaseUrl,
                Method = HttpMethod.Post,
                Path = "/object/get-and-return-nested-with-optional-field",
                Body = request,
                Options = options,
            },
            cancellationToken
        );
        var responseBody = await response.Raw.Content.ReadAsStringAsync();
        if (response.StatusCode is >= 200 and < 400)
        {
            try
            {
                return JsonUtils.Deserialize<NestedObjectWithOptionalField>(responseBody)!;
            }
            catch (JsonException e)
            {
                throw new SeedExhaustiveException("Failed to deserialize response", e);
            }
        }

        throw new SeedExhaustiveApiException(
            $"Error with status code {response.StatusCode}",
            response.StatusCode,
            responseBody
        );
    }

    /// <example>
    /// <code>
    /// await client.Endpoints.Object.GetAndReturnNestedWithRequiredFieldAsync(
    ///     "string",
    ///     new NestedObjectWithRequiredField
    ///     {
    ///         String = "string",
    ///         NestedObject = new ObjectWithOptionalField
    ///         {
    ///             String = null,
    ///             Integer = null,
    ///             Long = null,
    ///             Double = null,
    ///             Bool = null,
    ///             Datetime = null,
    ///             Date = null,
    ///             Uuid = null,
    ///             Base64 = null,
    ///             List = null,
    ///             Set = null,
    ///             Map = null,
    ///             Bigint = null,
    ///         },
    ///     }
    /// );
    /// </code>
    /// </example>
    public async Task<NestedObjectWithRequiredField> GetAndReturnNestedWithRequiredFieldAsync(
        string string_,
        NestedObjectWithRequiredField request,
        RequestOptions? options = null,
        CancellationToken cancellationToken = default
    )
    {
        var response = await _client.MakeRequestAsync(
            new RawClient.JsonApiRequest
            {
                BaseUrl = _client.Options.BaseUrl,
                Method = HttpMethod.Post,
                Path = $"/object/get-and-return-nested-with-required-field/{string_}",
                Body = request,
                Options = options,
            },
            cancellationToken
        );
        var responseBody = await response.Raw.Content.ReadAsStringAsync();
        if (response.StatusCode is >= 200 and < 400)
        {
            try
            {
                return JsonUtils.Deserialize<NestedObjectWithRequiredField>(responseBody)!;
            }
            catch (JsonException e)
            {
                throw new SeedExhaustiveException("Failed to deserialize response", e);
            }
        }

        throw new SeedExhaustiveApiException(
            $"Error with status code {response.StatusCode}",
            response.StatusCode,
            responseBody
        );
    }

    /// <example>
    /// <code>
    /// await client.Endpoints.Object.GetAndReturnNestedWithRequiredFieldAsListAsync(
    ///     new List&lt;NestedObjectWithRequiredField&gt;()
    ///     {
    ///         new NestedObjectWithRequiredField
    ///         {
    ///             String = "string",
    ///             NestedObject = new ObjectWithOptionalField
    ///             {
    ///                 String = null,
    ///                 Integer = null,
    ///                 Long = null,
    ///                 Double = null,
    ///                 Bool = null,
    ///                 Datetime = null,
    ///                 Date = null,
    ///                 Uuid = null,
    ///                 Base64 = null,
    ///                 List = null,
    ///                 Set = null,
    ///                 Map = null,
    ///                 Bigint = null,
    ///             },
    ///         },
    ///         new NestedObjectWithRequiredField
    ///         {
    ///             String = "string",
    ///             NestedObject = new ObjectWithOptionalField
    ///             {
    ///                 String = null,
    ///                 Integer = null,
    ///                 Long = null,
    ///                 Double = null,
    ///                 Bool = null,
    ///                 Datetime = null,
    ///                 Date = null,
    ///                 Uuid = null,
    ///                 Base64 = null,
    ///                 List = null,
    ///                 Set = null,
    ///                 Map = null,
    ///                 Bigint = null,
    ///             },
    ///         },
    ///     }
    /// );
    /// </code>
    /// </example>
    public async Task<NestedObjectWithRequiredField> GetAndReturnNestedWithRequiredFieldAsListAsync(
        IEnumerable<NestedObjectWithRequiredField> request,
        RequestOptions? options = null,
        CancellationToken cancellationToken = default
    )
    {
        var response = await _client.MakeRequestAsync(
            new RawClient.JsonApiRequest
            {
                BaseUrl = _client.Options.BaseUrl,
                Method = HttpMethod.Post,
                Path = "/object/get-and-return-nested-with-required-field-list",
                Body = request,
                Options = options,
            },
            cancellationToken
        );
        var responseBody = await response.Raw.Content.ReadAsStringAsync();
        if (response.StatusCode is >= 200 and < 400)
        {
            try
            {
                return JsonUtils.Deserialize<NestedObjectWithRequiredField>(responseBody)!;
            }
            catch (JsonException e)
            {
                throw new SeedExhaustiveException("Failed to deserialize response", e);
            }
        }

        throw new SeedExhaustiveApiException(
            $"Error with status code {response.StatusCode}",
            response.StatusCode,
            responseBody
        );
    }
}
