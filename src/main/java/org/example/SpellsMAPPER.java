package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SpellsMAPPER {
    private static final ObjectMapper MAPPER = new ObjectMapper();

    public static Spells convertJSON(String postJSON) {
        try {
            Spells spells = new Spells();
            JsonNode node = MAPPER.readTree(postJSON);
            spells.setName((node.get("name").asText()));
            return spells;
        } catch (JsonProcessingException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }
}
