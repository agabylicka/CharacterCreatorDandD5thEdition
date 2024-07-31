package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ItemMAPPER {
    private static final ObjectMapper MAPPER = new ObjectMapper();

    public static Item convertJSON(String postJSON) {
        try {
            Item item = new Item();
            JsonNode node = MAPPER.readTree(postJSON);
            item.setName((node.get("name").asText()));
            item.setQuantity(node.get("quantity").asInt());
            return item;
        } catch (JsonProcessingException e) {
            //throw new RuntimeException(e);
            System.err.println(e.getMessage());
        }
        return null;
    }
}
