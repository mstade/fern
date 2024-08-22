using System.Net.Http;
using System.Text.Json;
using System.Threading;
using SeedLiteral.Core;

#nullable enable

namespace SeedLiteral;

public partial class HeadersClient
{
    private RawClient _client;

    internal HeadersClient(RawClient client)
    {
        _client = client;
    }

    public async Task<SendResponse> SendAsync(
        SendLiteralsInHeadersRequest request,
        RequestOptions? options = null,
        CancellationToken cancellationToken = default
    )
    {
        var _headers = new Headers(
            new Dictionary<string, string>()
            {
                { "X-Endpoint-Version", request.EndpointVersion.ToString() },
                { "X-Async", request.Async.ToString() },
            }
        );
        var requestBody = new Dictionary<string, object>() { { "query", request.Query } };
        var response = await _client.MakeRequestAsync(
            new RawClient.JsonApiRequest
            {
                BaseUrl = _client.Options.BaseUrl,
                Method = HttpMethod.Post,
                Path = "headers",
                Body = requestBody,
                Headers = _headers,
                Options = options,
            },
            cancellationToken
        );
        var responseBody = await response.Raw.Content.ReadAsStringAsync();
        if (response.StatusCode is >= 200 and < 400)
        {
            try
            {
                return JsonUtils.Deserialize<SendResponse>(responseBody)!;
            }
            catch (JsonException e)
            {
                throw new SeedLiteralException("Failed to deserialize response", e);
            }
        }

        throw new SeedLiteralApiException(
            $"Error with status code {response.StatusCode}",
            response.StatusCode,
            responseBody
        );
    }
}
