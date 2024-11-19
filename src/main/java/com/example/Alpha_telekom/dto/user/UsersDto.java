package com.example.Alpha_telekom.dto.user;

import java.util.List;

public class UsersDto {
    private int count;
    private List<UserDto> users; // List<User>

    public UsersDto(int count, List<UserDto> users) {
        this.count = count;
        this.users = users;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<UserDto> getUsers() {
        return users;
    }

    public void setUsers(List<UserDto> users) {
        this.users = users;
    }
}
