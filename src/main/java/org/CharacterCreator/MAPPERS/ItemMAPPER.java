package org.CharacterCreator.MAPPERS;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.CharacterCreator.DataModel.Item;

public class ItemMAPPER {
    private static final ObjectMapper MAPPER = new ObjectMapper();

    public static Item convertJSON(String JSON) {
        try {
            Item item = new Item();
            JsonNode node = MAPPER.readTree(JSON);
            item.setName((node.get("name").asText()));
            item.setQuantity(node.get("quantity").asInt());
            return item;
        } catch (JsonProcessingException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }
}
