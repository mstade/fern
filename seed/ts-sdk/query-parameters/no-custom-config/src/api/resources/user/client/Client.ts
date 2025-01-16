/**
 * This file was auto-generated by Fern from our API Definition.
 */

import * as core from "../../../../core";
import * as SeedQueryParameters from "../../../index";
import * as serializers from "../../../../serialization/index";
import { toJson } from "../../../../core/json";
import urlJoin from "url-join";
import * as errors from "../../../../errors/index";

export declare namespace User {
    export interface Options {
        environment: core.Supplier<string>;
        /** Specify a custom URL to connect the client to. */
        baseUrl?: core.Supplier<string>;
    }

    export interface RequestOptions {
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

export class User {
    constructor(protected readonly _options: User.Options) {}

    /**
     * @param {SeedQueryParameters.GetUsersRequest} request
     * @param {User.RequestOptions} requestOptions - Request-specific configuration.
     */
    public async getUsername(
        request: SeedQueryParameters.GetUsersRequest,
        requestOptions?: User.RequestOptions,
    ): Promise<SeedQueryParameters.User> {
        const {
            limit,
            id,
            date,
            deadline,
            bytes,
            user,
            userList,
            optionalDeadline,
            keyValue,
            optionalString,
            nestedUser,
            optionalUser,
            excludeUser,
            filter,
        } = request;
        const _queryParams: Record<string, string | string[] | object | object[] | null> = {};
        _queryParams["limit"] = limit.toString();
        _queryParams["id"] = id;
        _queryParams["date"] = date;
        _queryParams["deadline"] = deadline.toISOString();
        _queryParams["bytes"] = bytes;
        _queryParams["user"] = serializers.User.jsonOrThrow(user, {
            unrecognizedObjectKeys: "passthrough",
            allowUnrecognizedUnionMembers: true,
            allowUnrecognizedEnumValues: true,
            breadcrumbsPrefix: ["request", "user"],
        });
        _queryParams["userList"] = toJson(userList);
        if (optionalDeadline != null) {
            _queryParams["optionalDeadline"] = optionalDeadline.toISOString();
        }

        _queryParams["keyValue"] = toJson(keyValue);
        if (optionalString != null) {
            _queryParams["optionalString"] = optionalString;
        }

        _queryParams["nestedUser"] = serializers.NestedUser.jsonOrThrow(nestedUser, {
            unrecognizedObjectKeys: "passthrough",
            allowUnrecognizedUnionMembers: true,
            allowUnrecognizedEnumValues: true,
            breadcrumbsPrefix: ["request", "nestedUser"],
        });
        if (optionalUser != null) {
            _queryParams["optionalUser"] = serializers.User.jsonOrThrow(optionalUser, {
                unrecognizedObjectKeys: "passthrough",
                allowUnrecognizedUnionMembers: true,
                allowUnrecognizedEnumValues: true,
                breadcrumbsPrefix: ["request", "optionalUser"],
            });
        }

        if (Array.isArray(excludeUser)) {
            _queryParams["excludeUser"] = await Promise.all(
                excludeUser.map(async (item) =>
                    serializers.User.jsonOrThrow(item, {
                        unrecognizedObjectKeys: "passthrough",
                        allowUnrecognizedUnionMembers: true,
                        allowUnrecognizedEnumValues: true,
                        breadcrumbsPrefix: ["request", "excludeUser"],
                    }),
                ),
            );
        } else {
            _queryParams["excludeUser"] = serializers.User.jsonOrThrow(excludeUser, {
                unrecognizedObjectKeys: "passthrough",
                allowUnrecognizedUnionMembers: true,
                allowUnrecognizedEnumValues: true,
                breadcrumbsPrefix: ["request", "excludeUser"],
            });
        }

        if (Array.isArray(filter)) {
            _queryParams["filter"] = filter.map((item) => item);
        } else {
            _queryParams["filter"] = filter;
        }

        const _response = await core.fetcher({
            url: urlJoin(
                (await core.Supplier.get(this._options.baseUrl)) ??
                    (await core.Supplier.get(this._options.environment)),
                "/user",
            ),
            method: "GET",
            headers: {
                "X-Fern-Language": "JavaScript",
                "X-Fern-SDK-Name": "@fern/query-parameters",
                "X-Fern-SDK-Version": "0.0.1",
                "User-Agent": "@fern/query-parameters/0.0.1",
                "X-Fern-Runtime": core.RUNTIME.type,
                "X-Fern-Runtime-Version": core.RUNTIME.version,
                ...requestOptions?.headers,
            },
            contentType: "application/json",
            queryParameters: _queryParams,
            requestType: "json",
            timeoutMs: requestOptions?.timeoutInSeconds != null ? requestOptions.timeoutInSeconds * 1000 : 60000,
            maxRetries: requestOptions?.maxRetries,
            abortSignal: requestOptions?.abortSignal,
        });
        if (_response.ok) {
            return serializers.User.parseOrThrow(_response.body, {
                unrecognizedObjectKeys: "passthrough",
                allowUnrecognizedUnionMembers: true,
                allowUnrecognizedEnumValues: true,
                breadcrumbsPrefix: ["response"],
            });
        }

        if (_response.error.reason === "status-code") {
            throw new errors.SeedQueryParametersError({
                statusCode: _response.error.statusCode,
                body: _response.error.body,
            });
        }

        switch (_response.error.reason) {
            case "non-json":
                throw new errors.SeedQueryParametersError({
                    statusCode: _response.error.statusCode,
                    body: _response.error.rawBody,
                });
            case "timeout":
                throw new errors.SeedQueryParametersTimeoutError("Timeout exceeded when calling GET /user.");
            case "unknown":
                throw new errors.SeedQueryParametersError({
                    message: _response.error.errorMessage,
                });
        }
    }
}
