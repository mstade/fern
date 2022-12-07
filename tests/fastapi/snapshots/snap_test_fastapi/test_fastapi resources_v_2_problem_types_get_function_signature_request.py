# This file was auto-generated by Fern from our API Definition.

from __future__ import annotations

import typing

import pydantic
import typing_extensions

from .function_signature import FunctionSignature


class GetFunctionSignatureRequest(pydantic.BaseModel):
    function_signature: FunctionSignature = pydantic.Field(alias="functionSignature")

    class Partial(typing_extensions.TypedDict):
        function_signature: typing_extensions.NotRequired[FunctionSignature]

    class Validators:
        """
        Use this class to add validators to the Pydantic model.

            @GetFunctionSignatureRequest.Validators.root
            def validate(values: GetFunctionSignatureRequest.Partial) -> GetFunctionSignatureRequest.Partial:
                ...

            @GetFunctionSignatureRequest.Validators.field("function_signature")
            def validate_function_signature(function_signature: FunctionSignature, values: GetFunctionSignatureRequest.Partial) -> FunctionSignature:
                ...
        """

        _validators: typing.ClassVar[
            typing.List[typing.Callable[[GetFunctionSignatureRequest.Partial], GetFunctionSignatureRequest.Partial]]
        ] = []
        _function_signature_pre_validators: typing.ClassVar[
            typing.List[GetFunctionSignatureRequest.Validators.FunctionSignatureValidator]
        ] = []
        _function_signature_post_validators: typing.ClassVar[
            typing.List[GetFunctionSignatureRequest.Validators.FunctionSignatureValidator]
        ] = []

        @classmethod
        def root(
            cls, validator: typing.Callable[[GetFunctionSignatureRequest.Partial], GetFunctionSignatureRequest.Partial]
        ) -> typing.Callable[[GetFunctionSignatureRequest.Partial], GetFunctionSignatureRequest.Partial]:
            cls._validators.append(validator)
            return validator

        @typing.overload  # type: ignore
        @classmethod
        def field(
            cls, field_name: typing_extensions.Literal["function_signature"]
        ) -> typing.Callable[
            [GetFunctionSignatureRequest.Validators.FunctionSignatureValidator],
            GetFunctionSignatureRequest.Validators.FunctionSignatureValidator,
        ]:
            ...

        @classmethod
        def field(cls, field_name: str, *, pre: bool = False) -> typing.Any:
            def decorator(validator: typing.Any) -> typing.Any:
                if field_name == "function_signature":
                    if pre:
                        cls._function_signature_post_validators.append(validator)
                    else:
                        cls._function_signature_post_validators.append(validator)
                return validator

            return decorator

        class FunctionSignatureValidator(typing_extensions.Protocol):
            def __call__(
                self, __v: FunctionSignature, __values: GetFunctionSignatureRequest.Partial
            ) -> FunctionSignature:
                ...

    @pydantic.root_validator
    def _validate(cls, values: GetFunctionSignatureRequest.Partial) -> GetFunctionSignatureRequest.Partial:
        for validator in GetFunctionSignatureRequest.Validators._validators:
            values = validator(values)
        return values

    @pydantic.validator("function_signature", pre=True)
    def _pre_validate_function_signature(
        cls, v: FunctionSignature, values: GetFunctionSignatureRequest.Partial
    ) -> FunctionSignature:
        for validator in GetFunctionSignatureRequest.Validators._function_signature_pre_validators:
            v = validator(v, values)
        return v

    @pydantic.validator("function_signature", pre=False)
    def _post_validate_function_signature(
        cls, v: FunctionSignature, values: GetFunctionSignatureRequest.Partial
    ) -> FunctionSignature:
        for validator in GetFunctionSignatureRequest.Validators._function_signature_post_validators:
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
        allow_population_by_field_name = True
        extra = pydantic.Extra.forbid
