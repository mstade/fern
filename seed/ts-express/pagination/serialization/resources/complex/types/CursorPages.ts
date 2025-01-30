/**
 * This file was auto-generated by Fern from our API Definition.
 */

import * as serializers from "../../../index";
import * as SeedPagination from "../../../../api/index";
import * as core from "../../../../core";

export const CursorPages: core.serialization.ObjectSchema<serializers.CursorPages.Raw, SeedPagination.CursorPages> =
    core.serialization.object({
        next: core.serialization.lazyObject(() => serializers.StartingAfterPaging).optional(),
        page: core.serialization.number().optional(),
        perPage: core.serialization.property("per_page", core.serialization.number().optional()),
        totalPages: core.serialization.property("total_pages", core.serialization.number().optional()),
        type: core.serialization.stringLiteral("pages"),
    });

export declare namespace CursorPages {
    export interface Raw {
        next?: serializers.StartingAfterPaging.Raw | null;
        page?: number | null;
        per_page?: number | null;
        total_pages?: number | null;
        type: "pages";
    }
}
