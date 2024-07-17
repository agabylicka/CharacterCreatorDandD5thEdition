package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


public class Feature {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    //build JSON
    @Override
    public String toString() {
        return "{\"name\": "+name+"}";
    }

    public String getName() {
        return this.name;
    }
}

