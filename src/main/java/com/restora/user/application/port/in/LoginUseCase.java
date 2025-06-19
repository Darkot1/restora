package com.restora.user.application.port.in;

import com.restora.user.application.dto.command.LoginUserCommand;
import com.restora.user.domain.model.User;

public interface LoginUseCase {
    User loginUser(LoginUserCommand command);
}
