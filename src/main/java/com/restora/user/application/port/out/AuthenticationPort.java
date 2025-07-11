package com.restora.user.application.port.out;

public interface AuthenticationPort {
    void authenticate(String email, String password);
}
