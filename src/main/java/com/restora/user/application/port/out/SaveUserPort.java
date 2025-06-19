package com.restora.user.application.port.out;

import com.restora.user.domain.model.User;

public interface SaveUserPort {
    User save(User user);
}
