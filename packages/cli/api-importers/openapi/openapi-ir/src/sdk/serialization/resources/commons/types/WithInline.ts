/**
 * This file was auto-generated by Fern from our API Definition.
 */

import * as serializers from "../../../index";
import * as FernOpenapiIr from "../../../../api/index";
import * as core from "../../../../core";

export const WithInline: core.serialization.ObjectSchema<serializers.WithInline.Raw, FernOpenapiIr.WithInline> =
    core.serialization.objectWithoutOptionalProperties({
        inline: core.serialization.boolean().optional(),
    });

export declare namespace WithInline {
    export interface Raw {
        inline?: boolean | null;
    }
}
