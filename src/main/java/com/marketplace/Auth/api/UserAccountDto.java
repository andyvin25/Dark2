package com.marketplace.Auth.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.aot.hint.annotation.RegisterReflectionForBinding;

import com.marketplace.Auth.domain.Role;

import java.util.Set;

@RegisterReflectionForBinding
public record UserAccountDto(
        @JsonProperty("email") String email,
        @JsonProperty("roles") Set<Role.RoleEnum> roles) {
}

