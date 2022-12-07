# This file was auto-generated by Fern from our API Definition.

from __future__ import annotations

import typing

import pydantic
import typing_extensions

from ....commons.types.variable_value import VariableValue
from .parameter_id import ParameterId
from .test_case_expects import TestCaseExpects
from .test_case_implementation_reference import TestCaseImplementationReference
from .test_case_metadata import TestCaseMetadata


class TestCaseV2(pydantic.BaseModel):
    metadata: TestCaseMetadata
    implementation: TestCaseImplementationReference
    arguments: typing.Dict[ParameterId, VariableValue]
    expects: typing.Optional[TestCaseExpects]

    class Partial(typing_extensions.TypedDict):
        metadata: typing_extensions.NotRequired[TestCaseMetadata]
        implementation: typing_extensions.NotRequired[TestCaseImplementationReference]
        arguments: typing_extensions.NotRequired[typing.Dict[ParameterId, VariableValue]]
        expects: typing_extensions.NotRequired[typing.Optional[TestCaseExpects]]

    class Validators:
        """
        Use this class to add validators to the Pydantic model.

            @TestCaseV2.Validators.root
            def validate(values: TestCaseV2.Partial) -> TestCaseV2.Partial:
                ...

            @TestCaseV2.Validators.field("metadata")
            def validate_metadata(metadata: TestCaseMetadata, values: TestCaseV2.Partial) -> TestCaseMetadata:
                ...

            @TestCaseV2.Validators.field("implementation")
            def validate_implementation(implementation: TestCaseImplementationReference, values: TestCaseV2.Partial) -> TestCaseImplementationReference:
                ...

            @TestCaseV2.Validators.field("arguments")
            def validate_arguments(arguments: typing.Dict[ParameterId, VariableValue], values: TestCaseV2.Partial) -> typing.Dict[ParameterId, VariableValue]:
                ...

            @TestCaseV2.Validators.field("expects")
            def validate_expects(expects: typing.Optional[TestCaseExpects], values: TestCaseV2.Partial) -> typing.Optional[TestCaseExpects]:
                ...
        """

        _validators: typing.ClassVar[typing.List[typing.Callable[[TestCaseV2.Partial], TestCaseV2.Partial]]] = []
        _metadata_pre_validators: typing.ClassVar[typing.List[TestCaseV2.Validators.MetadataValidator]] = []
        _metadata_post_validators: typing.ClassVar[typing.List[TestCaseV2.Validators.MetadataValidator]] = []
        _implementation_pre_validators: typing.ClassVar[typing.List[TestCaseV2.Validators.ImplementationValidator]] = []
        _implementation_post_validators: typing.ClassVar[
            typing.List[TestCaseV2.Validators.ImplementationValidator]
        ] = []
        _arguments_pre_validators: typing.ClassVar[typing.List[TestCaseV2.Validators.ArgumentsValidator]] = []
        _arguments_post_validators: typing.ClassVar[typing.List[TestCaseV2.Validators.ArgumentsValidator]] = []
        _expects_pre_validators: typing.ClassVar[typing.List[TestCaseV2.Validators.ExpectsValidator]] = []
        _expects_post_validators: typing.ClassVar[typing.List[TestCaseV2.Validators.ExpectsValidator]] = []

        @classmethod
        def root(
            cls, validator: typing.Callable[[TestCaseV2.Partial], TestCaseV2.Partial]
        ) -> typing.Callable[[TestCaseV2.Partial], TestCaseV2.Partial]:
            cls._validators.append(validator)
            return validator

        @typing.overload
        @classmethod
        def field(
            cls, field_name: typing_extensions.Literal["metadata"]
        ) -> typing.Callable[[TestCaseV2.Validators.MetadataValidator], TestCaseV2.Validators.MetadataValidator]:
            ...

        @typing.overload
        @classmethod
        def field(
            cls, field_name: typing_extensions.Literal["implementation"]
        ) -> typing.Callable[
            [TestCaseV2.Validators.ImplementationValidator], TestCaseV2.Validators.ImplementationValidator
        ]:
            ...

        @typing.overload
        @classmethod
        def field(
            cls, field_name: typing_extensions.Literal["arguments"]
        ) -> typing.Callable[[TestCaseV2.Validators.ArgumentsValidator], TestCaseV2.Validators.ArgumentsValidator]:
            ...

        @typing.overload
        @classmethod
        def field(
            cls, field_name: typing_extensions.Literal["expects"]
        ) -> typing.Callable[[TestCaseV2.Validators.ExpectsValidator], TestCaseV2.Validators.ExpectsValidator]:
            ...

        @classmethod
        def field(cls, field_name: str, *, pre: bool = False) -> typing.Any:
            def decorator(validator: typing.Any) -> typing.Any:
                if field_name == "metadata":
                    if pre:
                        cls._metadata_post_validators.append(validator)
                    else:
                        cls._metadata_post_validators.append(validator)
                if field_name == "implementation":
                    if pre:
                        cls._implementation_post_validators.append(validator)
                    else:
                        cls._implementation_post_validators.append(validator)
                if field_name == "arguments":
                    if pre:
                        cls._arguments_post_validators.append(validator)
                    else:
                        cls._arguments_post_validators.append(validator)
                if field_name == "expects":
                    if pre:
                        cls._expects_post_validators.append(validator)
                    else:
                        cls._expects_post_validators.append(validator)
                return validator

            return decorator

        class MetadataValidator(typing_extensions.Protocol):
            def __call__(self, __v: TestCaseMetadata, __values: TestCaseV2.Partial) -> TestCaseMetadata:
                ...

        class ImplementationValidator(typing_extensions.Protocol):
            def __call__(
                self, __v: TestCaseImplementationReference, __values: TestCaseV2.Partial
            ) -> TestCaseImplementationReference:
                ...

        class ArgumentsValidator(typing_extensions.Protocol):
            def __call__(
                self, __v: typing.Dict[ParameterId, VariableValue], __values: TestCaseV2.Partial
            ) -> typing.Dict[ParameterId, VariableValue]:
                ...

        class ExpectsValidator(typing_extensions.Protocol):
            def __call__(
                self, __v: typing.Optional[TestCaseExpects], __values: TestCaseV2.Partial
            ) -> typing.Optional[TestCaseExpects]:
                ...

    @pydantic.root_validator
    def _validate(cls, values: TestCaseV2.Partial) -> TestCaseV2.Partial:
        for validator in TestCaseV2.Validators._validators:
            values = validator(values)
        return values

    @pydantic.validator("metadata", pre=True)
    def _pre_validate_metadata(cls, v: TestCaseMetadata, values: TestCaseV2.Partial) -> TestCaseMetadata:
        for validator in TestCaseV2.Validators._metadata_pre_validators:
            v = validator(v, values)
        return v

    @pydantic.validator("metadata", pre=False)
    def _post_validate_metadata(cls, v: TestCaseMetadata, values: TestCaseV2.Partial) -> TestCaseMetadata:
        for validator in TestCaseV2.Validators._metadata_post_validators:
            v = validator(v, values)
        return v

    @pydantic.validator("implementation", pre=True)
    def _pre_validate_implementation(
        cls, v: TestCaseImplementationReference, values: TestCaseV2.Partial
    ) -> TestCaseImplementationReference:
        for validator in TestCaseV2.Validators._implementation_pre_validators:
            v = validator(v, values)
        return v

    @pydantic.validator("implementation", pre=False)
    def _post_validate_implementation(
        cls, v: TestCaseImplementationReference, values: TestCaseV2.Partial
    ) -> TestCaseImplementationReference:
        for validator in TestCaseV2.Validators._implementation_post_validators:
            v = validator(v, values)
        return v

    @pydantic.validator("arguments", pre=True)
    def _pre_validate_arguments(
        cls, v: typing.Dict[ParameterId, VariableValue], values: TestCaseV2.Partial
    ) -> typing.Dict[ParameterId, VariableValue]:
        for validator in TestCaseV2.Validators._arguments_pre_validators:
            v = validator(v, values)
        return v

    @pydantic.validator("arguments", pre=False)
    def _post_validate_arguments(
        cls, v: typing.Dict[ParameterId, VariableValue], values: TestCaseV2.Partial
    ) -> typing.Dict[ParameterId, VariableValue]:
        for validator in TestCaseV2.Validators._arguments_post_validators:
            v = validator(v, values)
        return v

    @pydantic.validator("expects", pre=True)
    def _pre_validate_expects(
        cls, v: typing.Optional[TestCaseExpects], values: TestCaseV2.Partial
    ) -> typing.Optional[TestCaseExpects]:
        for validator in TestCaseV2.Validators._expects_pre_validators:
            v = validator(v, values)
        return v

    @pydantic.validator("expects", pre=False)
    def _post_validate_expects(
        cls, v: typing.Optional[TestCaseExpects], values: TestCaseV2.Partial
    ) -> typing.Optional[TestCaseExpects]:
        for validator in TestCaseV2.Validators._expects_post_validators:
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
        extra = pydantic.Extra.forbid
