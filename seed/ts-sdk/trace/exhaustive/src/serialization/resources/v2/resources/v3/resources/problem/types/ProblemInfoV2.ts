/**
 * This file was auto-generated by Fern from our API Definition.
 */

import * as serializers from "../../../../../../../index";
import * as SeedTrace from "../../../../../../../../api/index";
import * as core from "../../../../../../../../core";
import { ProblemId } from "../../../../../../commons/types/ProblemId";
import { ProblemDescription } from "../../../../../../problem/types/ProblemDescription";
import { Language } from "../../../../../../commons/types/Language";
import { CustomFiles } from "./CustomFiles";
import { GeneratedFiles } from "./GeneratedFiles";
import { TestCaseTemplate } from "./TestCaseTemplate";
import { TestCaseV2 } from "./TestCaseV2";

export const ProblemInfoV2: core.serialization.ObjectSchema<
    serializers.v2.v3.ProblemInfoV2.Raw,
    SeedTrace.v2.v3.ProblemInfoV2
> = core.serialization.object({
    problemId: ProblemId,
    problemDescription: ProblemDescription,
    problemName: core.serialization.string(),
    problemVersion: core.serialization.number(),
    supportedLanguages: core.serialization.set(Language),
    customFiles: CustomFiles,
    generatedFiles: GeneratedFiles,
    customTestCaseTemplates: core.serialization.list(TestCaseTemplate),
    testcases: core.serialization.list(TestCaseV2),
    isPublic: core.serialization.boolean(),
});

export declare namespace ProblemInfoV2 {
    export interface Raw {
        problemId: ProblemId.Raw;
        problemDescription: ProblemDescription.Raw;
        problemName: string;
        problemVersion: number;
        supportedLanguages: Language.Raw[];
        customFiles: CustomFiles.Raw;
        generatedFiles: GeneratedFiles.Raw;
        customTestCaseTemplates: TestCaseTemplate.Raw[];
        testcases: TestCaseV2.Raw[];
        isPublic: boolean;
    }
}
