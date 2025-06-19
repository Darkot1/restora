package com.restora.user.application.port.out;

public interface TokenGenerationPort {
    String generateToken(String username);
}
