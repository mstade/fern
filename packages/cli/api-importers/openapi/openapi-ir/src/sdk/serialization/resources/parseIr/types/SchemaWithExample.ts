/**
 * This file was auto-generated by Fern from our API Definition.
 */

import * as serializers from "../../../index";
import * as FernOpenapiIr from "../../../../api/index";
import * as core from "../../../../core";
import { PrimitiveSchemaWithExample } from "./PrimitiveSchemaWithExample";
import { EnumSchemaWithExample } from "./EnumSchemaWithExample";
import { ReferencedSchema } from "../../finalIr/types/ReferencedSchema";
import { LiteralSchema } from "../../finalIr/types/LiteralSchema";
import { UnknownSchemaWithExample } from "./UnknownSchemaWithExample";

export const SchemaWithExample: core.serialization.Schema<
    serializers.SchemaWithExample.Raw,
    FernOpenapiIr.SchemaWithExample
> = core.serialization
    .union("type", {
        primitive: PrimitiveSchemaWithExample,
        object: core.serialization.lazyObject(() => serializers.ObjectSchemaWithExample),
        array: core.serialization.lazyObject(() => serializers.ArraySchemaWithExample),
        map: core.serialization.lazyObject(() => serializers.MapSchemaWithExample),
        optional: core.serialization.lazyObject(() => serializers.OptionalSchemaWithExample),
        enum: EnumSchemaWithExample,
        reference: ReferencedSchema,
        literal: LiteralSchema,
        oneOf: core.serialization.object({
            value: core.serialization.lazy(() => serializers.OneOfSchemaWithExample),
        }),
        nullable: core.serialization.lazyObject(() => serializers.NullableSchemaWithExample),
        unknown: UnknownSchemaWithExample,
    })
    .transform<FernOpenapiIr.SchemaWithExample>({
        transform: (value) => {
            switch (value.type) {
                case "primitive":
                    return FernOpenapiIr.SchemaWithExample.primitive(value);
                case "object":
                    return FernOpenapiIr.SchemaWithExample.object(value);
                case "array":
                    return FernOpenapiIr.SchemaWithExample.array(value);
                case "map":
                    return FernOpenapiIr.SchemaWithExample.map(value);
                case "optional":
                    return FernOpenapiIr.SchemaWithExample.optional(value);
                case "enum":
                    return FernOpenapiIr.SchemaWithExample.enum(value);
                case "reference":
                    return FernOpenapiIr.SchemaWithExample.reference(value);
                case "literal":
                    return FernOpenapiIr.SchemaWithExample.literal(value);
                case "oneOf":
                    return FernOpenapiIr.SchemaWithExample.oneOf(value.value);
                case "nullable":
                    return FernOpenapiIr.SchemaWithExample.nullable(value);
                case "unknown":
                    return FernOpenapiIr.SchemaWithExample.unknown(value);
                default:
                    return value as FernOpenapiIr.SchemaWithExample;
            }
        },
        untransform: ({ _visit, ...value }) => value as any,
    });

export declare namespace SchemaWithExample {
    export type Raw =
        | SchemaWithExample.Primitive
        | SchemaWithExample.Object
        | SchemaWithExample.Array
        | SchemaWithExample.Map
        | SchemaWithExample.Optional
        | SchemaWithExample.Enum
        | SchemaWithExample.Reference
        | SchemaWithExample.Literal
        | SchemaWithExample.OneOf
        | SchemaWithExample.Nullable
        | SchemaWithExample.Unknown;

    export interface Primitive extends PrimitiveSchemaWithExample.Raw {
        type: "primitive";
    }

    export interface Object extends serializers.ObjectSchemaWithExample.Raw {
        type: "object";
    }

    export interface Array extends serializers.ArraySchemaWithExample.Raw {
        type: "array";
    }

    export interface Map extends serializers.MapSchemaWithExample.Raw {
        type: "map";
    }

    export interface Optional extends serializers.OptionalSchemaWithExample.Raw {
        type: "optional";
    }

    export interface Enum extends EnumSchemaWithExample.Raw {
        type: "enum";
    }

    export interface Reference extends ReferencedSchema.Raw {
        type: "reference";
    }

    export interface Literal extends LiteralSchema.Raw {
        type: "literal";
    }

    export interface OneOf {
        type: "oneOf";
        value: serializers.OneOfSchemaWithExample.Raw;
    }

    export interface Nullable extends serializers.NullableSchemaWithExample.Raw {
        type: "nullable";
    }

    export interface Unknown extends UnknownSchemaWithExample.Raw {
        type: "unknown";
    }
}
