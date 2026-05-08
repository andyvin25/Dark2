package com.marketplace.UserAccountManagement.api;

import com.marketplace.UserAccountManagement.domain.Address;
import org.springframework.aot.hint.annotation.RegisterReflectionForBinding;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@RegisterReflectionForBinding
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record UserAddressDto(
        @JsonProperty("address_id") String addressId,
        @JsonProperty("recipient_name") String recipientName,
        @JsonProperty("recipient_number") String recipientNumber,
        @JsonProperty("address_label") Address.AddressLabelEnum addressLabel,
        @JsonProperty("city_and_subsidiary") String cityAndSubsidiary,
        @JsonProperty("complete_address") String completeAddress,
        @JsonProperty("is_picked") Boolean isPicked) {
}
