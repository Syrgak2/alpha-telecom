package com.example.Alpha_telekom.service;

import com.example.Alpha_telekom.dto.task.CreateOrUpdateTaskDto;
import com.example.Alpha_telekom.dto.user.UserCreateOrUpdateDto;
import com.example.Alpha_telekom.dto.user.UserDto;
import com.example.Alpha_telekom.entity.User;

public interface UserService {

    UserDto createUser(UserCreateOrUpdateDto userCreateOrUpdateDto);

    UserDto getUser(Long id);

    User getUserByLogin(String username);

    UserDto updateUser(Long id, UserCreateOrUpdateDto userCreateOrUpdateDto);

    void deleteUser(Long id);

    boolean login(String username, String password);
}
