/**
 * This file was auto-generated by Fern from our API Definition.
 */

import * as SeedTrace from "../../../../index";

/**
 * @example
 *     {
 *         workspaceRunDetails: {
 *             exceptionV2: undefined,
 *             exception: undefined,
 *             stdout: "stdout"
 *         },
 *         traceResponses: [{
 *                 submissionId: SeedTrace.SubmissionId("d5e9c84f-c2b2-4bf4-b4b0-7ffd7a9ffc32"),
 *                 lineNumber: 1,
 *                 returnValue: undefined,
 *                 expressionLocation: undefined,
 *                 stack: {
 *                     numStackFrames: 1,
 *                     topStackFrame: undefined
 *                 },
 *                 stdout: undefined
 *             }, {
 *                 submissionId: SeedTrace.SubmissionId("d5e9c84f-c2b2-4bf4-b4b0-7ffd7a9ffc32"),
 *                 lineNumber: 1,
 *                 returnValue: undefined,
 *                 expressionLocation: undefined,
 *                 stack: {
 *                     numStackFrames: 1,
 *                     topStackFrame: undefined
 *                 },
 *                 stdout: undefined
 *             }]
 *     }
 */
export interface StoreTracedWorkspaceRequest {
    workspaceRunDetails: SeedTrace.WorkspaceRunDetails;
    traceResponses: SeedTrace.TraceResponse[];
}
