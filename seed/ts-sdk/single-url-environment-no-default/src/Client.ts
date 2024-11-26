/**
 * This file was auto-generated by Fern from our API Definition.
 */

import * as environments from "./environments";
import * as core from "./core";
import { Dummy } from "./api/resources/dummy/client/Client";

export declare namespace SeedSingleUrlEnvironmentNoDefaultClient {
    interface Options {
        environment: core.Supplier<environments.SeedSingleUrlEnvironmentNoDefaultEnvironment | string>;
        token: core.Supplier<core.BearerToken>;
    }

    interface RequestOptions {
        /** The maximum time to wait for a response in seconds. */
        timeoutInSeconds?: number;
        /** The number of times to retry the request. Defaults to 2. */
        maxRetries?: number;
        /** A hook to abort the request. */
        abortSignal?: AbortSignal;
        /** Additional headers to include in the request. */
        headers?: Record<string, string>;
    }
}

export class SeedSingleUrlEnvironmentNoDefaultClient {
    constructor(protected readonly _options: SeedSingleUrlEnvironmentNoDefaultClient.Options) {}

    protected _dummy: Dummy | undefined;

    public get dummy(): Dummy {
        return (this._dummy ??= new Dummy(this._options));
    }
}
