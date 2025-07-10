package com.restora.user.application.port.in;

import com.restora.user.application.dto.command.LoginUserCommand;
import com.restora.user.application.dto.response.LoginResponse;
import com.restora.user.domain.model.User;

public interface LoginUseCase {
    LoginResponse loginUser(LoginUserCommand command);
}
