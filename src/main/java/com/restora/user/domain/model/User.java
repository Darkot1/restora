package com.restora.user.domain.model;

import com.restora.user.domain.enums.UserRole;
import com.restora.user.domain.enums.UserStatus;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private UUID id;
    private String firstName;
    private String lastName;
    private String email;
    private Long phoneNumber;
    private String password;
    private UserRole role;
    private UserStatus status;

}
