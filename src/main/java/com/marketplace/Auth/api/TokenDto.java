package com.marketplace.Auth.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.aot.hint.annotation.RegisterReflectionForBinding;

@RegisterReflectionForBinding
public record TokenDto(
        @JsonProperty("user_token") String userToken,
        @JsonProperty("refresh_token") String refreshToken) {
}
