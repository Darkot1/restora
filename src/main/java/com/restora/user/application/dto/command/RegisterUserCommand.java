package com.restora.user.application.dto.command;

import com.restora.user.domain.enums.UserRole;
import com.restora.user.domain.enums.UserStatus;

public record RegisterUserCommand(
    String firstName,
    String lastName,
    String email,
    Long phoneNumber,
    String password,
    UserRole role,
    UserStatus status
) {
}
