package com.restora.user.infrastructure.input.controller;

import com.restora.user.application.port.in.LoginUseCase;
import com.restora.user.application.port.in.RegisterUseCase;
import com.restora.user.infrastructure.input.dto.request.RegisterUserRequestDto;
import com.restora.user.infrastructure.input.dto.response.UserResponseDto;
import com.restora.user.infrastructure.input.mapper.UserMapperController;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final RegisterUseCase registerUseCase;
    private  final LoginUseCase loginUseCase;
    private final UserMapperController mapper;


    @PostMapping("/register")
    public ResponseEntity<UserResponseDto> registerUser(@Valid @RequestBody RegisterUserRequestDto request) {
        var command = mapper.toRegisterUserCommand(request);
        var user = registerUseCase.registerUser(command);
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toUserResponseDTO(user));

    }


}
