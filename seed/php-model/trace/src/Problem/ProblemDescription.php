<?php

namespace Seed\Problem;

use Seed\Core\Json\JsonSerializableType;
use Seed\Core\Json\JsonProperty;
use Seed\Core\Types\ArrayType;

class ProblemDescription extends JsonSerializableType
{
    /**
     * @var array<mixed> $boards
     */
    #[JsonProperty('boards'), ArrayType(['mixed'])]
    public array $boards;

    /**
     * @param array{
     *   boards: array<mixed>,
     * } $values
     */
    public function __construct(
        array $values,
    ) {
        $this->boards = $values['boards'];
    }

    /**
     * @return string
     */
    public function __toString(): string
    {
        return $this->toJson();
    }
}
