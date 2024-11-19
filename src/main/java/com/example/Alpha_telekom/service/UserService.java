package com.example.Alpha_telekom.service;

import com.example.Alpha_telekom.dto.user.UserCreateOrUpdateDto;
import com.example.Alpha_telekom.dto.user.UserDto;
import com.example.Alpha_telekom.entity.MyUser;

public interface UserService {


    UserDto getUser(Long id);

    MyUser getUserByLogin(String username);

    UserDto updateUser(Long id, UserCreateOrUpdateDto userCreateOrUpdateDto);

    void deleteUser(Long id);

}
