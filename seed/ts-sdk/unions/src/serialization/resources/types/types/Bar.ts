/**
 * This file was auto-generated by Fern from our API Definition.
 */

import * as serializers from "../../..";
import * as SeedUnions from "../../../../api";
import * as core from "../../../../core";

export const Bar: core.serialization.ObjectSchema<serializers.Bar.Raw, SeedUnions.Bar> = core.serialization.object({
    name: core.serialization.string(),
});

export declare namespace Bar {
    interface Raw {
        name: string;
    }
}
