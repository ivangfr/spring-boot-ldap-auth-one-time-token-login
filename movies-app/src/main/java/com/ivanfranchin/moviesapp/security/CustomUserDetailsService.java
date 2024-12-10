package com.ivanfranchin.moviesapp.security;

import com.ivanfranchin.moviesapp.user.User;
import com.ivanfranchin.moviesapp.user.UserService;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserService userService;

    public CustomUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public CustomUserDetails loadUserByUsername(String username) {
        User user = userService.validateAndGetByUsername(username);
        List<SimpleGrantedAuthority> authorities = Collections.singletonList(new SimpleGrantedAuthority(user.getRole()));
        return mapUserToCustomUserDetails(user, authorities);
    }

    private CustomUserDetails mapUserToCustomUserDetails(User user, List<SimpleGrantedAuthority> authorities) {
        return new CustomUserDetails(
                user.getUsername(),
                fromAsciiArraytoString(user.getPassword()),
                user.getName(),
                authorities
        );
    }

    private String fromAsciiArraytoString(String asciiArray) {
        String[] asciiValues = asciiArray.split(",");

        StringBuilder sb = new StringBuilder();
        for (String value : asciiValues) {
            int asciiValue = Integer.parseInt(value.trim());
            char character = (char) asciiValue;
            sb.append(character);
        }
        return sb.toString();
    }
}