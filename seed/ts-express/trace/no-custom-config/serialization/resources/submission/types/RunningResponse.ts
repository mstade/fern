/**
 * This file was auto-generated by Fern from our API Definition.
 */

import * as serializers from "../../../index";
import * as SeedTrace from "../../../../api/index";
import * as core from "../../../../core";

export const RunningResponse: core.serialization.ObjectSchema<
    serializers.RunningResponse.Raw,
    SeedTrace.RunningResponse
> = core.serialization.object({
    submissionId: core.serialization.lazy(() => serializers.SubmissionId),
    state: core.serialization.lazy(() => serializers.RunningSubmissionState),
});

export declare namespace RunningResponse {
    export interface Raw {
        submissionId: serializers.SubmissionId.Raw;
        state: serializers.RunningSubmissionState.Raw;
    }
}
