package com.restora.user.infrastructure.adapter;

import com.restora.user.application.port.out.LoadUserByEmailPort;
import com.restora.user.application.port.out.SaveUserPort;
import com.restora.user.domain.model.User;
import com.restora.user.infrastructure.output.db.SpringDataUserRepository;
import com.restora.user.infrastructure.output.mapper.UserMapperPersistence;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class JpaUserRepositoryAdapter implements SaveUserPort, LoadUserByEmailPort {

    private final SpringDataUserRepository userRepository;
    private final UserMapperPersistence userMapper;

    @Override
    public Optional<User> loadUserByEmail(String email) {
        return userRepository.findByEmail(email)
                .map(userMapper::toDomainUser);
    }

    @Override
    public User save(User user) {
        // Convertir User dominio a UserEntity para persistencia
        var userEntity = userMapper.toEntityUser(user);

        // Guardar UserEntity en la base de datos
        var savedEntity = userRepository.save(userEntity);

        // Convertir UserEntity guardado de vuelta a User dominio
        return userMapper.toDomainUser(savedEntity);
    }
}
