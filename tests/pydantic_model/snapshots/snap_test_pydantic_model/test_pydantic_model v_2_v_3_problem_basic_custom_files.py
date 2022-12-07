# This file was auto-generated by Fern from our API Definition.

from __future__ import annotations

import typing

import pydantic
import typing_extensions

from ....commons.language import Language
from .basic_test_case_template import BasicTestCaseTemplate
from .files import Files
from .non_void_function_signature import NonVoidFunctionSignature


class BasicCustomFiles(pydantic.BaseModel):
    method_name: str = pydantic.Field(alias="methodName")
    signature: NonVoidFunctionSignature
    additional_files: typing.Dict[Language, Files] = pydantic.Field(alias="additionalFiles")
    basic_test_case_template: BasicTestCaseTemplate = pydantic.Field(alias="basicTestCaseTemplate")

    class Partial(typing_extensions.TypedDict):
        method_name: typing_extensions.NotRequired[str]
        signature: typing_extensions.NotRequired[NonVoidFunctionSignature]
        additional_files: typing_extensions.NotRequired[typing.Dict[Language, Files]]
        basic_test_case_template: typing_extensions.NotRequired[BasicTestCaseTemplate]

    class Validators:
        """
        Use this class to add validators to the Pydantic model.

            @BasicCustomFiles.Validators.root
            def validate(values: BasicCustomFiles.Partial) -> BasicCustomFiles.Partial:
                ...

            @BasicCustomFiles.Validators.field("method_name")
            def validate_method_name(method_name: str, values: BasicCustomFiles.Partial) -> str:
                ...

            @BasicCustomFiles.Validators.field("signature")
            def validate_signature(signature: NonVoidFunctionSignature, values: BasicCustomFiles.Partial) -> NonVoidFunctionSignature:
                ...

            @BasicCustomFiles.Validators.field("additional_files")
            def validate_additional_files(additional_files: typing.Dict[Language, Files], values: BasicCustomFiles.Partial) -> typing.Dict[Language, Files]:
                ...

            @BasicCustomFiles.Validators.field("basic_test_case_template")
            def validate_basic_test_case_template(basic_test_case_template: BasicTestCaseTemplate, values: BasicCustomFiles.Partial) -> BasicTestCaseTemplate:
                ...
        """

        _validators: typing.ClassVar[
            typing.List[typing.Callable[[BasicCustomFiles.Partial], BasicCustomFiles.Partial]]
        ] = []
        _method_name_pre_validators: typing.ClassVar[typing.List[BasicCustomFiles.Validators.MethodNameValidator]] = []
        _method_name_post_validators: typing.ClassVar[typing.List[BasicCustomFiles.Validators.MethodNameValidator]] = []
        _signature_pre_validators: typing.ClassVar[typing.List[BasicCustomFiles.Validators.SignatureValidator]] = []
        _signature_post_validators: typing.ClassVar[typing.List[BasicCustomFiles.Validators.SignatureValidator]] = []
        _additional_files_pre_validators: typing.ClassVar[
            typing.List[BasicCustomFiles.Validators.AdditionalFilesValidator]
        ] = []
        _additional_files_post_validators: typing.ClassVar[
            typing.List[BasicCustomFiles.Validators.AdditionalFilesValidator]
        ] = []
        _basic_test_case_template_pre_validators: typing.ClassVar[
            typing.List[BasicCustomFiles.Validators.BasicTestCaseTemplateValidator]
        ] = []
        _basic_test_case_template_post_validators: typing.ClassVar[
            typing.List[BasicCustomFiles.Validators.BasicTestCaseTemplateValidator]
        ] = []

        @classmethod
        def root(
            cls, validator: typing.Callable[[BasicCustomFiles.Partial], BasicCustomFiles.Partial]
        ) -> typing.Callable[[BasicCustomFiles.Partial], BasicCustomFiles.Partial]:
            cls._validators.append(validator)
            return validator

        @typing.overload
        @classmethod
        def field(
            cls, field_name: typing_extensions.Literal["method_name"]
        ) -> typing.Callable[
            [BasicCustomFiles.Validators.MethodNameValidator], BasicCustomFiles.Validators.MethodNameValidator
        ]:
            ...

        @typing.overload
        @classmethod
        def field(
            cls, field_name: typing_extensions.Literal["signature"]
        ) -> typing.Callable[
            [BasicCustomFiles.Validators.SignatureValidator], BasicCustomFiles.Validators.SignatureValidator
        ]:
            ...

        @typing.overload
        @classmethod
        def field(
            cls, field_name: typing_extensions.Literal["additional_files"]
        ) -> typing.Callable[
            [BasicCustomFiles.Validators.AdditionalFilesValidator], BasicCustomFiles.Validators.AdditionalFilesValidator
        ]:
            ...

        @typing.overload
        @classmethod
        def field(
            cls, field_name: typing_extensions.Literal["basic_test_case_template"]
        ) -> typing.Callable[
            [BasicCustomFiles.Validators.BasicTestCaseTemplateValidator],
            BasicCustomFiles.Validators.BasicTestCaseTemplateValidator,
        ]:
            ...

        @classmethod
        def field(cls, field_name: str, *, pre: bool = False) -> typing.Any:
            def decorator(validator: typing.Any) -> typing.Any:
                if field_name == "method_name":
                    if pre:
                        cls._method_name_post_validators.append(validator)
                    else:
                        cls._method_name_post_validators.append(validator)
                if field_name == "signature":
                    if pre:
                        cls._signature_post_validators.append(validator)
                    else:
                        cls._signature_post_validators.append(validator)
                if field_name == "additional_files":
                    if pre:
                        cls._additional_files_post_validators.append(validator)
                    else:
                        cls._additional_files_post_validators.append(validator)
                if field_name == "basic_test_case_template":
                    if pre:
                        cls._basic_test_case_template_post_validators.append(validator)
                    else:
                        cls._basic_test_case_template_post_validators.append(validator)
                return validator

            return decorator

        class MethodNameValidator(typing_extensions.Protocol):
            def __call__(self, __v: str, __values: BasicCustomFiles.Partial) -> str:
                ...

        class SignatureValidator(typing_extensions.Protocol):
            def __call__(
                self, __v: NonVoidFunctionSignature, __values: BasicCustomFiles.Partial
            ) -> NonVoidFunctionSignature:
                ...

        class AdditionalFilesValidator(typing_extensions.Protocol):
            def __call__(
                self, __v: typing.Dict[Language, Files], __values: BasicCustomFiles.Partial
            ) -> typing.Dict[Language, Files]:
                ...

        class BasicTestCaseTemplateValidator(typing_extensions.Protocol):
            def __call__(self, __v: BasicTestCaseTemplate, __values: BasicCustomFiles.Partial) -> BasicTestCaseTemplate:
                ...

    @pydantic.root_validator
    def _validate(cls, values: BasicCustomFiles.Partial) -> BasicCustomFiles.Partial:
        for validator in BasicCustomFiles.Validators._validators:
            values = validator(values)
        return values

    @pydantic.validator("method_name", pre=True)
    def _pre_validate_method_name(cls, v: str, values: BasicCustomFiles.Partial) -> str:
        for validator in BasicCustomFiles.Validators._method_name_pre_validators:
            v = validator(v, values)
        return v

    @pydantic.validator("method_name", pre=False)
    def _post_validate_method_name(cls, v: str, values: BasicCustomFiles.Partial) -> str:
        for validator in BasicCustomFiles.Validators._method_name_post_validators:
            v = validator(v, values)
        return v

    @pydantic.validator("signature", pre=True)
    def _pre_validate_signature(
        cls, v: NonVoidFunctionSignature, values: BasicCustomFiles.Partial
    ) -> NonVoidFunctionSignature:
        for validator in BasicCustomFiles.Validators._signature_pre_validators:
            v = validator(v, values)
        return v

    @pydantic.validator("signature", pre=False)
    def _post_validate_signature(
        cls, v: NonVoidFunctionSignature, values: BasicCustomFiles.Partial
    ) -> NonVoidFunctionSignature:
        for validator in BasicCustomFiles.Validators._signature_post_validators:
            v = validator(v, values)
        return v

    @pydantic.validator("additional_files", pre=True)
    def _pre_validate_additional_files(
        cls, v: typing.Dict[Language, Files], values: BasicCustomFiles.Partial
    ) -> typing.Dict[Language, Files]:
        for validator in BasicCustomFiles.Validators._additional_files_pre_validators:
            v = validator(v, values)
        return v

    @pydantic.validator("additional_files", pre=False)
    def _post_validate_additional_files(
        cls, v: typing.Dict[Language, Files], values: BasicCustomFiles.Partial
    ) -> typing.Dict[Language, Files]:
        for validator in BasicCustomFiles.Validators._additional_files_post_validators:
            v = validator(v, values)
        return v

    @pydantic.validator("basic_test_case_template", pre=True)
    def _pre_validate_basic_test_case_template(
        cls, v: BasicTestCaseTemplate, values: BasicCustomFiles.Partial
    ) -> BasicTestCaseTemplate:
        for validator in BasicCustomFiles.Validators._basic_test_case_template_pre_validators:
            v = validator(v, values)
        return v

    @pydantic.validator("basic_test_case_template", pre=False)
    def _post_validate_basic_test_case_template(
        cls, v: BasicTestCaseTemplate, values: BasicCustomFiles.Partial
    ) -> BasicTestCaseTemplate:
        for validator in BasicCustomFiles.Validators._basic_test_case_template_post_validators:
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
