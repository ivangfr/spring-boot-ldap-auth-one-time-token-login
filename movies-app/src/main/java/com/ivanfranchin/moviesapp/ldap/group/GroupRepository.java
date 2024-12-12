package com.ivanfranchin.moviesapp.ldap.group;

import org.springframework.data.ldap.repository.LdapRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends LdapRepository<Group> {

    Group findByGidNumber(String gidNumber);
}