package com.example.Alpha_telekom.dto.user;

import lombok.Data;

@Data
public class LoginDTO {
    String username;
    String password;

    public LoginDTO(String username, String password) {

    }
}
