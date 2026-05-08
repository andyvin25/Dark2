package com.marketplace.StoreManagement.api;


import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.aot.hint.annotation.RegisterReflectionForBinding;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@RegisterReflectionForBinding
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record StoreRequestDTO(
    @NotBlank(message = "Invalid store name: Empty/Null")
    @Size(min = 3, max = 30, message = "Store name must be 3-20 characters")
    @JsonProperty("store_name")
    String storeName,
    @Nullable
    @Size(max = 300, message = "Store name max characters must be 300")
    String description
) {
}