<?php

namespace Example;

use Seed\SeedClient;

$client = new SeedClient(
    options: [
        'baseUrl' => 'https://api.fern.com',
    ],
);
$client->folder->service->unknownRequest(
    [
        'key' => "value",
    ],
);
