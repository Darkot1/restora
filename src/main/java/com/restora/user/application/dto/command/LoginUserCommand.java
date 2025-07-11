package com.restora.user.application.dto.command;

public record LoginUserCommand(
        String email,
        String password
) {
}
