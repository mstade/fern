<?php

namespace Seed\FolderB\Common\Types;

use Seed\Core\Json\JsonSerializableType;
use Seed\Core\Json\JsonProperty;

class Foo extends JsonSerializableType
{
    /**
     * @var ?\Seed\FolderC\Common\Types\Foo $foo
     */
    #[JsonProperty('foo')]
    public ?\Seed\FolderC\Common\Types\Foo $foo;

    /**
     * @param array{
     *   foo?: ?\Seed\FolderC\Common\Types\Foo,
     * } $values
     */
    public function __construct(
        array $values = [],
    ) {
        $this->foo = $values['foo'] ?? null;
    }

    /**
     * @return string
     */
    public function __toString(): string
    {
        return $this->toJson();
    }
}
