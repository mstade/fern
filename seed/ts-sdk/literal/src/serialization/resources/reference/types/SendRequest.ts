/**
 * This file was auto-generated by Fern from our API Definition.
 */

import * as serializers from "../../../index";
import * as SeedLiteral from "../../../../api/index";
import * as core from "../../../../core";
import { SomeLiteral } from "./SomeLiteral";
import { ContainerObject } from "./ContainerObject";

export const SendRequest: core.serialization.ObjectSchema<serializers.SendRequest.Raw, SeedLiteral.SendRequest> =
    core.serialization.object({
        prompt: core.serialization.stringLiteral("You are a helpful assistant"),
        query: core.serialization.string(),
        stream: core.serialization.booleanLiteral(false),
        ending: core.serialization.stringLiteral("$ending"),
        context: SomeLiteral,
        maybeContext: SomeLiteral.optional(),
        containerObject: ContainerObject,
    });

export declare namespace SendRequest {
    export interface Raw {
        prompt: "You are a helpful assistant";
        query: string;
        stream: false;
        ending: "$ending";
        context: SomeLiteral.Raw;
        maybeContext?: SomeLiteral.Raw | null;
        containerObject: ContainerObject.Raw;
    }
}
