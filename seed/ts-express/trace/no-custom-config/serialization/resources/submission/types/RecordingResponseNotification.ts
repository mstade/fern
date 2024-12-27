/**
 * This file was auto-generated by Fern from our API Definition.
 */

import * as serializers from "../../../index";
import * as SeedTrace from "../../../../api/index";
import * as core from "../../../../core";

export const RecordingResponseNotification: core.serialization.ObjectSchema<
    serializers.RecordingResponseNotification.Raw,
    SeedTrace.RecordingResponseNotification
> = core.serialization.object({
    submissionId: core.serialization.lazy(() => serializers.SubmissionId),
    testCaseId: core.serialization.string().optional(),
    lineNumber: core.serialization.number(),
    lightweightStackInfo: core.serialization.lazyObject(() => serializers.LightweightStackframeInformation),
    tracedFile: core.serialization.lazyObject(() => serializers.TracedFile).optional(),
});

export declare namespace RecordingResponseNotification {
    export interface Raw {
        submissionId: serializers.SubmissionId.Raw;
        testCaseId?: string | null;
        lineNumber: number;
        lightweightStackInfo: serializers.LightweightStackframeInformation.Raw;
        tracedFile?: serializers.TracedFile.Raw | null;
    }
}
