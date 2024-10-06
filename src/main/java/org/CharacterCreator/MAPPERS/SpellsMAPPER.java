package org.CharacterCreator.MAPPERS;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.CharacterCreator.DataModel.Spells;
import org.CharacterCreator.HTTP.AllSpellsResult;

import java.util.ArrayList;
import java.util.List;

public class SpellsMAPPER {
    private static final ObjectMapper MAPPER = new ObjectMapper();

    public static Spells convertJSON(String JSON) {
        try {
            Spells spells = new Spells();
            String name = "";
            JsonNode node = MAPPER.readTree(JSON);
            AllSpellsResult allSpellsResult = new AllSpellsResult();
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

    public static List<AllSpellsResult> convertJSONToListOfSpells(String JSON) {
        List<AllSpellsResult> results = new ArrayList<>();
        try {
            String name = "";
            String index = "";
            String url = "";
            JsonNode node = MAPPER.readTree(JSON);

            for (int i = 0; i < node.get("results").size(); i++) {
                AllSpellsResult allSpellsResult = new AllSpellsResult();
                JsonNode processNode = node.get("results").get(i);
                index = processNode.get("index").asText();
                name = processNode.get("name").asText();
                url = processNode.get("url").asText();

                allSpellsResult.setName(name);
                allSpellsResult.setUrl(url);
                allSpellsResult.setIndex(index);
                results.add(allSpellsResult);
            }
            return results;
        } catch (JsonProcessingException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }
}
