/**
 * This file was auto-generated by Fern from our API Definition.
 */

import * as core from "../../../../core";
import * as Fiddle from "../../../index";
import * as serializers from "../../../../serialization/index";
import urlJoin from "url-join";

export declare namespace InlinedRequests {
    interface Options {
        environment: core.Supplier<string>;
        token?: core.Supplier<core.BearerToken | undefined>;
    }

    interface RequestOptions {
        timeoutInSeconds?: number;
        maxRetries?: number;
    }
}

export class InlinedRequests {
    constructor(protected readonly _options: InlinedRequests.Options) {}

    /**
     * POST with custom object in request body, response is an object
     *
     * @param {Fiddle.PostWithObjectBody} request
     * @param {InlinedRequests.RequestOptions} requestOptions - Request-specific configuration.
     *
     * @example
     *     await fiddle.inlinedRequests.postWithObjectBodyandResponse({
     *         string: "string",
     *         integer: 1,
     *         nestedObject: {
     *             string: "string",
     *             integer: 1,
     *             long: 1000000,
     *             double: 1.1,
     *             bool: true,
     *             datetime: new Date("2024-01-15T09:30:00.000Z"),
     *             date: "2023-01-15",
     *             uuid: "d5e9c84f-c2b2-4bf4-b4b0-7ffd7a9ffc32",
     *             base64: "SGVsbG8gd29ybGQh",
     *             list: ["string"],
     *             set: new Set(["string"]),
     *             map: {
     *                 1: "string"
     *             }
     *         }
     *     })
     */
    public async postWithObjectBodyandResponse(
        request: Fiddle.PostWithObjectBody,
        requestOptions?: InlinedRequests.RequestOptions
    ): Promise<
        core.APIResponse<
            Fiddle.types.ObjectWithOptionalField,
            Fiddle.inlinedRequests.postWithObjectBodyandResponse.Error
        >
    > {
        const _response = await core.fetcher({
            url: urlJoin(await core.Supplier.get(this._options.environment), "/req-bodies/object"),
            method: "POST",
            headers: {
                Authorization: await this._getAuthorizationHeader(),
                "X-Fern-Language": "JavaScript",
                "X-Fern-SDK-Name": "@fern/exhaustive",
                "X-Fern-SDK-Version": "0.0.1",
                "X-Fern-Runtime": core.RUNTIME.type,
                "X-Fern-Runtime-Version": core.RUNTIME.version,
            },
            contentType: "application/json",
            body: await serializers.PostWithObjectBody.jsonOrThrow(request, { unrecognizedObjectKeys: "strip" }),
            timeoutMs: requestOptions?.timeoutInSeconds != null ? requestOptions.timeoutInSeconds * 1000 : 60000,
            maxRetries: requestOptions?.maxRetries,
        });
        if (_response.ok) {
            return {
                ok: true,
                body: await serializers.types.ObjectWithOptionalField.parseOrThrow(_response.body, {
                    unrecognizedObjectKeys: "passthrough",
                    allowUnrecognizedUnionMembers: true,
                    allowUnrecognizedEnumValues: true,
                    breadcrumbsPrefix: ["response"],
                }),
            };
        }

        if (_response.error.reason === "status-code") {
            switch (_response.error.statusCode) {
                case 400:
                    return {
                        ok: false,
                        error: Fiddle.inlinedRequests.postWithObjectBodyandResponse.Error.badRequestBody(
                            await serializers.BadObjectRequestInfo.parseOrThrow(_response.error.body, {
                                unrecognizedObjectKeys: "passthrough",
                                allowUnrecognizedUnionMembers: true,
                                allowUnrecognizedEnumValues: true,
                                breadcrumbsPrefix: ["response"],
                            })
                        ),
                    };
            }
        }

        return {
            ok: false,
            error: Fiddle.inlinedRequests.postWithObjectBodyandResponse.Error._unknown(_response.error),
        };
    }

    protected async _getAuthorizationHeader(): Promise<string | undefined> {
        const bearer = await core.Supplier.get(this._options.token);
        if (bearer != null) {
            return `Bearer ${bearer}`;
        }

        return undefined;
    }
}
