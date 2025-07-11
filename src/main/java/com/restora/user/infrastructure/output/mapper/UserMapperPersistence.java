package com.restora.user.infrastructure.output.mapper;

import com.restora.user.domain.model.User;
import com.restora.user.infrastructure.output.entity.UserEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapperPersistence {

    User toDomainUser(UserEntity entity);

    List<User> toDomainUserList(List<UserEntity> entityList);

    UserEntity toEntityUser(User user);

    List<UserEntity> toEntityUserList(List<User> userList);
}
