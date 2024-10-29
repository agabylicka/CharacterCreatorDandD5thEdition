package org.CharacterCreator.MAPPERS;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.CharacterCreator.DataModel.Feature;

public class FeatureMAPPER {
    private static final ObjectMapper MAPPER = new ObjectMapper();

    public static Feature convertJSON(String JSON) {
        try {
            Feature feature = new Feature();
            JsonNode node = MAPPER.readTree(JSON);
            feature.setName((node.get("name").asText()));
            return feature;
        } catch (JsonProcessingException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }
}
