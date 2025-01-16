/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.seed.nullable;

import com.seed.nullable.core.ClientOptions;
import com.seed.nullable.core.Suppliers;
import com.seed.nullable.resources.nullable.NullableClient;
import java.util.function.Supplier;

public class SeedNullableClient {
    protected final ClientOptions clientOptions;

    protected final Supplier<NullableClient> nullableClient;

    public SeedNullableClient(ClientOptions clientOptions) {
        this.clientOptions = clientOptions;
        this.nullableClient = Suppliers.memoize(() -> new NullableClient(clientOptions));
    }

    public NullableClient nullable() {
        return this.nullableClient.get();
    }

    public static SeedNullableClientBuilder builder() {
        return new SeedNullableClientBuilder();
    }
}
