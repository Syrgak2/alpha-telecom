package com.example.Alpha_telekom.dto.user;

import com.example.Alpha_telekom.dto.task.TasksDto;

import java.util.List;

public class UserDto {
    private Long id;
    private String username;
    private String email;

    public UserDto(String username, String email, Long id) {
        this.id = id;
        this.username = username;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }


    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
