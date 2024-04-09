/**
 * This file was auto-generated by Fern from our API Definition.
 */

import { SeedNoEnvironmentClient } from "../src/Client";

const client = new SeedNoEnvironmentClient({
    environment: process.env.TESTS_BASE_URL || "test",
    token: process.env.TESTS_AUTH || "test",
});

describe("Dummy", () => {
    test("constructor", () => {
        expect(client.dummy).toBeDefined();
    });
});