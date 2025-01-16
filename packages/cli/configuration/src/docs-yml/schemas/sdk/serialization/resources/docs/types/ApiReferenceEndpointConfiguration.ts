/**
 * This file was auto-generated by Fern from our API Definition.
 */

import * as serializers from "../../../index";
import * as FernDocsConfig from "../../../../api/index";
import * as core from "../../../../core";
import { PlaygroundSettings } from "./PlaygroundSettings";
import { WithPermissions } from "./WithPermissions";
import { WithFeatureFlags } from "./WithFeatureFlags";

export const ApiReferenceEndpointConfiguration: core.serialization.ObjectSchema<
    serializers.ApiReferenceEndpointConfiguration.Raw,
    FernDocsConfig.ApiReferenceEndpointConfiguration
> = core.serialization
    .object({
        endpoint: core.serialization.string(),
        title: core.serialization.string().optional(),
        slug: core.serialization.string().optional(),
        icon: core.serialization.string().optional(),
        hidden: core.serialization.boolean().optional(),
        playground: PlaygroundSettings.optional(),
    })
    .extend(WithPermissions)
    .extend(WithFeatureFlags);

export declare namespace ApiReferenceEndpointConfiguration {
    export interface Raw extends WithPermissions.Raw, WithFeatureFlags.Raw {
        endpoint: string;
        title?: string | null;
        slug?: string | null;
        icon?: string | null;
        hidden?: boolean | null;
        playground?: PlaygroundSettings.Raw | null;
    }
}
