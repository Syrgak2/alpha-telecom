package com.example.Alpha_telekom.service;

import com.example.Alpha_telekom.dto.user.UserCreateOrUpdateDto;
import com.example.Alpha_telekom.dto.user.UserDto;

public interface AuthService {

    UserDto createUser(UserCreateOrUpdateDto userCreateOrUpdateDto);
    boolean login(String username, String password);

}
