package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


public class Feature {
    String name;
    private static final ObjectMapper MAPPER = new ObjectMapper();

    public static Feature convertJSON(String postJSON) {
        Feature feature = new Feature();
        try {
            JsonNode node = MAPPER.readTree(postJSON);
            feature.setName((node.get("name").asText()));
        } catch (JsonProcessingException e) {
            //throw new RuntimeException(e);
            System.err.println(e.getMessage());
        }
        return feature;
    }

    public void setName(String name) {
        this.name = name;
    }

    //build JSON
    @Override
    public String toString() {
        return "{\"name\": "+name+"}";
    }

    public String getName() {
        return name;
    }
}

