package com.restora.user.application.port.out;

import com.restora.user.domain.model.User;

import java.util.Optional;

public interface LoadUserByEmailPort {
    Optional<User> loadUserByEmail(String email);
}
