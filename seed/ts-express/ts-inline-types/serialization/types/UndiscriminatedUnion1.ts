/**
 * This file was auto-generated by Fern from our API Definition.
 */

import * as serializers from "../index";
import * as SeedObject from "../../api/index";
import * as core from "../../core";

export const UndiscriminatedUnion1: core.serialization.Schema<
    serializers.UndiscriminatedUnion1.Raw,
    SeedObject.UndiscriminatedUnion1
> = core.serialization.undiscriminatedUnion([
    core.serialization.lazyObject(() => serializers.UndiscriminatedUnion1InlineType1),
    core.serialization.lazyObject(() => serializers.UndiscriminatedUnion1InlineType2),
    core.serialization.lazy(() => serializers.UndiscriminatedUnion1DiscriminatedUnion1),
    core.serialization.lazy(() => serializers.UndiscriminatedUnion1InlineEnum1),
    core.serialization.lazy(() => serializers.UserId),
    core.serialization.list(core.serialization.lazyObject(() => serializers.UndiscriminatedUnion1InlineListItem1)),
    core.serialization.list(core.serialization.lazyObject(() => serializers.UndiscriminatedUnion1InlineSetItem1)),
    core.serialization.record(
        core.serialization.string(),
        core.serialization.lazyObject(() => serializers.UndiscriminatedUnion1InlineMapItem1),
    ),
    core.serialization.lazyObject(() => serializers.ReferenceType),
]);

export declare namespace UndiscriminatedUnion1 {
    export type Raw =
        | serializers.UndiscriminatedUnion1InlineType1.Raw
        | serializers.UndiscriminatedUnion1InlineType2.Raw
        | serializers.UndiscriminatedUnion1DiscriminatedUnion1.Raw
        | serializers.UndiscriminatedUnion1InlineEnum1.Raw
        | serializers.UserId.Raw
        | serializers.UndiscriminatedUnion1InlineListItem1.Raw[]
        | serializers.UndiscriminatedUnion1InlineSetItem1.Raw[]
        | Record<string, serializers.UndiscriminatedUnion1InlineMapItem1.Raw>
        | serializers.ReferenceType.Raw;
}
