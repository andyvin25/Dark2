package com.marketplace.CategoryManagement.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.aot.hint.annotation.RegisterReflectionForBinding;

@RegisterReflectionForBinding
public record CategoryDto(
        @JsonProperty("id") String id,
        @JsonProperty("name") String name) {
}
