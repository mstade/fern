/**
 * This file was auto-generated by Fern from our API Definition.
 */

import * as serializers from "../../../index";
import * as SeedPagination from "../../../../api/index";
import * as core from "../../../../core";
import { SingleFilterSearchRequest } from "./SingleFilterSearchRequest";

export const SearchRequestQuery: core.serialization.Schema<
    serializers.SearchRequestQuery.Raw,
    SeedPagination.SearchRequestQuery
> = core.serialization.undiscriminatedUnion([
    SingleFilterSearchRequest,
    core.serialization.lazyObject(() => serializers.MultipleFilterSearchRequest),
]);

export declare namespace SearchRequestQuery {
    export type Raw = SingleFilterSearchRequest.Raw | serializers.MultipleFilterSearchRequest.Raw;
}
