import {
    AliasTypeDeclaration,
    ContainerType,
    DeclaredTypeName,
    Literal,
    MapType,
    PrimitiveType,
    SingleUnionTypeProperties,
    SingleUnionTypeProperty,
    TypeDeclaration,
    TypeId,
    TypeReference
} from "@fern-fern/ir-sdk/api";
import { format } from "util";
import { getLocationForTypeDeclaration } from "../AbstractionUtilities";
import { Argument } from "../Argument";
import { AstNode } from "../core/AstNode";
import { Expression } from "../expressions/Expression";
import { FunctionInvocation } from "../functions/FunctionInvocation";
import { Function_ } from "../functions/Function_";
import { Import } from "../Import";
import { Module_ } from "../Module_";
import { Variable } from "../Variable";

enum RubyClass {
    INTEGER = "Integer",
    DOUBLE = "Float",
    STRING = "String",
    BOOLEAN = "Boolean",
    LONG = "Long",
    DATETIME = "DateTime",
    DATE = "Date",
    UUID = "UUID",
    // eslint-disable-next-line @typescript-eslint/no-duplicate-enum-values
    BASE64 = "String",
    OBJECT = "Object",
    JSON = "JSON",
    OPENSTRUCT = "OpenStruct",
    VOID = "Void"
}

export declare namespace ClassReference {
    export interface Init extends AstNode.Init {
        name: string;
        typeHint?: string;
        import_?: Import;
        location?: string;
        moduleBreadcrumbs?: string[];
    }
}

export class ClassReference extends AstNode {
    public name: string;
    public typeHint: string;
    public qualifiedName: string;
    public import_: Import | undefined;
    public location: string | undefined;

    constructor({ name, typeHint, import_, location, moduleBreadcrumbs, ...rest }: ClassReference.Init) {
        super(rest);
        this.location = location;
        this.name = name;
        this.import_ = import_;

        this.qualifiedName = [...(moduleBreadcrumbs ?? []), name].join("::");
        this.typeHint = typeHint ?? this.qualifiedName;
    }

    public writeInternal(startingTabSpaces: number): void {
        this.addText({ stringContent: this.qualifiedName, startingTabSpaces });
    }

    public toJson(_variable: Variable | string): FunctionInvocation | undefined {
        return;
    }

    public fromJson(_variable: Variable | string): FunctionInvocation | undefined {
        return;
    }

    // This creates a function meant to validate a variable holding the raw version of this class
    // for objects that would be a hash, for primitives it is the outright type, so is_a? is the default
    public validateRaw(variable: Variable | string, isOptional = false): FunctionInvocation | Expression {
        const fi = new FunctionInvocation({
            baseFunction: new Function_({ name: "is_a?", functionBody: [] }),
            onObject: variable,
            arguments_: [new Argument({ value: this.qualifiedName, isNamed: false, type: GenericClassReference })],
            optionalSafeCall: isOptional
        });
        return new Expression({
            leftSide: new Expression({
                leftSide: fi,
                rightSide: "false",
                operation: "!=",
                isAssignment: false
            }),
            rightSide: `raise("Passed value for field ${
                variable instanceof Variable ? variable.name : variable
            } is not the expected type, validation failed.")`,
            operation: "||",
            isAssignment: false
        });
    }

    public getImports(): Set<Import> {
        return new Set(this.import_ ? [this.import_] : []);
    }
}

export const OpenStructClassReference = new ClassReference({ name: RubyClass.OPENSTRUCT });
export const GenericClassReference = new ClassReference({ name: RubyClass.OBJECT });
export const JsonClassReference = new ClassReference({ name: RubyClass.JSON });
export const VoidClassReference = new ClassReference({ name: RubyClass.VOID });
export const BooleanClassReference = new ClassReference({ name: RubyClass.BOOLEAN });
export const StringClassReference = new ClassReference({ name: RubyClass.STRING });
export const NilValue = "nil";

export declare namespace SerializableObjectReference {
    export type InitReference = ClassReference.Init;
}
export class SerializableObjectReference extends ClassReference {
    constructor(init: SerializableObjectReference.InitReference) {
        super({ ...init });
    }

