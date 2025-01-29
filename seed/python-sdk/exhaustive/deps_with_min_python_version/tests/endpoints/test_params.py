# This file was auto-generated by Fern from our API Definition.

from seed import SeedExhaustive
from seed import AsyncSeedExhaustive
import typing
from ..utilities import validate_response


async def test_get_with_path(client: SeedExhaustive, async_client: AsyncSeedExhaustive) -> None:
    expected_response: typing.Any = "string"
    expected_types: typing.Any = None
    response = client.endpoints.params.get_with_path(param="param")
    validate_response(response, expected_response, expected_types)

    async_response = await async_client.endpoints.params.get_with_path(param="param")
    validate_response(async_response, expected_response, expected_types)


async def test_get_with_inline_path(client: SeedExhaustive, async_client: AsyncSeedExhaustive) -> None:
    expected_response: typing.Any = "string"
    expected_types: typing.Any = None
    response = client.endpoints.params.get_with_inline_path(param="param")
    validate_response(response, expected_response, expected_types)

    async_response = await async_client.endpoints.params.get_with_inline_path(param="param")
    validate_response(async_response, expected_response, expected_types)


async def test_get_with_query(client: SeedExhaustive, async_client: AsyncSeedExhaustive) -> None:
    # Type ignore to avoid mypy complaining about the function not being meant to return a value
    assert (
        client.endpoints.params.get_with_query(query="query", number=1)  # type: ignore[func-returns-value]
        is None
    )

    assert (
        await async_client.endpoints.params.get_with_query(query="query", number=1)  # type: ignore[func-returns-value]
        is None
    )


async def test_get_with_allow_multiple_query(client: SeedExhaustive, async_client: AsyncSeedExhaustive) -> None:
    # Type ignore to avoid mypy complaining about the function not being meant to return a value
    assert (
        client.endpoints.params.get_with_allow_multiple_query(query="query", number=1)  # type: ignore[func-returns-value]
        is None
    )

    assert (
        await async_client.endpoints.params.get_with_allow_multiple_query(query="query", number=1)  # type: ignore[func-returns-value]
        is None
    )


async def test_get_with_path_and_query(client: SeedExhaustive, async_client: AsyncSeedExhaustive) -> None:
    # Type ignore to avoid mypy complaining about the function not being meant to return a value
    assert (
        client.endpoints.params.get_with_path_and_query(param="param", query="query")  # type: ignore[func-returns-value]
        is None
    )

    assert (
        await async_client.endpoints.params.get_with_path_and_query(param="param", query="query")  # type: ignore[func-returns-value]
        is None
    )


async def test_get_with_inline_path_and_query(client: SeedExhaustive, async_client: AsyncSeedExhaustive) -> None:
    # Type ignore to avoid mypy complaining about the function not being meant to return a value
    assert (
        client.endpoints.params.get_with_inline_path_and_query(param="param", query="query")  # type: ignore[func-returns-value]
        is None
    )

    assert (
        await async_client.endpoints.params.get_with_inline_path_and_query(param="param", query="query")  # type: ignore[func-returns-value]
        is None
    )


async def test_modify_with_path(client: SeedExhaustive, async_client: AsyncSeedExhaustive) -> None:
    expected_response: typing.Any = "string"
    expected_types: typing.Any = None
    response = client.endpoints.params.modify_with_path(param="param", request="string")
    validate_response(response, expected_response, expected_types)

    async_response = await async_client.endpoints.params.modify_with_path(param="param", request="string")
    validate_response(async_response, expected_response, expected_types)


async def test_modify_with_inline_path(client: SeedExhaustive, async_client: AsyncSeedExhaustive) -> None:
    expected_response: typing.Any = "string"
    expected_types: typing.Any = None
    response = client.endpoints.params.modify_with_inline_path(param="param", request="string")
    validate_response(response, expected_response, expected_types)

    async_response = await async_client.endpoints.params.modify_with_inline_path(param="param", request="string")
    validate_response(async_response, expected_response, expected_types)
