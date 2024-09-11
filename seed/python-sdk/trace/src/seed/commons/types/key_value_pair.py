# This file was auto-generated by Fern from our API Definition.

from __future__ import annotations
from ...core.pydantic_utilities import UniversalBaseModel
from ...core.pydantic_utilities import IS_PYDANTIC_V2
import typing
import pydantic
from ...core.pydantic_utilities import update_forward_refs


class KeyValuePair(UniversalBaseModel):
    key: "VariableValue"
    value: "VariableValue"

    if IS_PYDANTIC_V2:
        model_config: typing.ClassVar[pydantic.ConfigDict] = pydantic.ConfigDict(extra="allow", frozen=True)  # type: ignore # Pydantic v2
    else:

        class Config:
            frozen = True
            smart_union = True
            extra = pydantic.Extra.allow


from .map_value import MapValue  # noqa: E402
from .variable_value import VariableValue  # noqa: E402

update_forward_refs(MapValue)
update_forward_refs(MapValue)
update_forward_refs(KeyValuePair)
