/**
 * This file was auto-generated by Fern from our API Definition.
 */

import * as serializers from "../../../index";
import * as FernOpenapiIr from "../../../../api/index";
import * as core from "../../../../core";

export const Availability: core.serialization.Schema<serializers.Availability.Raw, FernOpenapiIr.Availability> =
    core.serialization.enum_(["GenerallyAvailable", "Beta", "Deprecated"]);

export declare namespace Availability {
    export type Raw = "GenerallyAvailable" | "Beta" | "Deprecated";
}
