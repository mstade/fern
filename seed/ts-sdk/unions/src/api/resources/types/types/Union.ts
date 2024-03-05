/**
 * This file was auto-generated by Fern from our API Definition.
 */

import * as SeedUnions from "../../..";

/**
 * This is a simple union.
 */
export type Union = SeedUnions.Union.Foo | SeedUnions.Union.Bar;

export declare namespace Union {
    interface Foo {
        type: "foo";
        foo: SeedUnions.Foo;
    }

    interface Bar {
        type: "bar";
        bar: SeedUnions.Bar;
    }
}
