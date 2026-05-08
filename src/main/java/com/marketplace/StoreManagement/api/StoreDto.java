package com.marketplace.StoreManagement.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.aot.hint.annotation.RegisterReflectionForBinding;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@RegisterReflectionForBinding
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record StoreDto(
        @JsonProperty("store_id")
        String storeId,
        @JsonProperty("store_name")
        String storeName,
        @JsonProperty("store_description")
        String storeDescription) {
}