    public fromJson(variable: string | Variable): FunctionInvocation | undefined {
        return new FunctionInvocation({
            baseFunction: new Function_({ name: "from_json", functionBody: [] }),
            onObject: this.qualifiedName,
            arguments_: [
                new Argument({ type: GenericClassReference, value: variable, isNamed: true, name: "json_object" })
            ]
        });
    }

    public validateRaw(variable: Variable | string, isOptional = false): FunctionInvocation | Expression {
        const fi = new FunctionInvocation({
            baseFunction: new Function_({ name: "validate_raw", functionBody: [] }),
            // Recreate the variable to force isOptional to raise if a required variable is optional
            onObject: this,
            arguments_: [new Argument({ value: variable, isNamed: true, name: "obj", type: GenericClassReference })]
        });

        return !isOptional
            ? fi
            : new Expression({
                  leftSide: new FunctionInvocation({
                      baseFunction: new Function_({ name: "nil?", functionBody: [] }),
                      // Recreate the variable to force isOptional to raise if a required variable is optional
                      onObject: variable,
                      optionalSafeCall: false
                  }),
                  rightSide: fi,
                  operation: "||",
                  isAssignment: false
              });
    }

    static fromDeclaredTypeName(declaredTypeName: DeclaredTypeName): ClassReference {
        // TODO: there's probably a cleaner way of doing this, but here we're ensuring type files
        // are written to a "types" subdirectory
        const crName = declaredTypeName.name.pascalCase.safeName;
        const location = getLocationForTypeDeclaration(declaredTypeName);
        const moduleBreadcrumbs = Module_.getModulePathFromTypeName(declaredTypeName);
        return new SerializableObjectReference({
            name: crName,
            import_: new Import({ from: `${location}/${crName}` }),
            location,
            moduleBreadcrumbs
        });
    }
}

export declare namespace AliasReference {
    export interface Init extends ClassReference.Init {
        aliasOf: ClassReference;
    }
}
export class AliasReference extends ClassReference {
    private aliasOf: ClassReference;
    constructor({ aliasOf, ...rest }: AliasReference.Init) {
        super(rest);
        this.aliasOf = aliasOf;
    }

    public fromJson(variable: string | Variable): FunctionInvocation | undefined {
        return this.aliasOf.fromJson(variable);
    }

    public toJson(variable: string | Variable): FunctionInvocation | undefined {
        return this.aliasOf.toJson(variable);
    }

    public validateRaw(variable: string | Variable, isOptional?: boolean): FunctionInvocation | Expression {
        return this.aliasOf.validateRaw(variable, isOptional);
    }

    static fromDeclaredTypeName(declaredTypeName: DeclaredTypeName, aliasOf: ClassReference): ClassReference {
        // TODO: there's probably a cleaner way of doing this, but here we're ensuring type files
        // are written to a "types" subdirectory
        const crName = declaredTypeName.name.screamingSnakeCase.safeName;
        const location = getLocationForTypeDeclaration(declaredTypeName);
        const moduleBreadcrumbs = Module_.getModulePathFromTypeName(declaredTypeName);
        return new AliasReference({
            aliasOf,
            name: crName,
            import_: new Import({ from: `${location}/${crName}` }),
            location,
            moduleBreadcrumbs
        });
    }
}

export declare namespace ArrayReference {
    export interface InitReference extends AstNode.Init {
        innerType: ClassReference | string;
    }
    export interface InitInstance extends AstNode.Init {
        contents?: string[];
    }
}
export class ArrayReference extends ClassReference {
    private innerType: ClassReference | string;
    constructor({ innerType, ...rest }: ArrayReference.InitReference) {
        const typeName = innerType instanceof ClassReference ? innerType.qualifiedName : innerType;
        super({
            name: "Array",
            typeHint: `Array<${typeName}>`,
            import_: innerType instanceof ClassReference ? innerType.import_ : undefined,
            ...rest
        });

        this.innerType = innerType;
    }

