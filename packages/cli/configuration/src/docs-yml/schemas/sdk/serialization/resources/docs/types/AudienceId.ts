/**
 * This file was auto-generated by Fern from our API Definition.
 */

import * as serializers from "../../../index";
import * as FernDocsConfig from "../../../../api/index";
import * as core from "../../../../core";

export const AudienceId: core.serialization.Schema<serializers.AudienceId.Raw, FernDocsConfig.AudienceId> =
    core.serialization.string();

export declare namespace AudienceId {
    export type Raw = string;
}
