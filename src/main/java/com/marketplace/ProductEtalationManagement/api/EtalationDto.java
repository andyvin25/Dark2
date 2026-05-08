package com.marketplace.ProductEtalationManagement.api;

import org.springframework.aot.hint.annotation.RegisterReflectionForBinding;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@RegisterReflectionForBinding
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record EtalationDto(
        @JsonProperty("etalation_id") String etalationId,
        @JsonProperty("etalation_name") String etalationName) {
}
