/**
 * This file was auto-generated by Fern from our API Definition.
 */

import * as FernOpenapiIr from "../../..";

export interface ObjectProperty extends FernOpenapiIr.WithAvailability {
    key: string;
    schema: FernOpenapiIr.Schema;
    /** The schemas that conflict with this property */
    conflict: Record<FernOpenapiIr.SchemaId, FernOpenapiIr.ObjectPropertyConflictInfo>;
    /** A unique name for the property. */
    generatedName: string;
    /** An optional name override populated via `x-fern-property-name`. */
    nameOverride: string | undefined;
    audiences: string[];
}
