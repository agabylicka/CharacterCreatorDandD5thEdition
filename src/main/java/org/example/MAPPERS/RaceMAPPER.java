package org.example.MAPPERS;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.StandardClasses.AbilityBonus;
import org.example.StandardClasses.Race;

import java.util.ArrayList;
import java.util.List;

public class RaceMAPPER {
    private static final ObjectMapper MAPPER = new ObjectMapper();

    public static Race convertJSON(String postJSON) {
        try {
            Race race = new Race();
            JsonNode node = MAPPER.readTree(postJSON);
            race.setSize((node.get("size").asText()));
            race.setSpeed((node.get("speed").asInt()));
            List<String> languages = new ArrayList<>();
            for (int i = 0; i < node.get("languages").size(); i++) {
                String language = node.get("languages").get(i).asText();
                languages.add(language);
            }
            race.setLanguages(languages);

            List<String> proficiencies = new ArrayList<>();
            for (int i = 0; i < node.get("starting_proficiencies").size(); i++) {
                String proficience = node.get("starting_proficiencies").get(i).asText();
                proficiencies.add(proficience);
            }
            race.setProficiencies(proficiencies);

            List<AbilityBonus> bonuses = new ArrayList<>();
            for (int i = 0; i < node.get("ability_bonuses").size(); i++) {
                String tmpBonus = node.get("ability_bonuses").get(i).get("ability_score").get("name").asText();
                int bonusValue = node.get("ability_bonuses").get(i).get("bonus").asInt();
                AbilityBonus abilityBonus1 = new AbilityBonus();
                abilityBonus1.setName(tmpBonus);
                abilityBonus1.setValue(bonusValue);
                bonuses.add(abilityBonus1);
            }
            race.setBonuses(bonuses);
            return race;
        } catch (JsonProcessingException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }
}
