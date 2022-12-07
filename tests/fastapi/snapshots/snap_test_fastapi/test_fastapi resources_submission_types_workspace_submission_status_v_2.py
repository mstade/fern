# This file was auto-generated by Fern from our API Definition.

from __future__ import annotations

import typing

import pydantic
import typing_extensions

from .workspace_submission_update import WorkspaceSubmissionUpdate


class WorkspaceSubmissionStatusV2(pydantic.BaseModel):
    updates: typing.List[WorkspaceSubmissionUpdate]

    class Partial(typing_extensions.TypedDict):
        updates: typing_extensions.NotRequired[typing.List[WorkspaceSubmissionUpdate]]

    class Validators:
        """
        Use this class to add validators to the Pydantic model.

            @WorkspaceSubmissionStatusV2.Validators.root
            def validate(values: WorkspaceSubmissionStatusV2.Partial) -> WorkspaceSubmissionStatusV2.Partial:
                ...

            @WorkspaceSubmissionStatusV2.Validators.field("updates")
            def validate_updates(updates: typing.List[WorkspaceSubmissionUpdate], values: WorkspaceSubmissionStatusV2.Partial) -> typing.List[WorkspaceSubmissionUpdate]:
                ...
        """

        _validators: typing.ClassVar[
            typing.List[typing.Callable[[WorkspaceSubmissionStatusV2.Partial], WorkspaceSubmissionStatusV2.Partial]]
        ] = []
        _updates_pre_validators: typing.ClassVar[
            typing.List[WorkspaceSubmissionStatusV2.Validators.UpdatesValidator]
        ] = []
        _updates_post_validators: typing.ClassVar[
            typing.List[WorkspaceSubmissionStatusV2.Validators.UpdatesValidator]
        ] = []

        @classmethod
        def root(
            cls, validator: typing.Callable[[WorkspaceSubmissionStatusV2.Partial], WorkspaceSubmissionStatusV2.Partial]
        ) -> typing.Callable[[WorkspaceSubmissionStatusV2.Partial], WorkspaceSubmissionStatusV2.Partial]:
            cls._validators.append(validator)
            return validator

        @typing.overload  # type: ignore
        @classmethod
        def field(
            cls, field_name: typing_extensions.Literal["updates"]
        ) -> typing.Callable[
            [WorkspaceSubmissionStatusV2.Validators.UpdatesValidator],
            WorkspaceSubmissionStatusV2.Validators.UpdatesValidator,
        ]:
            ...

        @classmethod
        def field(cls, field_name: str, *, pre: bool = False) -> typing.Any:
            def decorator(validator: typing.Any) -> typing.Any:
                if field_name == "updates":
                    if pre:
                        cls._updates_post_validators.append(validator)
                    else:
                        cls._updates_post_validators.append(validator)
                return validator

            return decorator

        class UpdatesValidator(typing_extensions.Protocol):
            def __call__(
                self, __v: typing.List[WorkspaceSubmissionUpdate], __values: WorkspaceSubmissionStatusV2.Partial
            ) -> typing.List[WorkspaceSubmissionUpdate]:
                ...

    @pydantic.root_validator
    def _validate(cls, values: WorkspaceSubmissionStatusV2.Partial) -> WorkspaceSubmissionStatusV2.Partial:
        for validator in WorkspaceSubmissionStatusV2.Validators._validators:
            values = validator(values)
        return values

    @pydantic.validator("updates", pre=True)
    def _pre_validate_updates(
        cls, v: typing.List[WorkspaceSubmissionUpdate], values: WorkspaceSubmissionStatusV2.Partial
    ) -> typing.List[WorkspaceSubmissionUpdate]:
        for validator in WorkspaceSubmissionStatusV2.Validators._updates_pre_validators:
            v = validator(v, values)
        return v

    @pydantic.validator("updates", pre=False)
    def _post_validate_updates(
        cls, v: typing.List[WorkspaceSubmissionUpdate], values: WorkspaceSubmissionStatusV2.Partial
    ) -> typing.List[WorkspaceSubmissionUpdate]:
        for validator in WorkspaceSubmissionStatusV2.Validators._updates_post_validators:
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
