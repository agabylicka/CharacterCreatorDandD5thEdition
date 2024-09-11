package org.example.MAPPERS;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.HTTP.AllSpells;
import org.example.HTTP.AllSpellsResult;

import java.util.ArrayList;
import java.util.List;

public class AllSpellsMAPPER {
    private static final ObjectMapper MAPPER = new ObjectMapper();

    public static AllSpells convertJSON(String postJSON) {
        try {
            AllSpells response = new AllSpells();
            JsonNode node = MAPPER.readTree(postJSON);
            response.setCount((node.get("count").asInt()));

            List<AllSpellsResult> allSpellsResult = new ArrayList<>();
            for (int i = 0; i < node.get("results").size(); i++) {
                String index = node.get("results").get(i).get("index").asText();
                String name = node.get("results").get(i).get("name").asText();
                Integer level = node.get("results").get(i).get("level").asInt();
                String url = node.get("results").get(i).get("url").asText();

                AllSpellsResult allSpellsResult1 = new AllSpellsResult();
                allSpellsResult1.setName(name);
                allSpellsResult1.setIndex(index);
                allSpellsResult1.setUrl(url);
                allSpellsResult1.setLevel(level);

                allSpellsResult.add(allSpellsResult1);
            }
            response.setResults(allSpellsResult);
            return response;
        } catch (JsonProcessingException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }
}
