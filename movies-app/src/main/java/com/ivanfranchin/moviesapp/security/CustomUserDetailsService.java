package com.ivanfranchin.moviesapp.security;

import com.ivanfranchin.moviesapp.ldap.group.Group;
import com.ivanfranchin.moviesapp.ldap.group.GroupRepository;
import com.ivanfranchin.moviesapp.ldap.user.User;
import com.ivanfranchin.moviesapp.ldap.user.UserRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;
    private final GroupRepository groupRepository;

    public CustomUserDetailsService(UserRepository userRepository, GroupRepository groupRepository) {
        this.userRepository = userRepository;
        this.groupRepository = groupRepository;
    }

    @Override
    public CustomUserDetails loadUserByUsername(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User with username %s not found".formatted(username)));

        Group group = groupRepository.findByGidNumber(user.getGidNumber());

        List<SimpleGrantedAuthority> authorities = Collections.singletonList(
                new SimpleGrantedAuthority(group.getName().toUpperCase()));

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