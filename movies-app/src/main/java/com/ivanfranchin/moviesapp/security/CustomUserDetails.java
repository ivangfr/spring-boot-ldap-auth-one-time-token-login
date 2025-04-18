package com.ivanfranchin.moviesapp.security;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Data
public class CustomUserDetails implements UserDetails {

    private String username;
    private String password;
    private String name;
    private Collection<? extends GrantedAuthority> authorities;
}