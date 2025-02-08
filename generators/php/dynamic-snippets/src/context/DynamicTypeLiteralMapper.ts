import { Severity } from "@fern-api/browser-compatible-base-generator";
import { assertNever } from "@fern-api/core-utils";
import { FernIr } from "@fern-api/dynamic-ir-sdk";
import { php } from "@fern-api/php-codegen";

import { DynamicSnippetsGeneratorContext } from "./DynamicSnippetsGeneratorContext";

export declare namespace DynamicTypeLiteralMapper {
    interface Args {
        typeReference: FernIr.dynamic.TypeReference;
        value: unknown;
        as?: ConvertedAs;
    }

    // Identifies what the type is being converted as, which sometimes influences how
    // the type is instantiated.
    type ConvertedAs = "key";
}

export class DynamicTypeLiteralMapper {
    private context: DynamicSnippetsGeneratorContext;

    constructor({ context }: { context: DynamicSnippetsGeneratorContext }) {
        this.context = context;
    }

    public convert(args: DynamicTypeLiteralMapper.Args): php.TypeLiteral {
        // eslint-disable-next-line eqeqeq
        if (args.value === null) {
            if (this.context.isNullable(args.typeReference)) {
                return php.TypeLiteral.null();
            }
            this.context.errors.add({
                severity: Severity.Critical,
                message: "Expected non-null value, but got null"
            });
            return php.TypeLiteral.nop();
        }
        if (args.value === undefined) {
            return php.TypeLiteral.nop();
        }
        switch (args.typeReference.type) {
            case "list":
            case "set":
                return this.convertList({ list: args.typeReference.value, value: args.value });
            case "literal":
                return this.convertLiteral({ literalType: args.typeReference.value, value: args.value });
            case "map":
                return this.convertMap({ map: args.typeReference, value: args.value });
            case "named": {
                const named = this.context.resolveNamedType({ typeId: args.typeReference.value });
                if (named == null) {
                    return php.TypeLiteral.nop();
                }
                return this.convertNamed({ named, value: args.value, as: args.as });
            }
            case "optional":
                return this.convert({ typeReference: args.typeReference.value, value: args.value, as: args.as });
            case "nullable":
                return this.convert({ typeReference: args.typeReference.value, value: args.value, as: args.as });
            case "primitive":
                return this.convertPrimitive({ primitive: args.typeReference.value, value: args.value, as: args.as });
            case "unknown":
                return this.convertUnknown({ value: args.value });
            default:
                assertNever(args.typeReference);
        }
    }

    private convertLiteral({
        literalType,
        value
    }: {
        literalType: FernIr.dynamic.LiteralType;
        value: unknown;
    }): php.TypeLiteral {
        switch (literalType.type) {
            case "boolean": {
                const bool = this.context.getValueAsBoolean({ value });
                if (bool == null) {
                    return php.TypeLiteral.nop();
                }
                return php.TypeLiteral.boolean(bool);
            }
            case "string": {
                const str = this.context.getValueAsString({ value });
                if (str == null) {
                    return php.TypeLiteral.nop();
                }
                return php.TypeLiteral.string(str);
            }
            default:
                assertNever(literalType);
        }
    }

    private convertList({ list, value }: { list: FernIr.dynamic.TypeReference; value: unknown }): php.TypeLiteral {
        if (!Array.isArray(value)) {
            this.context.errors.add({
                severity: Severity.Critical,
                message: `Expected array but got: ${typeof value}`
            });
            return php.TypeLiteral.nop();
        }
        return php.TypeLiteral.list({
            values: value.map((v, index) => {
                this.context.errors.scope({ index });
                try {
                    return this.convert({ typeReference: list, value: v });
                } finally {
                    this.context.errors.unscope();
                }
            })
        });
    }

    private convertMap({ map, value }: { map: FernIr.dynamic.MapType; value: unknown }): php.TypeLiteral {
        if (typeof value !== "object" || value == null) {
            this.context.errors.add({
                severity: Severity.Critical,
                message: `Expected object but got: ${value == null ? "null" : typeof value}`
            });
            return php.TypeLiteral.nop();
        }
        return php.TypeLiteral.map({
            entries: Object.entries(value).map(([key, value]) => {
                this.context.errors.scope(key);
                try {
                    return {
                        key: this.convert({ typeReference: map.key, value: key, as: "key" }),
                        value: this.convert({ typeReference: map.value, value })
                    };
                } finally {
                    this.context.errors.unscope();
                }
            })
        });
    }

    private convertNamed({
        named,
        value,
        as
    }: {
        named: FernIr.dynamic.NamedType;
        value: unknown;
        as?: DynamicTypeLiteralMapper.ConvertedAs;
    }): php.TypeLiteral {
        switch (named.type) {
            case "alias": {
                return this.convert({ typeReference: named.typeReference, value, as });
            }
            case "discriminatedUnion":
                return this.convertDiscriminatedUnion({
                    discriminatedUnion: named,
                    value
                });
            case "enum":
                return this.convertEnum({ enum_: named, value });
            case "object":
                return this.convertObject({ object_: named, value });
            case "undiscriminatedUnion":
                return this.convertUndiscriminatedUnion({ undiscriminatedUnion: named, value });
            default:
                assertNever(named);
        }
    }

    private convertDiscriminatedUnion({
        discriminatedUnion,
        value
    }: {
        discriminatedUnion: FernIr.dynamic.DiscriminatedUnionType;
        value: unknown;
    }): php.TypeLiteral {
        // TODO: Implement me!
        return php.TypeLiteral.string("todo");
    }

