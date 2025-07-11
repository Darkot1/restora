package com.restora.user.application.port.out;

public interface PasswordEncoderPort {
    String encodePassword(String password);
    boolean matches(String rawPassword, String encodedPassword);
}
