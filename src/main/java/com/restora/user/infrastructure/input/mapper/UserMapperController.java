package com.restora.user.infrastructure.input.mapper;

import com.restora.user.application.dto.command.LoginUserCommand;
import com.restora.user.application.dto.command.RegisterUserCommand;
import com.restora.user.domain.model.User;
import com.restora.user.infrastructure.input.dto.request.LoginUserRequestDto;
import com.restora.user.infrastructure.input.dto.request.RegisterUserRequestDto;
import com.restora.user.infrastructure.input.dto.response.UserResponseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapperController {

    // Mapea DTO REST a Command aplicación
    RegisterUserCommand toRegisterUserCommand(RegisterUserRequestDto dto);

    LoginUserCommand toLoginUserCommand(LoginUserRequestDto dto);

    // Mapea entidad dominio a DTO de respuesta REST
    UserResponseDto toUserResponseDTO(User user);

}
