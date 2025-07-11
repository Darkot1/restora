package com.restora.user.infrastructure.adapter;

import com.restora.config.jwt.JwtService;
import com.restora.user.application.port.out.TokenGenerationPort;
import com.restora.user.domain.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class JwtTokenAdapter implements TokenGenerationPort {

    private final JwtService jwtService;
    private final UserDetailsService userDetailsService;

    @Override
    public String generateToken(User user) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(user.getEmail());
        return jwtService.generateToken(userDetails);
    }
}
