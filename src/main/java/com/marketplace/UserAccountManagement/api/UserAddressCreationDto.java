package com.marketplace.UserAccountManagement.api;

import org.springframework.aot.hint.annotation.RegisterReflectionForBinding;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import com.marketplace.UserAccountManagement.domain.Address;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@RegisterReflectionForBinding
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record UserAddressCreationDto(
        @JsonProperty("recipient_name")
        @NotBlank(message = "recipientName can&apos;t be empty")
        @Size(max= 30, message = "Max character is 30")
        String recipientName,
        @JsonProperty("recipient_number")
        @NotBlank(message = "recipientNumber can&apos;t be empty")
        @Size(max = 15, message = "the complete recipient number range is max is 15 characters")
        String recipientNumber,
        @JsonProperty("address_label")
        @NotNull(message = "addressLabel can&apos;t be null")
        Address.AddressLabelEnum addressLabel,
        @JsonProperty("city_and_subsidiary")
        @NotBlank(message = "city And Subsidiary can&apos;t be empty")
        @Size(max = 100, message = "max Charachter is 100")
        String cityAndSubsidiary,
        @JsonProperty("complete_address")
        @NotBlank(message = "completeAddress can&apos;t be empty")
        @Size(max = 100, message = "max Charachter is 100")
        String completeAddress) {
}
