package com.ivanfranchin.moviesapp.ldap.user;

import org.springframework.data.ldap.repository.LdapRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends LdapRepository<User> {

    Optional<User> findByUsername(String username);
}