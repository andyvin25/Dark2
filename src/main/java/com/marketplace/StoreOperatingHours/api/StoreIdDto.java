package com.marketplace.StoreOperatingHours.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.aot.hint.annotation.RegisterReflectionForBinding;

@RegisterReflectionForBinding
public record StoreIdDto(@JsonProperty("store_id") String storeId) {
}