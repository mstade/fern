/**
 * This file was auto-generated by Fern from our API Definition.
 */

import * as FernOpenapiIr from "../../../index";

export type OneOfSchemaWithExample =
    | FernOpenapiIr.OneOfSchemaWithExample.Discriminated
    | FernOpenapiIr.OneOfSchemaWithExample.Undiscriminated;

export namespace OneOfSchemaWithExample {
    export interface Discriminated extends FernOpenapiIr.DiscriminatedOneOfSchemaWithExample, _Utils {
        type: "discriminated";
    }

    export interface Undiscriminated extends FernOpenapiIr.UnDiscriminatedOneOfSchemaWithExample, _Utils {
        type: "undiscriminated";
    }

    export interface _Utils {
        _visit: <_Result>(visitor: FernOpenapiIr.OneOfSchemaWithExample._Visitor<_Result>) => _Result;
    }

    export interface _Visitor<_Result> {
        discriminated: (value: FernOpenapiIr.DiscriminatedOneOfSchemaWithExample) => _Result;
        undiscriminated: (value: FernOpenapiIr.UnDiscriminatedOneOfSchemaWithExample) => _Result;
        _other: (value: { type: string }) => _Result;
    }
}

export const OneOfSchemaWithExample = {
    discriminated: (
        value: FernOpenapiIr.DiscriminatedOneOfSchemaWithExample,
    ): FernOpenapiIr.OneOfSchemaWithExample.Discriminated => {
        return {
            ...value,
            type: "discriminated",
            _visit: function <_Result>(
                this: FernOpenapiIr.OneOfSchemaWithExample.Discriminated,
                visitor: FernOpenapiIr.OneOfSchemaWithExample._Visitor<_Result>,
            ) {
                return FernOpenapiIr.OneOfSchemaWithExample._visit(this, visitor);
            },
        };
    },

    undiscriminated: (
        value: FernOpenapiIr.UnDiscriminatedOneOfSchemaWithExample,
    ): FernOpenapiIr.OneOfSchemaWithExample.Undiscriminated => {
        return {
            ...value,
            type: "undiscriminated",
            _visit: function <_Result>(
                this: FernOpenapiIr.OneOfSchemaWithExample.Undiscriminated,
                visitor: FernOpenapiIr.OneOfSchemaWithExample._Visitor<_Result>,
            ) {
                return FernOpenapiIr.OneOfSchemaWithExample._visit(this, visitor);
            },
        };
    },

    _visit: <_Result>(
        value: FernOpenapiIr.OneOfSchemaWithExample,
        visitor: FernOpenapiIr.OneOfSchemaWithExample._Visitor<_Result>,
    ): _Result => {
        switch (value.type) {
            case "discriminated":
                return visitor.discriminated(value);
            case "undiscriminated":
                return visitor.undiscriminated(value);
            default:
                return visitor._other(value as any);
        }
    },
} as const;
