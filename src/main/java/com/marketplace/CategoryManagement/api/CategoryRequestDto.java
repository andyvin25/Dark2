package com.marketplace.CategoryManagement.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.aot.hint.annotation.RegisterReflectionForBinding;

@RegisterReflectionForBinding
public record CategoryRequestDto(@JsonProperty("category_name") String categoryName) {
}
