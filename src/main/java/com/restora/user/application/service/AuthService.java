package com.restora.user.application.service;

import com.restora.config.exception.BusinessException;
import com.restora.config.exception.ResourceNotFoundException;
import com.restora.user.application.dto.command.LoginUserCommand;
import com.restora.user.application.dto.command.RegisterUserCommand;
import com.restora.user.application.dto.response.LoginResponse;
import com.restora.user.application.port.in.LoginUseCase;
import com.restora.user.application.port.in.RegisterUseCase;
import com.restora.user.application.port.out.*;
import com.restora.user.domain.enums.UserRole;
import com.restora.user.domain.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AuthService implements LoginUseCase, RegisterUseCase {

    private final LoadUserByEmailPort loadUserByEmailPort;
    private final SaveUserPort saveUserPort;

    private final TokenGenerationPort tokenGenerationPort;
    private final PasswordEncoderPort passwordEncoderPort;
    private final AuthenticationPort authenticationPort;


    @Override
    public LoginResponse loginUser(LoginUserCommand command) {

        authenticationPort.authenticate(command.email(), command.password());
        User user = loadUserByEmailPort.loadUserByEmail(command.email())
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        String token = tokenGenerationPort.generateToken(user);

        return LoginResponse.builder()
                .token(token)
                .build();
    }

    @Override
    public User registerUser(RegisterUserCommand command) {
        loadUserByEmailPort.loadUserByEmail(command.email())
                .ifPresent(user -> {
                    throw new BusinessException(
                            "Ya existe un usuario con el email: " + command.email(),
                            HttpStatus.CONFLICT,
                            "USER_ALREADY_EXISTS"
                    );
                });

        // Rol user por default 
        UserRole role = command.role() != null ? command.role() : UserRole.USER;

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
