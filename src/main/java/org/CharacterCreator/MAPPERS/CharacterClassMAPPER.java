package org.CharacterCreator.MAPPERS;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.CharacterCreator.DataModel.CharacterClass;

import java.util.ArrayList;
import java.util.List;

public class CharacterClassMAPPER {
    private static final ObjectMapper MAPPER = new ObjectMapper();

    public static CharacterClass convertJSON(String JSON) {
        try {
            CharacterClass characterClass = new CharacterClass();

            JsonNode node = MAPPER.readTree(JSON);

            List<String> proficiencies = new ArrayList<>();
            for (int i = 0; i < node.get("proficiencies").size(); i++) {
                String proficience = node.get("proficiencies").get(i).asText();
                proficiencies.add(proficience);
            }
            characterClass.setProficiencies(proficiencies);

            return characterClass;
        } catch (JsonProcessingException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }
}

