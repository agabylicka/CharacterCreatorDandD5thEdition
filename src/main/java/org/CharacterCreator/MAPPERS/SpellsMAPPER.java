package org.CharacterCreator.MAPPERS;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.CharacterCreator.DataModel.Spells;

import java.util.ArrayList;
import java.util.List;

public class SpellsMAPPER {
    private static final ObjectMapper MAPPER = new ObjectMapper();

    public static org.CharacterCreator.DataModel.Spells convertJSON(String JSON) {
        try {
            org.CharacterCreator.DataModel.Spells spells = new org.CharacterCreator.DataModel.Spells();
            String name = "";
            JsonNode node = MAPPER.readTree(JSON);
            Spells allSpellsResult = new Spells();
            for (int i = 0; i < node.get("results").size(); i++) {
                String spell = node.get("results").get(i).get("index").asText();
                name += spell + ", ";
            }
            spells.setName(name);
            return spells;
        } catch (JsonProcessingException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    public static List<Spells> convertJSONToListOfSpells(String JSON) {
        List<Spells> results = new ArrayList<>();
        try {
            String name = "";
            JsonNode node = MAPPER.readTree(JSON);

            for (int i = 0; i < node.get("results").size(); i++) {
                Spells spells = new Spells();
                JsonNode processNode = node.get("results").get(i);
                name = processNode.get("name").asText();

                spells.setName(name);
                results.add(spells);
            }
            return results;
        } catch (JsonProcessingException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }
}
