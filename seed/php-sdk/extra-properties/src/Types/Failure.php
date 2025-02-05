<?php

namespace Seed\Types;

use Seed\Core\Json\JsonSerializableType;
use Seed\Core\Json\JsonProperty;

class Failure extends JsonSerializableType
{
    /**
     * @var string $status
     */
    #[JsonProperty('status')]
    public string $status;

    /**
     * @param array{
     *   status: string,
     * } $values
     */
    public function __construct(
        array $values,
    ) {
        $this->status = $values['status'];
    }

    /**
     * @return string
     */
    public function __toString(): string
    {
        return $this->toJson();
    }
}
