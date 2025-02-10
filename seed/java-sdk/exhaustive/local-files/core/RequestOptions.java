/**
 * This file was auto-generated by Fern from our API Definition.
 */

package com.fern.sdk.core;

import java.lang.Integer;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

public final class RequestOptions {
  private final String token;

  private final Optional<Integer> timeout;

  private final TimeUnit timeoutTimeUnit;

  private final Map<String, String> headers;

  private final Map<String, Supplier<String>> headerSuppliers;

  private RequestOptions(String token, Optional<Integer> timeout, TimeUnit timeoutTimeUnit,
      Map<String, String> headers, Map<String, Supplier<String>> headerSuppliers) {
    this.token = token;
    this.timeout = timeout;
    this.timeoutTimeUnit = timeoutTimeUnit;
    this.headers = headers;
    this.headerSuppliers = headerSuppliers;
  }

  public Optional<Integer> getTimeout() {
    return timeout;
  }

  public TimeUnit getTimeoutTimeUnit() {
    return timeoutTimeUnit;
  }

  public Map<String, String> getHeaders() {
    Map<String, String> headers = new HashMap<>();
    if (this.token != null) {
      headers.put("Authorization", "Bearer " + this.token);
    }
    headers.putAll(this.headers);
    this.headerSuppliers.forEach((key, supplier) ->  {
      headers.put(key, supplier.get());
    } );
    return headers;
  }

  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    private String token = null;

    private Optional<Integer> timeout = Optional.empty();

    private TimeUnit timeoutTimeUnit = TimeUnit.SECONDS;

    private final Map<String, String> headers = new HashMap<>();

    private final Map<String, Supplier<String>> headerSuppliers = new HashMap<>();

    public Builder token(String token) {
      this.token = token;
      return this;
    }

    public Builder timeout(Integer timeout) {
      this.timeout = Optional.of(timeout);
      return this;
    }

    public Builder timeout(Integer timeout, TimeUnit timeoutTimeUnit) {
      this.timeout = Optional.of(timeout);
      this.timeoutTimeUnit = timeoutTimeUnit;
      return this;
    }

    public Builder addHeader(String key, String value) {
      this.headers.put(key, value);
      return this;
    }

    public Builder addHeader(String key, Supplier<String> value) {
      this.headerSuppliers.put(key, value);
      return this;
    }

    public RequestOptions build() {
      return new RequestOptions(token, timeout, timeoutTimeUnit, headers, headerSuppliers);
    }
  }
}
