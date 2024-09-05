package vn.com.ltdt.finwise.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RegisterRequest(
        String fullName,
        @NotNull @NotBlank
        String email,
        @NotNull @NotBlank
        String password,
        @NotNull @NotBlank
        String phoneNumber,
                String dateOfBirth
) {
}
