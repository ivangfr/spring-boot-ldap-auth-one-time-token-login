package com.ivanfranchin.moviesapp.ldap.user;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.ivanfranchin.moviesapp.ldap.serializer.LdapNameSerializer;
import lombok.Data;
import org.springframework.ldap.odm.annotations.Attribute;
import org.springframework.ldap.odm.annotations.Entry;
import org.springframework.ldap.odm.annotations.Id;

import javax.naming.ldap.LdapName;

@Data
@Entry(base = "ou=users", objectClasses = {"inetOrgPerson", "posixAccount"})
public class User {

    @Id
    @JsonSerialize(using = LdapNameSerializer.class)
    private LdapName id;

    @Attribute(name = "uid")
    private String username;

    @Attribute(name = "userpassword")
    private String password;

    @Attribute(name = "cn")
    private String name;

    @Attribute(name = "uidnumber")
    private String uidNumber;

    @Attribute(name = "gidnumber")
    private String gidNumber;
}