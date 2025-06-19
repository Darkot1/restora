package com.restora.user.application.port.in;

import com.restora.user.application.dto.command.RegisterUserCommand;
import com.restora.user.domain.model.User;

public interface RegisterUseCase {
    User registerUser(RegisterUserCommand command);
}
