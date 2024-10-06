package org.CharacterCreator.DataModel;

import java.util.List;

public class Race {

    private List<AbilityBonus> bonuses;
    private int speed;
    private String size;

    private List<String> languages;
    private List<String> proficiencies;

    public List<String> getLanguages() {
        return this.languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    public List<String> getProficiencies() {
        return this.proficiencies;
    }

    public void setProficiencies(List<String> proficiencies) {
        this.proficiencies = proficiencies;
    }

    public List<AbilityBonus> getBonuses() {
        return this.bonuses;
    }

    public String getSize() {
        return this.size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setBonuses(List<AbilityBonus> bonuses) {
        this.bonuses = bonuses;
    }

    public int getSpeed() {
        return this.speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
