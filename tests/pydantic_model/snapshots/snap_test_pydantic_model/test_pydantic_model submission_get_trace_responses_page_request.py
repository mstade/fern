# This file was auto-generated by Fern from our API Definition.

from __future__ import annotations

import typing

import pydantic
import typing_extensions


class GetTraceResponsesPageRequest(pydantic.BaseModel):
    offset: typing.Optional[int]

    class Partial(typing_extensions.TypedDict):
        offset: typing_extensions.NotRequired[typing.Optional[int]]

    class Validators:
        """
        Use this class to add validators to the Pydantic model.

            @GetTraceResponsesPageRequest.Validators.root
            def validate(values: GetTraceResponsesPageRequest.Partial) -> GetTraceResponsesPageRequest.Partial:
                ...

            @GetTraceResponsesPageRequest.Validators.field("offset")
            def validate_offset(offset: typing.Optional[int], values: GetTraceResponsesPageRequest.Partial) -> typing.Optional[int]:
                ...
        """

        _validators: typing.ClassVar[
            typing.List[typing.Callable[[GetTraceResponsesPageRequest.Partial], GetTraceResponsesPageRequest.Partial]]
        ] = []
        _offset_pre_validators: typing.ClassVar[
            typing.List[GetTraceResponsesPageRequest.Validators.OffsetValidator]
        ] = []
        _offset_post_validators: typing.ClassVar[
            typing.List[GetTraceResponsesPageRequest.Validators.OffsetValidator]
        ] = []

        @classmethod
        def root(
            cls,
            validator: typing.Callable[[GetTraceResponsesPageRequest.Partial], GetTraceResponsesPageRequest.Partial],
        ) -> typing.Callable[[GetTraceResponsesPageRequest.Partial], GetTraceResponsesPageRequest.Partial]:
            cls._validators.append(validator)
            return validator

        @typing.overload  # type: ignore
        @classmethod
        def field(
            cls, field_name: typing_extensions.Literal["offset"]
        ) -> typing.Callable[
            [GetTraceResponsesPageRequest.Validators.OffsetValidator],
            GetTraceResponsesPageRequest.Validators.OffsetValidator,
        ]:
            ...

        @classmethod
        def field(cls, field_name: str, *, pre: bool = False) -> typing.Any:
            def decorator(validator: typing.Any) -> typing.Any:
                if field_name == "offset":
                    if pre:
                        cls._offset_post_validators.append(validator)
                    else:
                        cls._offset_post_validators.append(validator)
                return validator

            return decorator

        class OffsetValidator(typing_extensions.Protocol):
            def __call__(
                self, __v: typing.Optional[int], __values: GetTraceResponsesPageRequest.Partial
            ) -> typing.Optional[int]:
                ...

    @pydantic.root_validator
    def _validate(cls, values: GetTraceResponsesPageRequest.Partial) -> GetTraceResponsesPageRequest.Partial:
        for validator in GetTraceResponsesPageRequest.Validators._validators:
            values = validator(values)
        return values

    @pydantic.validator("offset", pre=True)
    def _pre_validate_offset(
        cls, v: typing.Optional[int], values: GetTraceResponsesPageRequest.Partial
    ) -> typing.Optional[int]:
        for validator in GetTraceResponsesPageRequest.Validators._offset_pre_validators:
            v = validator(v, values)
        return v

    @pydantic.validator("offset", pre=False)
    def _post_validate_offset(
        cls, v: typing.Optional[int], values: GetTraceResponsesPageRequest.Partial
    ) -> typing.Optional[int]:
        for validator in GetTraceResponsesPageRequest.Validators._offset_post_validators:
            v = validator(v, values)
        return v

    def json(self, **kwargs: typing.Any) -> str:
        kwargs_with_defaults: typing.Any = {"by_alias": True, **kwargs}
        return super().json(**kwargs_with_defaults)

    def dict(self, **kwargs: typing.Any) -> typing.Dict[str, typing.Any]:
        kwargs_with_defaults: typing.Any = {"by_alias": True, **kwargs}
        return super().dict(**kwargs_with_defaults)

    class Config:
        frozen = True
