package com.example.Alpha_telekom.mapper;

import com.example.Alpha_telekom.dto.task.TasksDto;
import com.example.Alpha_telekom.dto.user.UserDto;
import com.example.Alpha_telekom.dto.user.UsersDto;
import com.example.Alpha_telekom.entity.User;

import java.util.List;

public class UserMapper {

    public UserDto userToUserDto(User user) {
        return new UserDto(user.getUsername(), user.getEmail(), user.getId());
    }

    public User userDtoToUser(UserDto userDto) {
        return new User(userDto.getUsername(), userDto.getEmail(), userDto.getId());
    }

    public UsersDto mapToTasksDto(List<User> users) {
        return new UsersDto(users.size(), users.stream().map(this::userToUserDto).toList());
    }
}
