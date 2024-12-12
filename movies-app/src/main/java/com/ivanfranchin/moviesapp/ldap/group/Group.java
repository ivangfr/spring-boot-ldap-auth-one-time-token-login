package com.ivanfranchin.moviesapp.ldap.group;

import org.springframework.ldap.odm.annotations.Attribute;
import org.springframework.ldap.odm.annotations.Entry;
import org.springframework.ldap.odm.annotations.Id;

import javax.naming.Name;

@Entry(base = "ou=groups", objectClasses = {"posixGroup", "top"})
public class Group {

    @Id
    private Name id;

    @Attribute(name = "gidnumber")
    private String gidNumber;

    @Attribute(name = "cn")
    private String name;

    public String getGidNumber() {
        return gidNumber;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", gidNumber='" + gidNumber + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}