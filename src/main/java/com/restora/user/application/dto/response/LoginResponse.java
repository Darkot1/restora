package com.restora.user.application.dto.response;

import lombok.Builder;

@Builder
public record LoginResponse(
        String token
) {
}
