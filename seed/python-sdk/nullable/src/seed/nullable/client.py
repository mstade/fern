# This file was auto-generated by Fern from our API Definition.

import typing
from ..core.client_wrapper import SyncClientWrapper
from ..core.request_options import RequestOptions
from .types.user import User
from ..core.pydantic_utilities import parse_obj_as
from json.decoder import JSONDecodeError
from ..core.api_error import ApiError
from .types.metadata import Metadata
from ..core.serialization import convert_and_respect_annotation_metadata
from ..core.client_wrapper import AsyncClientWrapper

# this is used as the default value for optional parameters
OMIT = typing.cast(typing.Any, ...)


class NullableClient:
    def __init__(self, *, client_wrapper: SyncClientWrapper):
        self._client_wrapper = client_wrapper

    def get_users(
        self,
        *,
        usernames: typing.Optional[typing.Union[str, typing.Sequence[str]]] = None,
        avatar: typing.Optional[str] = None,
        activated: typing.Optional[typing.Union[bool, typing.Sequence[bool]]] = None,
        tags: typing.Optional[typing.Union[str, typing.Sequence[str]]] = None,
        extra: typing.Optional[bool] = None,
        request_options: typing.Optional[RequestOptions] = None,
    ) -> typing.List[User]:
        """
        Parameters
        ----------
        usernames : typing.Optional[typing.Union[str, typing.Sequence[str]]]

        avatar : typing.Optional[str]

        activated : typing.Optional[typing.Union[bool, typing.Sequence[bool]]]

        tags : typing.Optional[typing.Union[str, typing.Sequence[str]]]

        extra : typing.Optional[bool]

        request_options : typing.Optional[RequestOptions]
            Request-specific configuration.

        Returns
        -------
        typing.List[User]

        Examples
        --------
        from seed import SeedNullable

        client = SeedNullable(
            base_url="https://yourhost.com/path/to/api",
        )
        client.nullable.get_users(
            usernames="usernames",
            avatar="avatar",
            activated=True,
        )
        """
        _response = self._client_wrapper.httpx_client.request(
            "users",
            method="GET",
            params={
                "usernames": usernames,
                "avatar": avatar,
                "activated": activated,
                "tags": tags,
                "extra": extra,
            },
            request_options=request_options,
        )
        try:
            if 200 <= _response.status_code < 300:
                return typing.cast(
                    typing.List[User],
                    parse_obj_as(
                        type_=typing.List[User],  # type: ignore
                        object_=_response.json(),
                    ),
                )
            _response_json = _response.json()
        except JSONDecodeError:
            raise ApiError(status_code=_response.status_code, body=_response.text)
        raise ApiError(status_code=_response.status_code, body=_response_json)

    def create_user(
        self,
        *,
        username: str,
        tags: typing.Optional[typing.Sequence[str]] = OMIT,
        metadata: typing.Optional[Metadata] = OMIT,
        avatar: typing.Optional[str] = OMIT,
        request_options: typing.Optional[RequestOptions] = None,
    ) -> User:
        """
        Parameters
        ----------
        username : str

        tags : typing.Optional[typing.Sequence[str]]

        metadata : typing.Optional[Metadata]

        avatar : typing.Optional[str]

        request_options : typing.Optional[RequestOptions]
            Request-specific configuration.

        Returns
        -------
        User

        Examples
        --------
        import datetime

        from seed import SeedNullable
        from seed.nullable import Metadata

        client = SeedNullable(
            base_url="https://yourhost.com/path/to/api",
        )
        client.nullable.create_user(
            username="username",
            tags=["tags", "tags"],
            metadata=Metadata(
                created_at=datetime.datetime.fromisoformat(
                    "2024-01-15 09:30:00+00:00",
                ),
                updated_at=datetime.datetime.fromisoformat(
                    "2024-01-15 09:30:00+00:00",
                ),
                avatar="avatar",
                activated=True,
            ),
            avatar="avatar",
        )
        """
        _response = self._client_wrapper.httpx_client.request(
            "users",
            method="POST",
            json={
                "username": username,
                "tags": tags,
                "metadata": convert_and_respect_annotation_metadata(
                    object_=metadata, annotation=Metadata, direction="write"
                ),
                "avatar": avatar,
            },
            request_options=request_options,
            omit=OMIT,
        )
        try:
            if 200 <= _response.status_code < 300:
                return typing.cast(
                    User,
                    parse_obj_as(
                        type_=User,  # type: ignore
                        object_=_response.json(),
                    ),
                )
            _response_json = _response.json()
        except JSONDecodeError:
            raise ApiError(status_code=_response.status_code, body=_response.text)
        raise ApiError(status_code=_response.status_code, body=_response_json)

    def delete_user(
        self, *, username: typing.Optional[str] = OMIT, request_options: typing.Optional[RequestOptions] = None
    ) -> bool:
        """
        Parameters
        ----------
        username : typing.Optional[str]
            The user to delete.

        request_options : typing.Optional[RequestOptions]
            Request-specific configuration.

        Returns
        -------
        bool

        Examples
        --------
        from seed import SeedNullable

        client = SeedNullable(
            base_url="https://yourhost.com/path/to/api",
        )
        client.nullable.delete_user(
            username="xy",
        )
        """
        _response = self._client_wrapper.httpx_client.request(
            "users",
            method="DELETE",
            json={
                "username": username,
            },
            request_options=request_options,
            omit=OMIT,
        )
        try:
            if 200 <= _response.status_code < 300:
                return typing.cast(
                    bool,
                    parse_obj_as(
                        type_=bool,  # type: ignore
                        object_=_response.json(),
                    ),
                )
            _response_json = _response.json()
        except JSONDecodeError:
            raise ApiError(status_code=_response.status_code, body=_response.text)
        raise ApiError(status_code=_response.status_code, body=_response_json)


