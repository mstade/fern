# This file was auto-generated by Fern from our API Definition.

import typing

from seed.client import AsyncSeedUnknownAsAny, SeedUnknownAsAny

from .utilities import validate_response


async def test_post(client: SeedUnknownAsAny, async_client: AsyncSeedUnknownAsAny) -> None:
    expected_response = [{"key": "value"}]
    expected_types: typing.Any = ("list", {0: None})
    response = client.unknown.post(request={"key": "value"})
    validate_response(response, expected_response, expected_types)

    async_response = await async_client.unknown.post(request={"key": "value"})
    validate_response(async_response, expected_response, expected_types)