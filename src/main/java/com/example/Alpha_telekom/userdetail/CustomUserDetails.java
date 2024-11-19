package com.example.Alpha_telekom.userdetail;

import com.example.Alpha_telekom.entity.User;
import com.example.Alpha_telekom.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetails implements UserDetailsService {

    private UserService userService;

    public CustomUserDetails(UserService userService) {
        this.userService = userService;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.getUserByLogin(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new MyUserPrincipal(user);
    }
}
