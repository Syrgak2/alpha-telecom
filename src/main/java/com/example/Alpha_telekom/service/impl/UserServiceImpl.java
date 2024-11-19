package com.example.Alpha_telekom.service.impl;

import com.example.Alpha_telekom.dto.user.UserCreateOrUpdateDto;
import com.example.Alpha_telekom.dto.user.UserDto;
import com.example.Alpha_telekom.entity.MyUser;
import com.example.Alpha_telekom.exceptions.NotFoundException;
import com.example.Alpha_telekom.mapper.UserMapper;
import com.example.Alpha_telekom.repository.UserRepository;
import com.example.Alpha_telekom.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;


    private UserMapper userMapper = new UserMapper();

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDto getUser(Long id) {
        MyUser myUser = userRepository.findById(id).orElseThrow(() -> new NotFoundException("User not found"));
        return userMapper.userToUserDto(myUser);
    }

    @Override
    public MyUser getUserByLogin(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public UserDto updateUser(Long id, UserCreateOrUpdateDto userCreateOrUpdateDto) {
        MyUser myUser = userRepository.findById(id).orElseThrow(() -> new NotFoundException("User not found"));
        myUser.setUsername(userCreateOrUpdateDto.getUsername());
        myUser.setEmail(userCreateOrUpdateDto.getEmail());
        myUser.setPassword(userCreateOrUpdateDto.getPassword());
        MyUser savedMyUser = userRepository.save(myUser);
        return userMapper.userToUserDto(savedMyUser);
    }

    @Override
    public void deleteUser(Long id) {
        MyUser myUser = userRepository.findById(id).orElseThrow(() -> new NotFoundException("User not found"));
        userRepository.delete(myUser);
    }


}
