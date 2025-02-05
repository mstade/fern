<?php

namespace Seed\V2\Problem;

use GuzzleHttp\ClientInterface;
use Seed\Core\Client\RawClient;
use Seed\V2\Problem\Types\LightweightProblemInfoV2;
use Seed\Exceptions\SeedException;
use Seed\Exceptions\SeedApiException;
use Seed\Core\Json\JsonApiRequest;
use Seed\Environments;
use Seed\Core\Client\HttpMethod;
use Seed\Core\Json\JsonDecoder;
use JsonException;
use Psr\Http\Client\ClientExceptionInterface;
use Seed\V2\Problem\Types\ProblemInfoV2;

class ProblemClient
{
    /**
     * @var array{
     *   baseUrl?: string,
     *   client?: ClientInterface,
     *   headers?: array<string, string>,
     *   maxRetries?: int,
     * } $options
     */
    private array $options;

    /**
     * @var RawClient $client
     */
    private RawClient $client;

    /**
     * @param RawClient $client
     * @param ?array{
     *   baseUrl?: string,
     *   client?: ClientInterface,
     *   headers?: array<string, string>,
     *   maxRetries?: int,
     * } $options
     */
    public function __construct(
        RawClient $client,
        ?array $options = null,
    ) {
        $this->client = $client;
        $this->options = $options ?? [];
    }

    /**
     * Returns lightweight versions of all problems
     *
     * @param ?array{
     *   baseUrl?: string,
     *   maxRetries?: int,
     * } $options
     * @return array<LightweightProblemInfoV2>
     * @throws SeedException
     * @throws SeedApiException
     */
    public function getLightweightProblems(?array $options = null): array
    {
        $options = array_merge($this->options, $options ?? []);
        try {
            $response = $this->client->sendRequest(
                new JsonApiRequest(
                    baseUrl: $options['baseUrl'] ?? $this->client->options['baseUrl'] ?? Environments::Prod->value,
                    path: "/problems-v2/lightweight-problem-info",
                    method: HttpMethod::GET,
                ),
                $options,
            );
            $statusCode = $response->getStatusCode();
            if ($statusCode >= 200 && $statusCode < 400) {
                $json = $response->getBody()->getContents();
                return JsonDecoder::decodeArray($json, [LightweightProblemInfoV2::class]); // @phpstan-ignore-line
            }
        } catch (JsonException $e) {
            throw new SeedException(message: "Failed to deserialize response: {$e->getMessage()}", previous: $e);
        } catch (ClientExceptionInterface $e) {
            throw new SeedException(message: $e->getMessage(), previous: $e);
        }
        throw new SeedApiException(
            message: 'API request failed',
            statusCode: $statusCode,
            body: $response->getBody()->getContents(),
        );
    }

    /**
     * Returns latest versions of all problems
     *
     * @param ?array{
     *   baseUrl?: string,
     *   maxRetries?: int,
     * } $options
     * @return array<ProblemInfoV2>
     * @throws SeedException
     * @throws SeedApiException
     */
    public function getProblems(?array $options = null): array
    {
        $options = array_merge($this->options, $options ?? []);
        try {
            $response = $this->client->sendRequest(
                new JsonApiRequest(
                    baseUrl: $options['baseUrl'] ?? $this->client->options['baseUrl'] ?? Environments::Prod->value,
                    path: "/problems-v2/problem-info",
                    method: HttpMethod::GET,
                ),
                $options,
            );
            $statusCode = $response->getStatusCode();
            if ($statusCode >= 200 && $statusCode < 400) {
                $json = $response->getBody()->getContents();
                return JsonDecoder::decodeArray($json, [ProblemInfoV2::class]); // @phpstan-ignore-line
            }
        } catch (JsonException $e) {
            throw new SeedException(message: "Failed to deserialize response: {$e->getMessage()}", previous: $e);
        } catch (ClientExceptionInterface $e) {
            throw new SeedException(message: $e->getMessage(), previous: $e);
        }
        throw new SeedApiException(
            message: 'API request failed',
            statusCode: $statusCode,
            body: $response->getBody()->getContents(),
        );
    }

    /**
     * Returns latest version of a problem
     *
     * @param string $problemId
     * @param ?array{
     *   baseUrl?: string,
     *   maxRetries?: int,
     * } $options
     * @return ProblemInfoV2
     * @throws SeedException
     * @throws SeedApiException
     */
    public function getLatestProblem(string $problemId, ?array $options = null): ProblemInfoV2
    {
        $options = array_merge($this->options, $options ?? []);
        try {
            $response = $this->client->sendRequest(
                new JsonApiRequest(
                    baseUrl: $options['baseUrl'] ?? $this->client->options['baseUrl'] ?? Environments::Prod->value,
                    path: "/problems-v2/problem-info/$problemId",
                    method: HttpMethod::GET,
                ),
                $options,
            );
            $statusCode = $response->getStatusCode();
            if ($statusCode >= 200 && $statusCode < 400) {
                $json = $response->getBody()->getContents();
                return ProblemInfoV2::fromJson($json);
            }
        } catch (JsonException $e) {
            throw new SeedException(message: "Failed to deserialize response: {$e->getMessage()}", previous: $e);
        } catch (ClientExceptionInterface $e) {
            throw new SeedException(message: $e->getMessage(), previous: $e);
        }
        throw new SeedApiException(
            message: 'API request failed',
            statusCode: $statusCode,
            body: $response->getBody()->getContents(),
        );
    }

    /**
     * Returns requested version of a problem
     *
     * @param string $problemId
     * @param int $problemVersion
     * @param ?array{
     *   baseUrl?: string,
     *   maxRetries?: int,
     * } $options
     * @return ProblemInfoV2
     * @throws SeedException
     * @throws SeedApiException
     */
    public function getProblemVersion(string $problemId, int $problemVersion, ?array $options = null): ProblemInfoV2
    {
        $options = array_merge($this->options, $options ?? []);
        try {
            $response = $this->client->sendRequest(
                new JsonApiRequest(
                    baseUrl: $options['baseUrl'] ?? $this->client->options['baseUrl'] ?? Environments::Prod->value,
                    path: "/problems-v2/problem-info/$problemId/version/$problemVersion",
                    method: HttpMethod::GET,
                ),
                $options,
            );
            $statusCode = $response->getStatusCode();
            if ($statusCode >= 200 && $statusCode < 400) {
                $json = $response->getBody()->getContents();
                return ProblemInfoV2::fromJson($json);
            }
        } catch (JsonException $e) {
            throw new SeedException(message: "Failed to deserialize response: {$e->getMessage()}", previous: $e);
        } catch (ClientExceptionInterface $e) {
            throw new SeedException(message: $e->getMessage(), previous: $e);
        }
        throw new SeedApiException(
            message: 'API request failed',
            statusCode: $statusCode,
            body: $response->getBody()->getContents(),
        );
    }
}
