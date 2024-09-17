package org.CharacterCreator.MAPPERS;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.CharacterCreator.HTTP.AllRacesResponse;
import org.CharacterCreator.HTTP.AllRacesResult;

import java.util.ArrayList;
import java.util.List;

public class AllRacesMAPPER {
    private static final ObjectMapper MAPPER = new ObjectMapper();

    public static AllRacesResponse convertJSON(String postJSON) {
        try {
            AllRacesResponse response = new AllRacesResponse();
            JsonNode node = MAPPER.readTree(postJSON);
            response.setCount((node.get("count").asInt()));

            List<AllRacesResult> allRacesResults = new ArrayList<>();
            for (int i = 0; i < node.get("results").size(); i++) {
                String index = node.get("results").get(i).get("index").asText();
                String name = node.get("results").get(i).get("name").asText();
                String url = node.get("results").get(i).get("url").asText();

                AllRacesResult allRacesResult = new AllRacesResult();
                allRacesResult.setName(name);
                allRacesResult.setIndex(index);
                allRacesResult.setUrl(url);

                allRacesResults.add(allRacesResult);
            }
            response.setResults(allRacesResults);
            return response;
        } catch (JsonProcessingException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }
}
