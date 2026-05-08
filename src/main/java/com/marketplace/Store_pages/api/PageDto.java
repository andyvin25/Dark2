package com.marketplace.Store_pages.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.aot.hint.annotation.RegisterReflectionForBinding;

@RegisterReflectionForBinding
public record PageDto(@JsonProperty("name") String name) {}
