/**
 * This file was auto-generated by Fern from our API Definition.
 */

import * as serializers from "../../../../..";
import * as Fiddle from "../../../../../../api";
import * as core from "../../../../../../core";

export const Cat: core.serialization.ObjectSchema<serializers.types.Cat.Raw, Fiddle.types.Cat> =
    core.serialization.object({
        name: core.serialization.string(),
        likesToMeow: core.serialization.boolean(),
    });

export declare namespace Cat {
    interface Raw {
        name: string;
        likesToMeow: boolean;
    }
}