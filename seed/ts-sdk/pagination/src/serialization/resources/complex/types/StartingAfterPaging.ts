/**
 * This file was auto-generated by Fern from our API Definition.
 */

import * as serializers from "../../../index";
import * as SeedPagination from "../../../../api/index";
import * as core from "../../../../core";

export const StartingAfterPaging: core.serialization.ObjectSchema<
    serializers.StartingAfterPaging.Raw,
    SeedPagination.StartingAfterPaging
> = core.serialization.object({
    perPage: core.serialization.property("per_page", core.serialization.number()),
    startingAfter: core.serialization.property("starting_after", core.serialization.string().optional()),
});

export declare namespace StartingAfterPaging {
    export interface Raw {
        per_page: number;
        starting_after?: string | null;
    }
}
