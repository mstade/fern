/**
 * This file was auto-generated by Fern from our API Definition.
 */

import * as SeedExhaustive from "../../../../index";

/**
 * @example
 *     {
 *         string: "string",
 *         integer: 1,
 *         nestedObject: {
 *             string: "string",
 *             integer: 1,
 *             long: BigInt("1000000"),
 *             double: 1.1,
 *             bool: true,
 *             datetime: "2024-01-15T09:30:00Z",
 *             date: "2023-01-15",
 *             uuid: "d5e9c84f-c2b2-4bf4-b4b0-7ffd7a9ffc32",
 *             base64: "SGVsbG8gd29ybGQh",
 *             list: ["list", "list"],
 *             set: new Set(["set"]),
 *             map: {
 *                 1: "map"
 *             },
 *             bigint: BigInt("1000000")
 *         }
 *     }
 */
export interface PostWithObjectBody {
    string: string;
    integer: number;
    nestedObject: SeedExhaustive.types.ObjectWithOptionalField;
}
