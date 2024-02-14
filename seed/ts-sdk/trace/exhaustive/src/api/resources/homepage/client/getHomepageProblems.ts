/**
 * This file was auto-generated by Fern from our API Definition.
 */

import * as SeedTrace from "../../..";
import * as core from "../../../../core";

export type Error = SeedTrace.homepage.getHomepageProblems.Error._Unknown;

export declare namespace Error {
    interface _Unknown extends _Utils {
        errorName: void;
        content: core.Fetcher.Error;
    }

    interface _Utils {
        _visit: <_Result>(visitor: SeedTrace.homepage.getHomepageProblems.Error._Visitor<_Result>) => _Result;
    }

    interface _Visitor<_Result> {
        _other: (value: core.Fetcher.Error) => _Result;
    }
}

export const Error = {
    _unknown: (fetcherError: core.Fetcher.Error): SeedTrace.homepage.getHomepageProblems.Error._Unknown => {
        return {
            errorName: undefined,
            content: fetcherError,
            _visit: function <_Result>(
                this: SeedTrace.homepage.getHomepageProblems.Error._Unknown,
                visitor: SeedTrace.homepage.getHomepageProblems.Error._Visitor<_Result>
            ) {
                return SeedTrace.homepage.getHomepageProblems.Error._visit(this, visitor);
            },
        };
    },

    _visit: <_Result>(
        value: SeedTrace.homepage.getHomepageProblems.Error,
        visitor: SeedTrace.homepage.getHomepageProblems.Error._Visitor<_Result>
    ): _Result => {
        switch (value.errorName) {
            default:
                return visitor._other(value as any);
        }
    },
} as const;