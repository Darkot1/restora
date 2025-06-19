package com.restora.user.infrastructure.input.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record RegisterUserRequestDto(
        @NotBlank(message = "El nombre es obligatorio")
        String firstName,

        @NotBlank(message = "El apellido es obligatorio")
        String lastName,

        @Email(message = "El email debe ser válido")
        @NotBlank(message = "El email es obligatorio")
        String email,

        @NotNull(message = "El número de teléfono es obligatorio")
        Long phoneNumber,

        @Size(min = 6, message = "La contraseña debe tener al menos 6 caracteres")
        String password,

        @NotBlank(message = "El rol es obligatorio")
        String role,

        @NotBlank(message = "El estado es obligatorio")
        String status
) {
}
