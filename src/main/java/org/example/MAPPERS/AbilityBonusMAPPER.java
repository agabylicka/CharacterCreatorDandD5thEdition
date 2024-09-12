package org.example.MAPPERS;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.StandardClasses.AbilityBonus;

public class AbilityBonusMAPPER {
    private static final ObjectMapper MAPPER = new ObjectMapper();

    public static AbilityBonus convertJSON(String JSON) {
        try {
            AbilityBonus abilityBonus = new AbilityBonus();
            JsonNode node = MAPPER.readTree(JSON);
            abilityBonus.setName((node.get("name").asText()));
            abilityBonus.setValue((node.get("value").asInt()));
            return abilityBonus;
        } catch (JsonProcessingException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }
}
