package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

public class ClazzMAPPER {
    private static final ObjectMapper MAPPER = new ObjectMapper();

    public static Clazz convertJSON(String postJSON) {
        try {
            Clazz clazz = new Clazz();

            JsonNode node = MAPPER.readTree(postJSON);

            List<String> proficiencies = new ArrayList<>();
            for (int i = 0; i < node.get("proficiencies").size(); i++) {
                String proficience = node.get("proficiencies").get(i).asText();
                proficiencies.add(proficience);
            }
            clazz.setProficiencies(proficiencies);

            List<String> availableSkills = new ArrayList<>();
            for (int i = 0; i < node.get("available_skills").size(); i++) {
                String skill = node.get("available_skills").get(i).asText();
                availableSkills.add(skill);
            }
            clazz.setAvailableSkills(availableSkills);

            List<Item> startingEquipment = new ArrayList<>();
            for (int i = 0; i < node.get("starting_equipment").size(); i++) {
                Item equipment;
                String tmpEquipment = node.get("starting_equipment").get(i).get("equipment").get("name").asText();
                int quantityValue = node.get("starting_equipment").get(i).get("quantity").asInt();
                Item item = new Item();
                item.setName(tmpEquipment);
                item.setQuantity(quantityValue);
                startingEquipment.add(item);
            }
            clazz.setStartingEquipment(startingEquipment);

            return clazz;
        } catch (JsonProcessingException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }
}

