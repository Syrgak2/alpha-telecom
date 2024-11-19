package com.example.Alpha_telekom.mapper;

import com.example.Alpha_telekom.dto.user.UserDto;
import com.example.Alpha_telekom.dto.user.UsersDto;
import com.example.Alpha_telekom.entity.MyUser;

import java.util.List;

public class UserMapper {

    public UserDto userToUserDto(MyUser myUser) {
        return new UserDto(myUser.getUsername(), myUser.getEmail(), myUser.getId());
    }

    public MyUser userDtoToUser(UserDto userDto) {
        return new MyUser( userDto.getId(), userDto.getUsername(), userDto.getEmail());
    }

    public UsersDto mapToTasksDto(List<MyUser> myUsers) {
        return new UsersDto(myUsers.size(), myUsers.stream().map(this::userToUserDto).toList());
    }
}
