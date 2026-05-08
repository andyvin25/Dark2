package com.marketplace.StoreOperatingHours.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.aot.hint.annotation.RegisterReflectionForBinding;

import java.time.LocalTime;

@RegisterReflectionForBinding
public record StoreOperatingHoursDto(
        @JsonProperty("day_name") String dayName,
        @JsonProperty("store_operating_time_start") LocalTime storeOperatingTimeStart,
        @JsonProperty("store_operating_time_end") LocalTime storeOperatingTimeEnd) {
}
