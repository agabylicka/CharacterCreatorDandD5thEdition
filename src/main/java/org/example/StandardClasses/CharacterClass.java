package org.example.StandardClasses;

import java.util.List;

public class CharacterClass {
    private List<String> availableSkills;
    private List<String> proficiencies;
    private List<Item> startingEquipment;

    public List<String> getAvailableSkills() {
        return this.availableSkills;
    }

    public void setAvailableSkills(List<String> availableSkills) {
        this.availableSkills = availableSkills;
    }

    public List<String> getProficiencies() {
        return this.proficiencies;
    }

    public void setProficiencies(List<String> proficiencies) {
        this.proficiencies = proficiencies;
    }

    public List<Item> getStartingEquipment() {
        return this.startingEquipment;
    }

    public void setStartingEquipment(List<Item> startingEquipment) {
        this.startingEquipment = startingEquipment;
    }
}
