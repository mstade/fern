/**
 * This file was auto-generated by Fern from our API Definition.
 */

import * as serializers from "../../../index";
import * as FernOpenapiIr from "../../../../api/index";
import * as core from "../../../../core";

export const QuerySecurityScheme: core.serialization.ObjectSchema<
    serializers.QuerySecurityScheme.Raw,
    FernOpenapiIr.QuerySecurityScheme
> = core.serialization.objectWithoutOptionalProperties({
    queryParameterName: core.serialization.string(),
});

export declare namespace QuerySecurityScheme {
    export interface Raw {
        queryParameterName: string;
    }
}
