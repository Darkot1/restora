package com.restora.user.infrastructure.input.dto.request;

public record LoginUserRequestDto(
        String email,
        String password
) {
}
