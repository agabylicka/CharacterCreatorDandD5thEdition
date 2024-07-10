package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class AbilityBonus {

    private String name;
    private int value;

    private static final ObjectMapper MAPPER = new ObjectMapper();

    public static AbilityBonus convertJSON(String postJSON) {
        try {
            AbilityBonus abilityBonus = new AbilityBonus();
            JsonNode node = MAPPER.readTree(postJSON);
            abilityBonus.setName((node.get("name").asText()));
            abilityBonus.setValue((node.get("value").asInt()));
            return abilityBonus;
        } catch (JsonProcessingException e) {
            //throw new RuntimeException(e);
            System.err.println(e.getMessage());
        }
        return null;
    }


    public String getName() {
        return this.name;
    }

    public int getValue() {
        return this.value;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
