package com.example.Alpha_telekom.service.impl;

import com.example.Alpha_telekom.dto.task.CreateOrUpdateTaskDto;
import com.example.Alpha_telekom.dto.user.UserCreateOrUpdateDto;
import com.example.Alpha_telekom.dto.user.UserDto;
import com.example.Alpha_telekom.entity.User;
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
    public UserDto createUser(UserCreateOrUpdateDto userCreateOrUpdateDto) {
        if (userCreateOrUpdateDto == null) {
            throw new NotFoundException("User is null");
        }
        User user = new User(userCreateOrUpdateDto.getUsername(), userCreateOrUpdateDto.getEmail(), userCreateOrUpdateDto.getPassword());
        User savedUser = userRepository.save(user);

        return userMapper.userToUserDto(savedUser);
    }

    @Override
    public UserDto getUser(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new NotFoundException("User not found"));
        return userMapper.userToUserDto(user);
    }

    @Override
    public UserDto updateUser(Long id, UserCreateOrUpdateDto userCreateOrUpdateDto) {
        User user = userRepository.findById(id).orElseThrow(() -> new NotFoundException("User not found"));
        user.setUsername(userCreateOrUpdateDto.getUsername());
        user.setEmail(userCreateOrUpdateDto.getEmail());
        user.setPassword(userCreateOrUpdateDto.getPassword());
        User savedUser = userRepository.save(user);
        return userMapper.userToUserDto(savedUser);
    }

    @Override
    public void deleteUser(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new NotFoundException("User not found"));
        userRepository.delete(user);
    }
}
