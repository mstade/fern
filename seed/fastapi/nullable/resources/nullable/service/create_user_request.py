# This file was auto-generated by Fern from our API Definition.

from ....core.pydantic_utilities import UniversalBaseModel
import typing
from ..types.metadata import Metadata
from ....core.pydantic_utilities import IS_PYDANTIC_V2
import pydantic


class CreateUserRequest(UniversalBaseModel):
    username: str
    tags: typing.Optional[typing.List[str]] = None
    metadata: typing.Optional[Metadata] = None
    avatar: typing.Optional[str] = None

    if IS_PYDANTIC_V2:
        model_config: typing.ClassVar[pydantic.ConfigDict] = pydantic.ConfigDict(
            extra="forbid"
        )  # type: ignore # Pydantic v2
    else:

        class Config:
            extra = pydantic.Extra.forbid
