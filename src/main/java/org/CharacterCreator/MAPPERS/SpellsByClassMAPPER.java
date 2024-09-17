package org.CharacterCreator.MAPPERS;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.CharacterCreator.HTTP.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SpellsByClassMAPPER {
    private static final ObjectMapper MAPPER = new ObjectMapper();

    public static SpellsByClass convertJSON(String postJSON) {
        try {
            SpellsByClass response = new SpellsByClass();
            JsonNode node = MAPPER.readTree(postJSON);
            response.setLevel((node.get("level").asText()));

            List<Spellcasting_ability> spellsByClasses = new ArrayList<>();
            //Map<String, Spellcasting_ability> spellsByClasses = new HashMap<>();
            for (int i = 0; i < node.get("spellcasting_ability").size(); i++) {
            //for (String key : spellsByClasses.keySet()) {
                //Spellcasting_ability value = node.get("spellcasting_ability").get(0).as;
                String index = node.get("spellcasting_ability").get(i).get("index").asText();
                String name = node.get("spellcasting_ability").get(i).get("name").asText();
                String url = node.get("spellcasting_ability").get(i).get("url").asText();

                Spellcasting_ability allSpellsResult = new Spellcasting_ability();
                allSpellsResult.setIndex(index);
                allSpellsResult.setName(name);
                allSpellsResult.setUrl(url);
                spellsByClasses.add(allSpellsResult);
            }
            response.setSpellcasting_ability(spellsByClasses);

            List<Info> infos  = new ArrayList<>();
            for (int i = 0; i < node.get("info").size(); i++) {
                String name = node.get("info").get(i).get("name").asText();
                String desc = node.get("info").get(i).get("desc").asText();

                Info info = new Info();
                info.setDesc(desc);
                info.setName(name);
                infos.add(info);
            }
            response.setInfo(infos);
            return response;
        } catch (JsonProcessingException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }
}