class AsyncNullableClient:
    def __init__(self, *, client_wrapper: AsyncClientWrapper):
        self._client_wrapper = client_wrapper

    async def get_users(
        self,
        *,
        usernames: typing.Optional[typing.Union[str, typing.Sequence[str]]] = None,
        avatar: typing.Optional[str] = None,
        activated: typing.Optional[typing.Union[bool, typing.Sequence[bool]]] = None,
        tags: typing.Optional[typing.Union[str, typing.Sequence[str]]] = None,
        extra: typing.Optional[bool] = None,
        request_options: typing.Optional[RequestOptions] = None,
    ) -> typing.List[User]:
        """
        Parameters
        ----------
        usernames : typing.Optional[typing.Union[str, typing.Sequence[str]]]

        avatar : typing.Optional[str]

        activated : typing.Optional[typing.Union[bool, typing.Sequence[bool]]]

        tags : typing.Optional[typing.Union[str, typing.Sequence[str]]]

        extra : typing.Optional[bool]

        request_options : typing.Optional[RequestOptions]
            Request-specific configuration.

        Returns
        -------
        typing.List[User]

        Examples
        --------
        import asyncio

        from seed import AsyncSeedNullable

        client = AsyncSeedNullable(
            base_url="https://yourhost.com/path/to/api",
        )


        async def main() -> None:
            await client.nullable.get_users(
                usernames="usernames",
                avatar="avatar",
                activated=True,
            )


        asyncio.run(main())
        """
        _response = await self._client_wrapper.httpx_client.request(
            "users",
            method="GET",
            params={
                "usernames": usernames,
                "avatar": avatar,
                "activated": activated,
                "tags": tags,
                "extra": extra,
            },
            request_options=request_options,
        )
        try:
            if 200 <= _response.status_code < 300:
                return typing.cast(
                    typing.List[User],
                    parse_obj_as(
                        type_=typing.List[User],  # type: ignore
                        object_=_response.json(),
                    ),
                )
            _response_json = _response.json()
        except JSONDecodeError:
            raise ApiError(status_code=_response.status_code, body=_response.text)
        raise ApiError(status_code=_response.status_code, body=_response_json)

    async def create_user(
        self,
        *,
        username: str,
        tags: typing.Optional[typing.Sequence[str]] = OMIT,
        metadata: typing.Optional[Metadata] = OMIT,
        avatar: typing.Optional[str] = OMIT,
        request_options: typing.Optional[RequestOptions] = None,
    ) -> User:
        """
        Parameters
        ----------
        username : str

        tags : typing.Optional[typing.Sequence[str]]

        metadata : typing.Optional[Metadata]

        avatar : typing.Optional[str]

        request_options : typing.Optional[RequestOptions]
            Request-specific configuration.

        Returns
        -------
        User

        Examples
        --------
        import asyncio
        import datetime

        from seed import AsyncSeedNullable
        from seed.nullable import Metadata

        client = AsyncSeedNullable(
            base_url="https://yourhost.com/path/to/api",
        )


        async def main() -> None:
            await client.nullable.create_user(
                username="username",
                tags=["tags", "tags"],
                metadata=Metadata(
                    created_at=datetime.datetime.fromisoformat(
                        "2024-01-15 09:30:00+00:00",
                    ),
                    updated_at=datetime.datetime.fromisoformat(
                        "2024-01-15 09:30:00+00:00",
                    ),
                    avatar="avatar",
                    activated=True,
                ),
                avatar="avatar",
            )


        asyncio.run(main())
        """
        _response = await self._client_wrapper.httpx_client.request(
            "users",
            method="POST",
            json={
                "username": username,
                "tags": tags,
                "metadata": convert_and_respect_annotation_metadata(
                    object_=metadata, annotation=Metadata, direction="write"
                ),
                "avatar": avatar,
            },
            request_options=request_options,
            omit=OMIT,
        )
        try:
            if 200 <= _response.status_code < 300:
                return typing.cast(
                    User,
                    parse_obj_as(
                        type_=User,  # type: ignore
                        object_=_response.json(),
                    ),
                )
            _response_json = _response.json()
        except JSONDecodeError:
            raise ApiError(status_code=_response.status_code, body=_response.text)
        raise ApiError(status_code=_response.status_code, body=_response_json)

    async def delete_user(
        self, *, username: typing.Optional[str] = OMIT, request_options: typing.Optional[RequestOptions] = None
    ) -> bool:
        """
        Parameters
        ----------
        username : typing.Optional[str]
            The user to delete.

        request_options : typing.Optional[RequestOptions]
            Request-specific configuration.

        Returns
        -------
        bool

        Examples
        --------
        import asyncio

        from seed import AsyncSeedNullable

        client = AsyncSeedNullable(
            base_url="https://yourhost.com/path/to/api",
        )


        async def main() -> None:
            await client.nullable.delete_user(
                username="xy",
            )


        asyncio.run(main())
        """
        _response = await self._client_wrapper.httpx_client.request(
            "users",
            method="DELETE",
            json={
                "username": username,
            },
            request_options=request_options,
            omit=OMIT,
        )
        try:
            if 200 <= _response.status_code < 300:
                return typing.cast(
                    bool,
                    parse_obj_as(
                        type_=bool,  # type: ignore
                        object_=_response.json(),
                    ),
                )
            _response_json = _response.json()
        except JSONDecodeError:
            raise ApiError(status_code=_response.status_code, body=_response.text)
        raise ApiError(status_code=_response.status_code, body=_response_json)
