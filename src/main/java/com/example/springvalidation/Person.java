package com.example.springvalidation;

import jakarta.validation.constraints.*;

public record Person(
        @NotBlank
        String firstname,
        @NotNull
        String lastname,
        @Min(0)
        @Max(120)
        int age,
        @Pattern(regexp = "\\w+\\d+")
        String address,
        @Email
        String email
) {
}
