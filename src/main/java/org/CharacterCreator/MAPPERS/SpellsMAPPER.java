package org.CharacterCreator.MAPPERS;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.CharacterCreator.DataModel.Spells;

public class SpellsMAPPER {
    private static final ObjectMapper MAPPER = new ObjectMapper();

    public static Spells convertJSON(String JSON) {
        try {
            Spells spells = new Spells();
            JsonNode node = MAPPER.readTree(JSON);
            spells.setName((node.get("name").asText()));
            return spells;
        } catch (JsonProcessingException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }
}
