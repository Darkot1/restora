package com.restora.user.application.service;

import com.restora.user.application.dto.command.LoginUserCommand;
import com.restora.user.application.dto.command.RegisterUserCommand;
import com.restora.user.application.port.in.LoginUseCase;
import com.restora.user.application.port.in.RegisterUseCase;
import com.restora.user.application.port.out.*;
import com.restora.user.domain.enums.UserRole;
import com.restora.user.domain.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthService implements LoginUseCase, RegisterUseCase {

    private final LoadUserByEmailPort loadUserByEmailPort;
    private final SaveUserPort saveUserPort;

    private final TokenGenerationPort tokenGenerationPort;
    private final PasswordEncoderPort passwordEncoderPort;
    private final AuthenticationPort authenticationPort;


    @Override
    public User loginUser(LoginUserCommand command) {

        return loadUserByEmailPort.loadUserByEmail(command.email())
                .orElseThrow(() -> new RuntimeException("User not found"));

    }

    @Override
    public User registerUser(RegisterUserCommand command) {
        loadUserByEmailPort.loadUserByEmail(command.email())
                .ifPresent(user -> {
                    throw new RuntimeException("User already exists with email: " + command.email());
                });

        // Rol user por default
        UserRole role = UserRole.USER;

        // Encriptar la contraseña con el PasswordEncoderPort que este se implementa en la infraestructura
        String encodedPassword = passwordEncoderPort.encodePassword(command.password());

        User user = User.builder()
                .firstName(command.firstName())
                .lastName(command.lastName())
                .email(command.email())
                .phoneNumber(command.phoneNumber())
                .password(encodedPassword)
                .role(role)
                .status(command.status())
                .build();

        return saveUserPort.save(user);
    }
}
