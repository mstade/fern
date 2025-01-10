import { SeedExamplesClient } from "../..";

async function main() {
    const client = new SeedExamplesClient({
        environment: "https://api.fern.com",
        token: "<token>",
    });
    await client.file.service.getFile("filename", {
        "X-File-API-Version": "X-File-API-Version",
    });
}
main();
