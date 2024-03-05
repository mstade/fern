/**
 * This file was auto-generated by Fern from our API Definition.
 */

import * as SeedUnions from "../../..";

export type UnionWithDiscriminant =
    /**
     * This is a Foo field. */
    SeedUnions.UnionWithDiscriminant.Foo | SeedUnions.UnionWithDiscriminant.Bar;

export declare namespace UnionWithDiscriminant {
    interface Foo {
        type: "foo";
        foo: SeedUnions.Foo;
    }

    interface Bar {
        type: "bar";
        bar: SeedUnions.Bar;
    }
}
