package org.sgodden;

import org.codehaus.jackson.map.SerializationConfig;

public class ObjectMapper extends org.codehaus.jackson.map.ObjectMapper {
    public ObjectMapper() {
        super();
        this.enable(SerializationConfig.Feature.INDENT_OUTPUT);
    }
}