    private convertObject({ object_, value }: { object_: FernIr.dynamic.ObjectType; value: unknown }): php.TypeLiteral {
        const properties = this.context.associateByWireValue({
            parameters: object_.properties,
            values: this.context.getRecord(value) ?? {}
        });
        return php.TypeLiteral.class_({
            reference: php.classReference({
                name: this.context.getClassName(object_.declaration.name),
                namespace: this.context.getTypesNamespace(object_.declaration.fernFilepath)
            }),
            fields: properties.map((property) => {
                this.context.errors.scope(property.name.wireValue);
                try {
                    return {
                        name: this.context.getPropertyName(property.name.name),
                        value: this.convert(property)
                    };
                } finally {
                    this.context.errors.unscope();
                }
            })
        });
    }

    private convertEnum({ enum_, value }: { enum_: FernIr.dynamic.EnumType; value: unknown }): php.TypeLiteral {
        const name = this.getEnumValueName({ enum_, value });
        if (name == null) {
            return php.TypeLiteral.nop();
        }
        return php.TypeLiteral.reference(
            php.codeblock((writer) => {
                writer.writeNode(
                    php.classReference({
                        name: this.context.getClassName(enum_.declaration.name),
                        namespace: this.context.getTypesNamespace(enum_.declaration.fernFilepath)
                    })
                );
                writer.write("::");
                writer.write(name);
                writer.write("->value");
            })
        );
    }

    private getEnumValueName({ enum_, value }: { enum_: FernIr.dynamic.EnumType; value: unknown }): string | undefined {
        if (typeof value !== "string") {
            this.context.errors.add({
                severity: Severity.Critical,
                message: `Expected enum value string, got: ${typeof value}`
            });
            return undefined;
        }
        const enumValue = enum_.values.find((v) => v.wireValue === value);
        if (enumValue == null) {
            this.context.errors.add({
                severity: Severity.Critical,
                message: `An enum value named "${value}" does not exist in this context`
            });
            return undefined;
        }
        return this.context.getClassName(enumValue.name);
    }

    private convertUndiscriminatedUnion({
        undiscriminatedUnion,
        value
    }: {
        undiscriminatedUnion: FernIr.dynamic.UndiscriminatedUnionType;
        value: unknown;
    }): php.TypeLiteral {
        const result = this.findMatchingUndiscriminatedUnionType({
            undiscriminatedUnion,
            value
        });
        if (result == null) {
            return php.TypeLiteral.nop();
        }
        return result;
    }

    private findMatchingUndiscriminatedUnionType({
        undiscriminatedUnion,
        value
    }: {
        undiscriminatedUnion: FernIr.dynamic.UndiscriminatedUnionType;
        value: unknown;
    }): php.TypeLiteral | undefined {
        for (const typeReference of undiscriminatedUnion.types) {
            try {
                return this.convert({ typeReference, value });
            } catch (e) {
                continue;
            }
        }
        this.context.errors.add({
            severity: Severity.Critical,
            message: `None of the types in the undiscriminated union matched the given "${typeof value}" value`
        });
        return undefined;
    }

    private convertUnknown({ value }: { value: unknown }): php.TypeLiteral {
        return php.TypeLiteral.unknown(value);
    }

    private convertPrimitive({
        primitive,
        value,
        as
    }: {
        primitive: FernIr.PrimitiveTypeV1;
        value: unknown;
        as?: DynamicTypeLiteralMapper.ConvertedAs;
    }): php.TypeLiteral {
        switch (primitive) {
            case "INTEGER":
            case "LONG":
            case "UINT":
            case "UINT_64": {
                const num = this.getValueAsNumber({ value, as });
                if (num == null) {
                    return php.TypeLiteral.nop();
                }
                return php.TypeLiteral.number(num);
            }
            case "FLOAT":
            case "DOUBLE": {
                const num = this.getValueAsNumber({ value });
                if (num == null) {
                    return php.TypeLiteral.nop();
                }
                return php.TypeLiteral.float(num);
            }
            case "BOOLEAN": {
                const bool = this.getValueAsBoolean({ value, as });
                if (bool == null) {
                    return php.TypeLiteral.nop();
                }
                return php.TypeLiteral.boolean(bool);
            }
            case "DATE":
            case "DATE_TIME": {
                const str = this.context.getValueAsString({ value });
                if (str == null) {
                    return php.TypeLiteral.nop();
                }
                return php.TypeLiteral.datetime(str);
            }
            case "BASE_64":
            case "UUID":
            case "BIG_INTEGER":
            case "STRING": {
                const str = this.context.getValueAsString({ value });
                if (str == null) {
                    return php.TypeLiteral.nop();
                }
                return php.TypeLiteral.string(str);
            }
            default:
                assertNever(primitive);
        }
    }

    private getValueAsNumber({
        value,
        as
    }: {
        value: unknown;
        as?: DynamicTypeLiteralMapper.ConvertedAs;
    }): number | undefined {
        const num = as === "key" ? (typeof value === "string" ? Number(value) : value) : value;
        return this.context.getValueAsNumber({ value: num });
    }

    private getValueAsBoolean({
        value,
        as
    }: {
        value: unknown;
        as?: DynamicTypeLiteralMapper.ConvertedAs;
    }): boolean | undefined {
        const bool =
            as === "key" ? (typeof value === "string" ? value === "true" : value === "false" ? false : value) : value;
        return this.context.getValueAsBoolean({ value: bool });
    }
}
