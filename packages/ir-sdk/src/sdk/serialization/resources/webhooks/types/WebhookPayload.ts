/**
 * This file was auto-generated by Fern from our API Definition.
 */

import * as serializers from "../../..";
import * as FernIr from "../../../../api";
import * as core from "../../../../core";

export const WebhookPayload: core.serialization.Schema<serializers.WebhookPayload.Raw, FernIr.WebhookPayload> =
    core.serialization
        .union("type", {
            inlinedPayload: core.serialization.lazyObject(async () => (await import("../../..")).InlinedWebhookPayload),
            reference: core.serialization.lazyObject(async () => (await import("../../..")).WebhookPayloadReference),
        })
        .transform<FernIr.WebhookPayload>({
            transform: (value) => {
                switch (value.type) {
                    case "inlinedPayload":
                        return FernIr.WebhookPayload.inlinedPayload(value);
                    case "reference":
                        return FernIr.WebhookPayload.reference(value);
                    default:
                        return value as FernIr.WebhookPayload;
                }
            },
            untransform: ({ _visit, ...value }) => value as any,
        });

export declare namespace WebhookPayload {
    type Raw = WebhookPayload.InlinedPayload | WebhookPayload.Reference;

    interface InlinedPayload extends serializers.InlinedWebhookPayload.Raw {
        type: "inlinedPayload";
    }

    interface Reference extends serializers.WebhookPayloadReference.Raw {
        type: "reference";
    }
}