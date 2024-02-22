/**
 * This file was auto-generated by Fern from our API Definition.
 */

import * as serializers from "../../..";
import * as FernOpenapiIr from "../../../../api";
import * as core from "../../../../core";

export const IntWithExample: core.serialization.ObjectSchema<
    serializers.IntWithExample.Raw,
    FernOpenapiIr.IntWithExample
> = core.serialization.objectWithoutOptionalProperties({
    example: core.serialization.number().optional(),
});

export declare namespace IntWithExample {
    interface Raw {
        example?: number | null;
    }
}