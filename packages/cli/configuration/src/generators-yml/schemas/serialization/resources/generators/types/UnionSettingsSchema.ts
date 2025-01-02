/**
 * This file was auto-generated by Fern from our API Definition.
 */

import * as serializers from "../../../index";
import * as FernDefinition from "../../../../api/index";
import * as core from "../../../../core";

export const UnionSettingsSchema: core.serialization.Schema<
    serializers.UnionSettingsSchema.Raw,
    FernDefinition.UnionSettingsSchema
> = core.serialization.enum_(["v1"]);

export declare namespace UnionSettingsSchema {
    export type Raw = "v1";
}
