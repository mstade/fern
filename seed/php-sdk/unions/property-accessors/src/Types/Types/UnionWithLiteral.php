<?php

namespace Seed\Types\Types;

use Seed\Core\Json\JsonSerializableType;
use Seed\Core\Json\JsonProperty;
use Exception;
use Seed\Core\Json\JsonDecoder;

class UnionWithLiteral extends JsonSerializableType
{
    /**
     * @var string $base
     */
    #[JsonProperty('base')]
    private string $base;

    /**
     * @var string $type
     */
    private readonly string $type;

    /**
     * @var (
     *    string
     *   |mixed
     * ) $value
     */
    private readonly mixed $value;

    /**
     * @param array{
     *   base: string,
     *   type: string,
     *   value: (
     *    string
     *   |mixed
     * ),
     * } $values
     */
    private function __construct(
        array $values,
    ) {
        $this->base = $values['base'];
        $this->type = $values['type'];
        $this->value = $values['value'];
    }

    /**
     * @return string
     */
    public function getBase(): string
    {
        return $this->base;
    }

    /**
     * @param string $value
     */
    public function setBase(string $value): self
    {
        $this->base = $value;
        return $this;
    }

    /**
     * @return string
     */
    public function getType(): string
    {
        return $this->type;
    }

    /**
     * @return (
     *    string
     *   |mixed
     * )
     */
    public function getValue(): mixed
    {
        return $this->value;
    }

    /**
     * @param string $base
     * @param string $fern
     * @return UnionWithLiteral
     */
    public static function fern(string $base, string $fern): UnionWithLiteral
    {
        return new UnionWithLiteral([
            'base' => $base,
            'type' => 'fern',
            'value' => $fern,
        ]);
    }

    /**
     * @return bool
     */
    public function isFern(): bool
    {
        return is_string($this->value) && $this->type === 'fern';
    }

    /**
     * @return string
     */
    public function asFern(): string
    {
        if (!(is_string($this->value) && $this->type === 'fern')) {
            throw new Exception(
                "Expected fern; got " . $this->type . " with value of type " . get_debug_type($this->value),
            );
        }

        return $this->value;
    }

    /**
     * @return string
     */
    public function __toString(): string
    {
        return $this->toJson();
    }

    /**
     * @return array<mixed>
     */
    public function jsonSerialize(): array
    {
        $result = [];
        $result['type'] = $this->type;

        $base = parent::jsonSerialize();
        $result = array_merge($base, $result);

        switch ($this->type) {
            case 'fern':
                $value = $this->value;
                $result['fern'] = $value;
                break;
            case '_unknown':
            default:
                if (is_null($this->value)) {
                    break;
                }
                if ($this->value instanceof JsonSerializableType) {
                    $value = $this->value->jsonSerialize();
                    $result = array_merge($value, $result);
                } elseif (is_array($this->value)) {
                    $result = array_merge($this->value, $result);
                }
        }

        return $result;
    }

    /**
     * @param string $json
     */
    public static function fromJson(string $json): static
    {
        $decodedJson = JsonDecoder::decode($json);
        if (!is_array($decodedJson)) {
            throw new Exception("Unexpected non-array decoded type: " . gettype($decodedJson));
        }
        return self::jsonDeserialize($decodedJson);
    }

    /**
     * @param array<string, mixed> $data
     */
    public static function jsonDeserialize(array $data): static
    {
        $args = [];
        if (!array_key_exists('base', $data)) {
            throw new Exception(
                "JSON data is missing property 'base'",
            );
        }
        if (!(is_string($data['base']))) {
            throw new Exception(
                "Expected property 'base' in JSON data to be string, instead received " . get_debug_type($data['base']),
            );
        }
        $args['base'] = $data['base'];

        if (!array_key_exists('type', $data)) {
            throw new Exception(
                "JSON data is missing property 'type'",
            );
        }
        $type = $data['type'];
        if (!(is_string($type))) {
            throw new Exception(
                "Expected property 'type' in JSON data to be string, instead received " . get_debug_type($data['type']),
            );
        }

        $args['type'] = $type;
        switch ($type) {
            case 'fern':
                if (!array_key_exists('fern', $data)) {
                    throw new Exception(
                        "JSON data is missing property 'fern'",
                    );
                }

                $args['value'] = $data['fern'];
                break;
            case '_unknown':
            default:
                $args['type'] = '_unknown';
                $args['value'] = $data;
        }

        // @phpstan-ignore-next-line
        return new static($args);
    }
}
