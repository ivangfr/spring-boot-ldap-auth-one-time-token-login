package com.ivanfranchin.moviesapp.ldap.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import javax.naming.ldap.LdapName;
import java.io.IOException;

public class LdapNameSerializer extends JsonSerializer<LdapName> {

    @Override
    public void serialize(LdapName value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeString(value.toString());
    }
}