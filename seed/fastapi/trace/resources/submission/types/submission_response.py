# This file was auto-generated by Fern from our API Definition.

from __future__ import annotations
from ....core.pydantic_utilities import IS_PYDANTIC_V2
from ...commons.types.problem_id import ProblemId
from .exception_info import ExceptionInfo
from .code_execution_update import (
    CodeExecutionUpdate as resources_submission_types_code_execution_update_CodeExecutionUpdate,
)
from .terminated_response import TerminatedResponse
from ....core.pydantic_utilities import UniversalRootModel
import typing
import typing_extensions
import pydantic
from ....core.pydantic_utilities import UniversalBaseModel
from ....core.pydantic_utilities import update_forward_refs

T_Result = typing.TypeVar("T_Result")


class _Factory:
    def server_initialized(self) -> SubmissionResponse:
        if IS_PYDANTIC_V2:
            return SubmissionResponse(
                root=_SubmissionResponse.ServerInitialized(type="serverInitialized")
            )  # type: ignore
        else:
            return SubmissionResponse(
                __root__=_SubmissionResponse.ServerInitialized(type="serverInitialized")
            )  # type: ignore

    def problem_initialized(self, value: ProblemId) -> SubmissionResponse:
        if IS_PYDANTIC_V2:
            return SubmissionResponse(
                root=_SubmissionResponse.ProblemInitialized(
                    type="problemInitialized", value=value
                )
            )  # type: ignore
        else:
            return SubmissionResponse(
                __root__=_SubmissionResponse.ProblemInitialized(
                    type="problemInitialized", value=value
                )
            )  # type: ignore

    def workspace_initialized(self) -> SubmissionResponse:
        if IS_PYDANTIC_V2:
            return SubmissionResponse(
                root=_SubmissionResponse.WorkspaceInitialized(
                    type="workspaceInitialized"
                )
            )  # type: ignore
        else:
            return SubmissionResponse(
                __root__=_SubmissionResponse.WorkspaceInitialized(
                    type="workspaceInitialized"
                )
            )  # type: ignore

    def server_errored(self, value: ExceptionInfo) -> SubmissionResponse:
        if IS_PYDANTIC_V2:
            return SubmissionResponse(
                root=_SubmissionResponse.ServerErrored(
                    **value.dict(exclude_unset=True), type="serverErrored"
                )
            )  # type: ignore
        else:
            return SubmissionResponse(
                __root__=_SubmissionResponse.ServerErrored(
                    **value.dict(exclude_unset=True), type="serverErrored"
                )
            )  # type: ignore

    def code_execution_update(
        self,
        value: resources_submission_types_code_execution_update_CodeExecutionUpdate,
    ) -> SubmissionResponse:
        if IS_PYDANTIC_V2:
            return SubmissionResponse(
                root=_SubmissionResponse.CodeExecutionUpdate(
                    type="codeExecutionUpdate", value=value
                )
            )  # type: ignore
        else:
            return SubmissionResponse(
                __root__=_SubmissionResponse.CodeExecutionUpdate(
                    type="codeExecutionUpdate", value=value
                )
            )  # type: ignore

    def terminated(self, value: TerminatedResponse) -> SubmissionResponse:
        if IS_PYDANTIC_V2:
            return SubmissionResponse(
                root=_SubmissionResponse.Terminated(
                    **value.dict(exclude_unset=True), type="terminated"
                )
            )  # type: ignore
        else:
            return SubmissionResponse(
                __root__=_SubmissionResponse.Terminated(
                    **value.dict(exclude_unset=True), type="terminated"
                )
            )  # type: ignore


