package pl.coderslab.charity.dto;


import lombok.Data;

import java.util.Set;

@Data
public class UserCredentialsDto {
    private final String email;
    private final String password;
    private final Set<String> roles;
}
