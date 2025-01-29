# This file was auto-generated by Fern from our API Definition.

import typing
from ..core.client_wrapper import SyncClientWrapper
from .requests.container_object import ContainerObjectParams
from .types.some_literal import SomeLiteral
from ..core.request_options import RequestOptions
from ..types.send_response import SendResponse
from ..core.serialization import convert_and_respect_annotation_metadata
from ..core.pydantic_utilities import parse_obj_as
from json.decoder import JSONDecodeError
from ..core.api_error import ApiError
from ..core.client_wrapper import AsyncClientWrapper

# this is used as the default value for optional parameters
OMIT = typing.cast(typing.Any, ...)


class ReferenceClient:
    def __init__(self, *, client_wrapper: SyncClientWrapper):
        self._client_wrapper = client_wrapper

    def send(
        self,
        *,
        query: str,
        container_object: ContainerObjectParams,
        maybe_context: typing.Optional[SomeLiteral] = OMIT,
        request_options: typing.Optional[RequestOptions] = None,
    ) -> SendResponse:
        """
        Parameters
        ----------
        query : str

        container_object : ContainerObjectParams

        maybe_context : typing.Optional[SomeLiteral]

        request_options : typing.Optional[RequestOptions]
            Request-specific configuration.

        Returns
        -------
        SendResponse

        Examples
        --------
        from seed import SeedLiteral

        client = SeedLiteral(
            base_url="https://yourhost.com/path/to/api",
        )
        client.reference.send(
            query="What is the weather today",
            container_object={
                "nested_objects": [
                    {
                        "literal_1": "literal1",
                        "literal_2": "literal2",
                        "str_prop": "strProp",
                    }
                ]
            },
        )
        """
        _response = self._client_wrapper.httpx_client.request(
            "reference",
            method="POST",
            json={
                "query": query,
                "maybeContext": maybe_context,
                "containerObject": convert_and_respect_annotation_metadata(
                    object_=container_object, annotation=ContainerObjectParams, direction="write"
                ),
                "prompt": "You are a helpful assistant",
                "stream": False,
                "ending": "$ending",
                "context": "You're super wise",
            },
            request_options=request_options,
            omit=OMIT,
        )
        try:
            if 200 <= _response.status_code < 300:
                return typing.cast(
                    SendResponse,
                    parse_obj_as(
                        type_=SendResponse,  # type: ignore
                        object_=_response.json(),
                    ),
                )
            _response_json = _response.json()
        except JSONDecodeError:
            raise ApiError(status_code=_response.status_code, body=_response.text)
        raise ApiError(status_code=_response.status_code, body=_response_json)


class AsyncReferenceClient:
    def __init__(self, *, client_wrapper: AsyncClientWrapper):
        self._client_wrapper = client_wrapper

    async def send(
        self,
        *,
        query: str,
        container_object: ContainerObjectParams,
        maybe_context: typing.Optional[SomeLiteral] = OMIT,
        request_options: typing.Optional[RequestOptions] = None,
    ) -> SendResponse:
        """
        Parameters
        ----------
        query : str

        container_object : ContainerObjectParams

        maybe_context : typing.Optional[SomeLiteral]

        request_options : typing.Optional[RequestOptions]
            Request-specific configuration.

        Returns
        -------
        SendResponse

        Examples
        --------
        import asyncio

        from seed import AsyncSeedLiteral

        client = AsyncSeedLiteral(
            base_url="https://yourhost.com/path/to/api",
        )


        async def main() -> None:
            await client.reference.send(
                query="What is the weather today",
                container_object={
                    "nested_objects": [
                        {
                            "literal_1": "literal1",
                            "literal_2": "literal2",
                            "str_prop": "strProp",
                        }
                    ]
                },
            )


        asyncio.run(main())
        """
        _response = await self._client_wrapper.httpx_client.request(
            "reference",
            method="POST",
            json={
                "query": query,
                "maybeContext": maybe_context,
                "containerObject": convert_and_respect_annotation_metadata(
                    object_=container_object, annotation=ContainerObjectParams, direction="write"
                ),
                "prompt": "You are a helpful assistant",
                "stream": False,
                "ending": "$ending",
                "context": "You're super wise",
            },
            request_options=request_options,
            omit=OMIT,
        )
        try:
            if 200 <= _response.status_code < 300:
                return typing.cast(
                    SendResponse,
                    parse_obj_as(
                        type_=SendResponse,  # type: ignore
                        object_=_response.json(),
                    ),
                )
            _response_json = _response.json()
        except JSONDecodeError:
            raise ApiError(status_code=_response.status_code, body=_response.text)
        raise ApiError(status_code=_response.status_code, body=_response_json)
