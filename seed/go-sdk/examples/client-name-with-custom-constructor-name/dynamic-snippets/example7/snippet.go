package example

import (
    client "github.com/examples/fern/client"
    option "github.com/examples/fern/option"
    context "context"
)

func do() () {
    client := client.New(
        option.WithBaseURL(
            "https://api.fern.com",
        ),
        option.WithToken(
            "<token>",
        ),
    )
    client.Health.Service.Check(
        context.TODO(),
        "id-2sdx82h",
    )
}
