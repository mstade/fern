/**
 * This file was auto-generated by Fern from our API Definition.
 */

import * as FernOpenapiIr from "../../../index";

export interface EnumValue extends FernOpenapiIr.WithDescription, FernOpenapiIr.WithAvailability {
    /** Codegen friendly name. Read from `X-Enum-Names` */
    nameOverride: string | undefined;
    /** Codegen friendly name. Generated by removing non-alphanumeric characters and camel casing. */
    generatedName: string;
    /** Value of the enum */
    value: string;
    casing: FernOpenapiIr.CasingOverrides | undefined;
}