    public fromJson(variable: string | Variable): FunctionInvocation | undefined {
        const valueFromJsonFunction =
            this.innerType instanceof ClassReference ? this.innerType.fromJson("v") : undefined;
        return valueFromJsonFunction !== undefined
            ? new FunctionInvocation({
                  baseFunction: new Function_({ name: "map", functionBody: [] }),
                  onObject: variable,
                  block: {
                      arguments: "v",
                      expressions: [new Expression({ rightSide: valueFromJsonFunction, isAssignment: false })]
                  }
              })
            : undefined;
    }

    public toJson(variable: string | Variable): FunctionInvocation | undefined {
        const valueToJsonFunction = this.innerType instanceof ClassReference ? this.innerType.toJson("v") : undefined;
        return valueToJsonFunction !== undefined
            ? new FunctionInvocation({
                  baseFunction: new Function_({ name: "map", functionBody: [] }),
                  onObject: variable,
                  block: {
                      arguments: "v",
                      expressions: [new Expression({ rightSide: valueToJsonFunction, isAssignment: false })]
                  }
              })
            : undefined;
    }
}

export class ArrayInstance extends AstNode {
    public contents: string[];
    constructor({ contents = [], ...rest }: ArrayReference.InitInstance) {
        super(rest);
        this.contents = contents;
    }

    public writeInternal(): void {
        this.addText({
            stringContent: this.contents.length > 0 ? this.contents.join(", ") : undefined,
            templateString: "[%s]"
        });
    }
}

export declare namespace Hash_ {
    export interface InitReference extends Omit<ClassReference.Init, "name" | "typeHint"> {
        name?: string;
        keyType: ClassReference | string;
        valueType: ClassReference | string;
    }
    export interface InitInstance extends AstNode.Init {
        contents?: Map<string, string | FunctionInvocation | Variable>;
        // allow for spreading additional hashes into this hash.
        additionalHashes?: AstNode[];
        isFrozen?: boolean;
    }
}
export class HashReference extends ClassReference {
    valueType: ClassReference | string;
    constructor({ name, keyType, valueType, ...rest }: Hash_.InitReference) {
        const keyTypeName = keyType instanceof ClassReference ? keyType.qualifiedName : keyType;
        const valueTypeName = valueType instanceof ClassReference ? valueType.qualifiedName : valueType;
        const typeHint = `Hash{${keyTypeName} => ${valueTypeName}}`;
        const nameDefaulted = name ?? "Hash";
        super({ name: nameDefaulted, typeHint, ...rest });

        this.valueType = valueType;
    }
    public fromJson(variable: string | Variable): FunctionInvocation | undefined {
        const valueFromJsonFunction =
            this.valueType instanceof ClassReference ? this.valueType.fromJson("v") : undefined;
        return valueFromJsonFunction !== undefined
            ? new FunctionInvocation({
                  baseFunction: new Function_({ name: "transform_values", functionBody: [] }),
                  onObject: variable,
                  block: {
                      arguments: "v",
                      expressions: [new Expression({ rightSide: valueFromJsonFunction, isAssignment: false })]
                  }
              })
            : undefined;
    }

    public toJson(variable: string | Variable): FunctionInvocation | undefined {
        const valueToJsonFunction = this.valueType instanceof ClassReference ? this.valueType.fromJson("v") : undefined;
        return valueToJsonFunction !== undefined
            ? new FunctionInvocation({
                  baseFunction: new Function_({ name: "transform_values", functionBody: [] }),
                  onObject: variable,
                  block: {
                      arguments: "v",
                      expressions: [new Expression({ rightSide: valueToJsonFunction, isAssignment: false })]
                  }
              })
            : undefined;
    }
}

export class HashInstance extends AstNode {
    public contents: Map<string, string | FunctionInvocation | Variable>;
    public additionalHashes: AstNode[];
    public isFrozen: boolean;

    constructor({ contents = new Map(), isFrozen = false, additionalHashes = [], ...rest }: Hash_.InitInstance) {
        super(rest);

        this.contents = contents;
        this.isFrozen = isFrozen;
        this.additionalHashes = additionalHashes;
    }

