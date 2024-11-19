package com.example.Alpha_telekom.service.impl;

import com.example.Alpha_telekom.dto.user.UserCreateOrUpdateDto;
import com.example.Alpha_telekom.dto.user.UserDto;
import com.example.Alpha_telekom.entity.MyUser;
import com.example.Alpha_telekom.exceptions.NotFoundException;
import com.example.Alpha_telekom.mapper.UserMapper;
import com.example.Alpha_telekom.repository.UserRepository;
import com.example.Alpha_telekom.service.AuthService;
import com.example.Alpha_telekom.userdetail.CustomUserDetails;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final CustomUserDetails customUserDetails;
    private final PasswordEncoder encoder;
    private UserMapper userMapper = new UserMapper();

    public AuthServiceImpl(UserRepository userRepository, CustomUserDetails customUserDetails, PasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.customUserDetails = customUserDetails;
        this.encoder = encoder;
    }


    @Override
    public UserDto createUser(UserCreateOrUpdateDto userCreateOrUpdateDto) {
        if (userCreateOrUpdateDto == null) {
            throw new NotFoundException("User is null");
        }
        String password = encoder.encode(userCreateOrUpdateDto.getPassword());
        MyUser myUser = new MyUser(userCreateOrUpdateDto.getUsername(), userCreateOrUpdateDto.getEmail(), password);
        MyUser savedMyUser = userRepository.save(myUser);

        return userMapper.userToUserDto(savedMyUser);
    }

    @Override
    public boolean login(String username, String password) {
        UserDetails userDetails = customUserDetails.loadUserByUsername(username);
        return encoder.matches(password, userDetails.getPassword());
    }
}
