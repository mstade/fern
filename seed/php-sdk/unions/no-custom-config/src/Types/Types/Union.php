<?php

namespace Seed\Types\Types;

use Seed\Core\Json\JsonSerializableType;
use Exception;
use Seed\Core\Json\JsonDecoder;

/**
 * This is a simple union.
 */
class Union extends JsonSerializableType
{
    /**
     * @var string $type
     */
    public readonly string $type;

    /**
     * @var (
     *    Foo
     *   |Bar
     *   |mixed
     * ) $value
     */
    public readonly mixed $value;

    /**
     * @param array{
     *   type: string,
     *   value: (
     *    Foo
     *   |Bar
     *   |mixed
     * ),
     * } $values
     */
    public function __construct(
        array $values,
    ) {
        $this->type = $values['type'];
        $this->value = $values['value'];
    }

    /**
     * @param Foo $foo
     * @return Union
     */
    public static function foo(Foo $foo): Union
    {
        return new Union([
            'type' => 'foo',
            'value' => $foo,
        ]);
    }

    /**
     * @param Bar $bar
     * @return Union
     */
    public static function bar(Bar $bar): Union
    {
        return new Union([
            'type' => 'bar',
            'value' => $bar,
        ]);
    }

    /**
     * @param mixed $_unknown
     * @return Union
     */
    public static function _unknown(mixed $_unknown): Union
    {
        return new Union([
            'type' => '_unknown',
            'value' => $_unknown,
        ]);
    }

    /**
     * @return bool
     */
    public function isFoo(): bool
    {
        return $this->value instanceof Foo && $this->type === 'foo';
    }

    /**
     * @return Foo
     */
    public function asFoo(): Foo
    {
        if (!($this->value instanceof Foo && $this->type === 'foo')) {
            throw new Exception(
                "Expected foo; got " . $this->type . " with value of type " . get_debug_type($this->value),
            );
        }

        return $this->value;
    }

    /**
     * @return bool
     */
    public function isBar(): bool
    {
        return $this->value instanceof Bar && $this->type === 'bar';
    }

    /**
     * @return Bar
     */
    public function asBar(): Bar
    {
        if (!($this->value instanceof Bar && $this->type === 'bar')) {
            throw new Exception(
                "Expected bar; got " . $this->type . " with value of type " . get_debug_type($this->value),
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
            case 'foo':
                $value = $this->asFoo()->jsonSerialize();
                $result['foo'] = $value;
                break;
            case 'bar':
                $value = $this->asBar()->jsonSerialize();
                $result['bar'] = $value;
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
            case 'foo':
                if (!array_key_exists('foo', $data)) {
                    throw new Exception(
                        "JSON data is missing property 'foo'",
                    );
                }

                if (!(is_array($data['foo']))) {
                    throw new Exception(
                        "Expected property 'foo' in JSON data to be array, instead received " . get_debug_type($data['foo']),
                    );
                }
                $args['value'] = Foo::jsonDeserialize($data['foo']);
                break;
            case 'bar':
                if (!array_key_exists('bar', $data)) {
                    throw new Exception(
                        "JSON data is missing property 'bar'",
                    );
                }

                if (!(is_array($data['bar']))) {
                    throw new Exception(
                        "Expected property 'bar' in JSON data to be array, instead received " . get_debug_type($data['bar']),
                    );
                }
                $args['value'] = Bar::jsonDeserialize($data['bar']);
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