    public writeInternal(): void {
        this.addText({
            stringContent: `{ ${Array.from(this.contents.entries())
                .map(([k, v]) => k + ": " + (v instanceof AstNode ? v.write() : `'${v}'`))
                .join(", ")}${this.additionalHashes.map((ah) => format(", **%s", ah.write()))} }`
        });
        this.addText({ stringContent: this.isFrozen ? ".frozen" : undefined, appendToLastString: true });
    }
}

export declare namespace Enum {
    export interface ReferenceInit extends ClassReference.Init {
        name: string;
    }
    export interface InstanceInit extends ClassReference.Init {
        contents: Map<string, string>;
    }
}

// TODO: allow for per-enum documentation
export class Enum extends HashInstance {
    constructor({ contents, documentation }: Enum.InstanceInit) {
        super({ contents, isFrozen: true, documentation });
    }
}

export class EnumReference extends HashReference {
    constructor({ name }: Enum.ReferenceInit) {
        super({ name, keyType: "String", valueType: "String" });
    }

    public toJson(variable: Variable | string): FunctionInvocation | undefined {
        return new FunctionInvocation({
            baseFunction: new Function_({ name: "fetch", functionBody: [] }),
            onObject: variable
        });
    }

    public fromJson(variable: Variable | string): FunctionInvocation | undefined {
        return new FunctionInvocation({
            baseFunction: new Function_({ name: "key", functionBody: [] }),
            onObject: this,
            arguments_: [new Argument({ value: variable, isNamed: false, type: GenericClassReference })]
        });
    }

    static fromDeclaredTypeName(declaredTypeName: DeclaredTypeName): EnumReference {
        const crName = declaredTypeName.name.screamingSnakeCase.safeName;
        const location = getLocationForTypeDeclaration(declaredTypeName);
        const moduleBreadcrumbs = Module_.getModulePathFromTypeName(declaredTypeName);
        return new EnumReference({
            name: crName,
            import_: new Import({ from: `${location}/${crName}` }),
            location,
            moduleBreadcrumbs
        });
    }
}

export declare namespace Set_ {
    export interface InitReference extends AstNode.Init {
        innerType: ClassReference | string;
    }
    export interface InitInstance extends AstNode.Init {
        contents?: string[];
    }
}
export class SetReference extends ClassReference {
    constructor({ innerType, ...rest }: Set_.InitReference) {
        const typeName = innerType instanceof ClassReference ? innerType.qualifiedName : innerType;
        super({
            name: "Set",
            typeHint: `Set<${typeName}>`,
            import_: new Import({ from: "set", isExternal: true }),
            ...rest
        });
    }

    public toJson(variable: Variable | string): FunctionInvocation | undefined {
        return new FunctionInvocation({
            baseFunction: new Function_({ name: "to_a", functionBody: [] }),
            onObject: variable
        });
    }

    public fromJson(variable: Variable | string): FunctionInvocation | undefined {
        return new FunctionInvocation({
            baseFunction: new Function_({ name: "new", functionBody: [] }),
            onObject: new ClassReference({ name: "Set", import_: new Import({ from: "set", isExternal: true }) }),
            arguments_: [new Argument({ value: variable, isNamed: false, type: GenericClassReference })]
        });
    }
}

export class SetInstance extends AstNode {
    public contents: string[];
    constructor({ contents = [], ...rest }: Set_.InitInstance) {
        super(rest);
        this.contents = contents;
    }

    public writeInternal(): void {
        this.addText({
            stringContent: this.contents.length > 0 ? this.contents.join(", ") : undefined,
            templateString: "Set[%s]"
        });
    }
}

export class ClassReferenceFactory {
    private typeDeclarations: Map<TypeId, TypeDeclaration>;
    private generatedReferences: Map<TypeId, ClassReference>;

    constructor(typeDeclarations: Map<TypeId, TypeDeclaration>) {
        this.typeDeclarations = typeDeclarations;
        this.generatedReferences = new Map();
        for (const [_, type] of typeDeclarations) {
            this.fromTypeDeclaration(type);
        }
    }

