# This file was auto-generated by Fern from our API Definition.

from __future__ import annotations
from ...core.pydantic_utilities import UniversalBaseModel
from ...core.pydantic_utilities import IS_PYDANTIC_V2
import typing
import pydantic
from ...core.pydantic_utilities import update_forward_refs


class DebugKeyValuePairs(UniversalBaseModel):
    key: "DebugVariableValue"
    value: "DebugVariableValue"

    if IS_PYDANTIC_V2:
        model_config: typing.ClassVar[pydantic.ConfigDict] = pydantic.ConfigDict(extra="allow")  # type: ignore # Pydantic v2
    else:

        class Config:
            extra = pydantic.Extra.allow


from .debug_map_value import DebugMapValue  # noqa: E402
from .debug_variable_value import DebugVariableValue  # noqa: E402

update_forward_refs(DebugMapValue)
update_forward_refs(DebugMapValue)
update_forward_refs(DebugKeyValuePairs)
