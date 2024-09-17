package org.CharacterCreator.MAPPERS;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.CharacterCreator.DataModel.CharacterClass;
import org.CharacterCreator.DataModel.Item;

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

            List<String> availableSkills = new ArrayList<>();
            for (int i = 0; i < node.get("available_skills").size(); i++) {
                String skill = node.get("available_skills").get(i).asText();
                availableSkills.add(skill);
            }
            characterClass.setAvailableSkills(availableSkills);

            List<Item> startingEquipment = new ArrayList<>();
            for (int i = 0; i < node.get("starting_equipment").size(); i++) {
                String tmpEquipment = node.get("starting_equipment").get(i).get("name").asText();
                int quantityValue = node.get("starting_equipment").get(i).get("quantity").asInt();
                Item item = new Item();
                item.setName(tmpEquipment);
                item.setQuantity(quantityValue);
                startingEquipment.add(item);
            }
            characterClass.setStartingEquipment(startingEquipment);

            return characterClass;
        } catch (JsonProcessingException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }
}