    public fromTypeDeclaration(type: TypeDeclaration): ClassReference {
        const typeId = type.name.typeId;
        let cr = this.generatedReferences.get(typeId);
        if (cr === undefined) {
            cr = type.shape._visit<ClassReference>({
                alias: (atd: AliasTypeDeclaration) => {
                    const aliasOfCr = this.fromTypeReference(atd.aliasOf);
                    return AliasReference.fromDeclaredTypeName(type.name, aliasOfCr);
                },
                enum: () => EnumReference.fromDeclaredTypeName(type.name),
                object: () => SerializableObjectReference.fromDeclaredTypeName(type.name),
                union: () => SerializableObjectReference.fromDeclaredTypeName(type.name),
                undiscriminatedUnion: () => SerializableObjectReference.fromDeclaredTypeName(type.name),
                _other: () => {
                    throw new Error("Attempting to generate a class reference for an unknown type.");
                }
            });
            this.generatedReferences.set(typeId, cr);
        }
        return cr;
    }

    public fromDeclaredTypeName(declaredTypeName: DeclaredTypeName): ClassReference {
        const cr = this.generatedReferences.get(declaredTypeName.typeId);
        // Likely you care attempting to generate an alias and the aliased class has not yet been created.
        // Create it now!
        if (cr === undefined) {
            const td = this.typeDeclarations.get(declaredTypeName.typeId);
            if (td !== undefined) {
                return this.fromTypeDeclaration(td);
            }
            throw new Error("ClassReference requested does not exist");
        }
        return cr;
    }

    public fromTypeReference(typeReference: TypeReference): ClassReference {
        return typeReference._visit<ClassReference>({
            container: (ct) => this.forContainerType(ct),
            named: (dtn) => this.fromDeclaredTypeName(dtn),
            primitive: (pt) => this.forPrimitiveType(pt),
            _other: (value: { type: string }) => new ClassReference({ name: value.type }),
            unknown: () => GenericClassReference
        });
    }

    public forPrimitiveType(primitive: PrimitiveType): ClassReference {
        return PrimitiveType._visit<ClassReference>(primitive, {
            integer: () => new ClassReference({ name: RubyClass.INTEGER }),
            double: () => new ClassReference({ name: RubyClass.DOUBLE }),
            string: () => StringClassReference,
            boolean: () => BooleanClassReference,
            long: () => new ClassReference({ name: RubyClass.LONG }),
            dateTime: () => new ClassReference({ name: RubyClass.DATETIME }),
            date: () => new ClassReference({ name: RubyClass.DATE }),
            uuid: () => new ClassReference({ name: RubyClass.UUID }),
            base64: () => new ClassReference({ name: RubyClass.BASE64 }),
            _other: () => {
                throw new Error("Unexpected primitive type: " + primitive);
            }
        });
    }

    public forContainerType(containerType: ContainerType): ClassReference {
        return containerType._visit<ClassReference>({
            list: (tr: TypeReference) => new ArrayReference({ innerType: this.fromTypeReference(tr) }),
            map: (mt: MapType) =>
                new HashReference({
                    keyType: this.fromTypeReference(mt.keyType),
                    valueType: this.fromTypeReference(mt.keyType)
                }),
            // Optional types in Ruby look the same except they're defaulted to nil in signatures.
            optional: (tr: TypeReference) => this.fromTypeReference(tr),
            set: (tr: TypeReference) => new SetReference({ innerType: this.fromTypeReference(tr) }),
            literal: (lit: Literal) =>
                Literal._visit<ClassReference>(lit, {
                    string: () => StringClassReference,
                    boolean: () => BooleanClassReference,
                    _other: (value: { type: string }) => new ClassReference({ name: value.type })
                }),
            _other: () => {
                throw new Error("Unexpected primitive type: " + containerType.type);
            }
        });
    }

    public classReferenceFromUnionType(
        singleUnionTypeProperties: SingleUnionTypeProperties
    ): ClassReference | undefined {
        return singleUnionTypeProperties._visit<ClassReference | undefined>({
            samePropertiesAsObject: (dtn) => this.fromDeclaredTypeName(dtn),
            singleProperty: (sutp: SingleUnionTypeProperty) => this.fromTypeReference(sutp.type),
            noProperties: () => undefined,
            _other: () => {
                throw new Error();
            }
        });
    }
}