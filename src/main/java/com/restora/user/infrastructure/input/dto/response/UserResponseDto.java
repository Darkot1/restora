package com.restora.user.infrastructure.input.dto.response;

public record UserResponseDto(
        String firstName,
        String lastName,
        String email,
        String password,
        Long phoneNumber,
        String role,
        String status
) {
}