class SubmissionResponse(UniversalRootModel):
    factory: typing.ClassVar[_Factory] = _Factory()

    if IS_PYDANTIC_V2:
        root: typing_extensions.Annotated[
            typing.Union[
                _SubmissionResponse.ServerInitialized,
                _SubmissionResponse.ProblemInitialized,
                _SubmissionResponse.WorkspaceInitialized,
                _SubmissionResponse.ServerErrored,
                _SubmissionResponse.CodeExecutionUpdate,
                _SubmissionResponse.Terminated,
            ],
            pydantic.Field(discriminator="type"),
        ]

        def get_as_union(
            self,
        ) -> typing.Union[
            _SubmissionResponse.ServerInitialized,
            _SubmissionResponse.ProblemInitialized,
            _SubmissionResponse.WorkspaceInitialized,
            _SubmissionResponse.ServerErrored,
            _SubmissionResponse.CodeExecutionUpdate,
            _SubmissionResponse.Terminated,
        ]:
            return self.root
    else:
        __root__: typing_extensions.Annotated[
            typing.Union[
                _SubmissionResponse.ServerInitialized,
                _SubmissionResponse.ProblemInitialized,
                _SubmissionResponse.WorkspaceInitialized,
                _SubmissionResponse.ServerErrored,
                _SubmissionResponse.CodeExecutionUpdate,
                _SubmissionResponse.Terminated,
            ],
            pydantic.Field(discriminator="type"),
        ]

        def get_as_union(
            self,
        ) -> typing.Union[
            _SubmissionResponse.ServerInitialized,
            _SubmissionResponse.ProblemInitialized,
            _SubmissionResponse.WorkspaceInitialized,
            _SubmissionResponse.ServerErrored,
            _SubmissionResponse.CodeExecutionUpdate,
            _SubmissionResponse.Terminated,
        ]:
            return self.__root__

    def dict(self, **kwargs: typing.Any) -> typing.Dict[str, typing.Any]:
        if IS_PYDANTIC_V2:
            return self.root.dict(**kwargs)
        else:
            return self.__root__.dict(**kwargs)

    def visit(
        self,
        server_initialized: typing.Callable[[], T_Result],
        problem_initialized: typing.Callable[[ProblemId], T_Result],
        workspace_initialized: typing.Callable[[], T_Result],
        server_errored: typing.Callable[[ExceptionInfo], T_Result],
        code_execution_update: typing.Callable[
            [resources_submission_types_code_execution_update_CodeExecutionUpdate],
            T_Result,
        ],
        terminated: typing.Callable[[TerminatedResponse], T_Result],
    ) -> T_Result:
        unioned_value = self.get_as_union()
        if unioned_value.type == "serverInitialized":
            return server_initialized()
        if unioned_value.type == "problemInitialized":
            return problem_initialized(unioned_value.value)
        if unioned_value.type == "workspaceInitialized":
            return workspace_initialized()
        if unioned_value.type == "serverErrored":
            return server_errored(
                ExceptionInfo(
                    **unioned_value.dict(exclude_unset=True, exclude={"type"})
                )
            )
        if unioned_value.type == "codeExecutionUpdate":
            return code_execution_update(unioned_value.value)
        if unioned_value.type == "terminated":
            return terminated(
                TerminatedResponse(
                    **unioned_value.dict(exclude_unset=True, exclude={"type"})
                )
            )


class _SubmissionResponse:
    class ServerInitialized(UniversalBaseModel):
        type: typing.Literal["serverInitialized"] = "serverInitialized"

    class ProblemInitialized(UniversalBaseModel):
        type: typing.Literal["problemInitialized"] = "problemInitialized"
        value: ProblemId

    class WorkspaceInitialized(UniversalBaseModel):
        type: typing.Literal["workspaceInitialized"] = "workspaceInitialized"

    class ServerErrored(ExceptionInfo):
        type: typing.Literal["serverErrored"] = "serverErrored"

    class CodeExecutionUpdate(UniversalBaseModel):
        type: typing.Literal["codeExecutionUpdate"] = "codeExecutionUpdate"
        value: resources_submission_types_code_execution_update_CodeExecutionUpdate

    class Terminated(TerminatedResponse):
        type: typing.Literal["terminated"] = "terminated"


update_forward_refs(SubmissionResponse)
