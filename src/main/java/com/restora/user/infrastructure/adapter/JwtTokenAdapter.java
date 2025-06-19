package com.restora.user.infrastructure.adapter;

import com.restora.config.jwt.JwtService;
import com.restora.user.application.port.out.TokenGenerationPort;
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
    public String generateToken(String username) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        return  jwtService.generateToken(userDetails);
    }
}
