package com.ivanfranchin.moviesapp.user;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.ivanfranchin.moviesapp.serializer.LdapNameSerializer;
import org.springframework.ldap.odm.annotations.Attribute;
import org.springframework.ldap.odm.annotations.Entry;
import org.springframework.ldap.odm.annotations.Id;

import javax.naming.ldap.LdapName;

@Entry(objectClasses = {"inetOrgPerson", "posixAccount"})
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

    @Attribute(name = "gidnumber")
    private String role;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}