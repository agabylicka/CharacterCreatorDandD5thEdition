package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class Clazz {

    public List<String> getAvailableSkills() {
        return this.availableSkills;
    }

    public void setAvailableSkills(List<String> availableSkills) {
        this.availableSkills = availableSkills;
    }

    List<String> availableSkills;

    public List<String> getProficiencies() {
        return this.proficiencies;
    }

    public void setProficiencies(List<String> proficiencies) {
        this.proficiencies = proficiencies;
    }

    List<String> proficiencies;

    public List<Item> getStartingEquipment() {
        return this.startingEquipment;
    }

    public void setStartingEquipment(List<Item> startingEquipment) {
        this.startingEquipment = startingEquipment;
    }

    List<Item> startingEquipment;
}
