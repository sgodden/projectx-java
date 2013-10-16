package org.sgodden;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.joda.JodaModule;

public class ObjectMapper extends com.fasterxml.jackson.databind.ObjectMapper {
    public ObjectMapper() {
        super();
        registerModule(new JodaModule());
        this.enable(SerializationFeature.INDENT_OUTPUT);
    }
}
