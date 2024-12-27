/**
 * This file was auto-generated by Fern from our API Definition.
 */

import * as serializers from "../../../../index";
import * as SeedAudiences from "../../../../../api/index";
import * as core from "../../../../../core";

export const FindRequest: core.serialization.Schema<serializers.FindRequest.Raw, SeedAudiences.FindRequest> =
    core.serialization.object({
        publicProperty: core.serialization.string().optional(),
        privateProperty: core.serialization.number().optional(),
    });

export declare namespace FindRequest {
    export interface Raw {
        publicProperty?: string | null;
        privateProperty?: number | null;
    }
}
