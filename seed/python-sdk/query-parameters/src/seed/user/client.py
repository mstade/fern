# This file was auto-generated by Fern from our API Definition.

from ..core.client_wrapper import SyncClientWrapper
import uuid
import datetime as dt
from .types.user import User
import typing
from .types.nested_user import NestedUser
from ..core.request_options import RequestOptions
from ..core.datetime_utils import serialize_datetime
from ..core.serialization import convert_and_respect_annotation_metadata
from ..core.pydantic_utilities import parse_obj_as
from json.decoder import JSONDecodeError
from ..core.api_error import ApiError
from ..core.client_wrapper import AsyncClientWrapper


class UserClient:
    def __init__(self, *, client_wrapper: SyncClientWrapper):
        self._client_wrapper = client_wrapper

    def get_username(
        self,
        *,
        limit: int,
        id: uuid.UUID,
        date: dt.date,
        deadline: dt.datetime,
        bytes: str,
        user: User,
        user_list: typing.Sequence[User],
        key_value: typing.Dict[str, str],
        nested_user: NestedUser,
        exclude_user: typing.Union[User, typing.Sequence[User]],
        filter: typing.Union[str, typing.Sequence[str]],
        optional_deadline: typing.Optional[dt.datetime] = None,
        optional_string: typing.Optional[str] = None,
        optional_user: typing.Optional[User] = None,
        request_options: typing.Optional[RequestOptions] = None,
    ) -> User:
        """
        Parameters
        ----------
        limit : int

        id : uuid.UUID

        date : dt.date

        deadline : dt.datetime

        bytes : str

        user : User

        user_list : typing.Sequence[User]

        key_value : typing.Dict[str, str]

        nested_user : NestedUser

        exclude_user : typing.Union[User, typing.Sequence[User]]

        filter : typing.Union[str, typing.Sequence[str]]

        optional_deadline : typing.Optional[dt.datetime]

        optional_string : typing.Optional[str]

        optional_user : typing.Optional[User]

        request_options : typing.Optional[RequestOptions]
            Request-specific configuration.

        Returns
        -------
        User

        Examples
        --------
        import datetime
        import uuid

        from seed import SeedQueryParameters
        from seed.user import NestedUser, User

        client = SeedQueryParameters(
            base_url="https://yourhost.com/path/to/api",
        )
        client.user.get_username(
            limit=1,
            id=uuid.UUID(
                "d5e9c84f-c2b2-4bf4-b4b0-7ffd7a9ffc32",
            ),
            date=datetime.date.fromisoformat(
                "2023-01-15",
            ),
            deadline=datetime.datetime.fromisoformat(
                "2024-01-15 09:30:00+00:00",
            ),
            bytes="SGVsbG8gd29ybGQh",
            user=User(
                name="name",
                tags=["tags", "tags"],
            ),
            user_list=[
                User(
                    name="name",
                    tags=["tags", "tags"],
                ),
                User(
                    name="name",
                    tags=["tags", "tags"],
                ),
            ],
            optional_deadline=datetime.datetime.fromisoformat(
                "2024-01-15 09:30:00+00:00",
            ),
            key_value={"keyValue": "keyValue"},
            optional_string="optionalString",
            nested_user=NestedUser(
                name="name",
                user=User(
                    name="name",
                    tags=["tags", "tags"],
                ),
            ),
            optional_user=User(
                name="name",
                tags=["tags", "tags"],
            ),
            exclude_user=User(
                name="name",
                tags=["tags", "tags"],
            ),
            filter="filter",
        )
        """
        _response = self._client_wrapper.httpx_client.request(
            "user",
            method="GET",
            params={
                "limit": limit,
                "id": id,
                "date": str(date),
                "deadline": serialize_datetime(deadline),
                "bytes": bytes,
                "user": convert_and_respect_annotation_metadata(object_=user, annotation=User, direction="write"),
                "userList": convert_and_respect_annotation_metadata(
                    object_=user_list, annotation=typing.Sequence[User], direction="write"
                ),
                "optionalDeadline": serialize_datetime(optional_deadline) if optional_deadline is not None else None,
                "keyValue": key_value,
                "optionalString": optional_string,
                "nestedUser": convert_and_respect_annotation_metadata(
                    object_=nested_user, annotation=NestedUser, direction="write"
                ),
                "optionalUser": convert_and_respect_annotation_metadata(
                    object_=optional_user, annotation=User, direction="write"
                ),
                "excludeUser": convert_and_respect_annotation_metadata(
                    object_=exclude_user, annotation=User, direction="write"
                ),
                "filter": filter,
            },
            request_options=request_options,
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


class AsyncUserClient:
    def __init__(self, *, client_wrapper: AsyncClientWrapper):
        self._client_wrapper = client_wrapper

    async def get_username(
        self,
        *,
        limit: int,
        id: uuid.UUID,
        date: dt.date,
        deadline: dt.datetime,
        bytes: str,
        user: User,
        user_list: typing.Sequence[User],
        key_value: typing.Dict[str, str],
        nested_user: NestedUser,
        exclude_user: typing.Union[User, typing.Sequence[User]],
        filter: typing.Union[str, typing.Sequence[str]],
        optional_deadline: typing.Optional[dt.datetime] = None,
        optional_string: typing.Optional[str] = None,
        optional_user: typing.Optional[User] = None,
        request_options: typing.Optional[RequestOptions] = None,
    ) -> User:
        """
        Parameters
        ----------
        limit : int

        id : uuid.UUID

        date : dt.date

        deadline : dt.datetime

        bytes : str

        user : User

        user_list : typing.Sequence[User]

        key_value : typing.Dict[str, str]

        nested_user : NestedUser

        exclude_user : typing.Union[User, typing.Sequence[User]]

        filter : typing.Union[str, typing.Sequence[str]]

        optional_deadline : typing.Optional[dt.datetime]

        optional_string : typing.Optional[str]

        optional_user : typing.Optional[User]

        request_options : typing.Optional[RequestOptions]
            Request-specific configuration.

        Returns
        -------
        User

        Examples
        --------
        import asyncio
        import datetime
        import uuid

        from seed import AsyncSeedQueryParameters
        from seed.user import NestedUser, User

        client = AsyncSeedQueryParameters(
            base_url="https://yourhost.com/path/to/api",
        )


        async def main() -> None:
            await client.user.get_username(
                limit=1,
                id=uuid.UUID(
                    "d5e9c84f-c2b2-4bf4-b4b0-7ffd7a9ffc32",
                ),
                date=datetime.date.fromisoformat(
                    "2023-01-15",
                ),
                deadline=datetime.datetime.fromisoformat(
                    "2024-01-15 09:30:00+00:00",
                ),
                bytes="SGVsbG8gd29ybGQh",
                user=User(
                    name="name",
                    tags=["tags", "tags"],
                ),
                user_list=[
                    User(
                        name="name",
                        tags=["tags", "tags"],
                    ),
                    User(
                        name="name",
                        tags=["tags", "tags"],
                    ),
                ],
                optional_deadline=datetime.datetime.fromisoformat(
                    "2024-01-15 09:30:00+00:00",
                ),
                key_value={"keyValue": "keyValue"},
                optional_string="optionalString",
                nested_user=NestedUser(
                    name="name",
                    user=User(
                        name="name",
                        tags=["tags", "tags"],
                    ),
                ),
                optional_user=User(
                    name="name",
                    tags=["tags", "tags"],
                ),
                exclude_user=User(
                    name="name",
                    tags=["tags", "tags"],
                ),
                filter="filter",
            )


        asyncio.run(main())
        """
        _response = await self._client_wrapper.httpx_client.request(
            "user",
            method="GET",
            params={
                "limit": limit,
                "id": id,
                "date": str(date),
                "deadline": serialize_datetime(deadline),
                "bytes": bytes,
                "user": convert_and_respect_annotation_metadata(object_=user, annotation=User, direction="write"),
                "userList": convert_and_respect_annotation_metadata(
                    object_=user_list, annotation=typing.Sequence[User], direction="write"
                ),
                "optionalDeadline": serialize_datetime(optional_deadline) if optional_deadline is not None else None,
                "keyValue": key_value,
                "optionalString": optional_string,
                "nestedUser": convert_and_respect_annotation_metadata(
                    object_=nested_user, annotation=NestedUser, direction="write"
                ),
                "optionalUser": convert_and_respect_annotation_metadata(
                    object_=optional_user, annotation=User, direction="write"
                ),
                "excludeUser": convert_and_respect_annotation_metadata(
                    object_=exclude_user, annotation=User, direction="write"
                ),
                "filter": filter,
            },
            request_options=request_options,
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
