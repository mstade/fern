import { AbstractProject } from "@fern-api/generator-commons";
import { AbstractPythonGeneratorContext } from "../cli";
import { BasePythonCustomConfigSchema } from "../custom-config";
import { WriteablePythonFile } from "./WriteablePythonFile";
import { loggingExeca } from "@fern-api/logging-execa";

/**
 * In memory representation of a Python project.
 */
export class PythonProject extends AbstractProject<AbstractPythonGeneratorContext<BasePythonCustomConfigSchema>> {
    private sourceFiles: WriteablePythonFile[] = [];

    public constructor({ context }: { context: AbstractPythonGeneratorContext<BasePythonCustomConfigSchema> }) {
        super(context);
    }

    public addSourceFiles(file: WriteablePythonFile): void {
        this.sourceFiles.push(file);
    }

    public async persist(): Promise<void> {
        await Promise.all(
            this.sourceFiles.map(async (file) => {
                return await file.write(this.absolutePathToOutputDirectory);
            })
        );
        await loggingExeca(undefined, "ruff", ["format", "."], {
            cwd: this.absolutePathToOutputDirectory
        });
    }
}
