package com.example.Alpha_telekom.dto.user;

import lombok.Data;

import java.util.List;

@Data
public class UserDto {
    private Long id;
    private String username;
    private String email;

    public UserDto(String username, String email, Long id) {
        this.id = id;
        this.username = username;
        this.email = email;
    }

}
