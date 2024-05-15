/**
 * This file was auto-generated by Fern from our API Definition.
 */

import * as serializers from "../../..";
import * as FernIr from "../../../../api";
import * as core from "../../../../core";

export const OAuthAccessTokenRequestProperties: core.serialization.ObjectSchema<
    serializers.OAuthAccessTokenRequestProperties.Raw,
    FernIr.OAuthAccessTokenRequestProperties
> = core.serialization.objectWithoutOptionalProperties({
    clientId: core.serialization.lazyObject(async () => (await import("../../..")).RequestProperty),
    clientSecret: core.serialization.lazyObject(async () => (await import("../../..")).RequestProperty),
    scopes: core.serialization.lazyObject(async () => (await import("../../..")).RequestProperty).optional(),
});

export declare namespace OAuthAccessTokenRequestProperties {
    interface Raw {
        clientId: serializers.RequestProperty.Raw;
        clientSecret: serializers.RequestProperty.Raw;
        scopes?: serializers.RequestProperty.Raw | null;
    }
}