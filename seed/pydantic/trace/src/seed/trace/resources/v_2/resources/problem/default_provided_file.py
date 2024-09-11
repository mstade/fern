# This file was auto-generated by Fern from our API Definition.

from .....core.pydantic_utilities import UniversalBaseModel
from ....commons.list_type import ListType
from ....commons.map_type import MapType
from .file_info_v_2 import FileInfoV2
import typing
from ....commons.variable_type import VariableType
import pydantic
from .....core.pydantic_utilities import IS_PYDANTIC_V2
from .....core.pydantic_utilities import update_forward_refs


class DefaultProvidedFile(UniversalBaseModel):
    file: FileInfoV2
    related_types: typing.List[VariableType] = pydantic.Field(alias="relatedTypes")

    if IS_PYDANTIC_V2:
        model_config: typing.ClassVar[pydantic.ConfigDict] = pydantic.ConfigDict(extra="allow")  # type: ignore # Pydantic v2
    else:

        class Config:
            extra = pydantic.Extra.allow


update_forward_refs(ListType)
update_forward_refs(MapType)
