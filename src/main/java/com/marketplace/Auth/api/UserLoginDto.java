package com.marketplace.Auth.api;

import org.springframework.aot.hint.annotation.RegisterReflectionForBinding;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@RegisterReflectionForBinding
public record UserLoginDto(
        @NotBlank(message = "Invalid email: empty null")
        @Email(message = "Invalid Email")
        String email,

        @NotBlank(message = "password can't be empty")
//        @Size(min = 8, max = 20, message = "the password character should be between 8 and 20")
        String password,

        @Nullable
        String token
        ) {
}
