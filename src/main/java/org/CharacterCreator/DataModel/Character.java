package org.CharacterCreator.DataModel;

import java.util.List;

public class Character {
    private String name;
    private String race;
    private String backstory;
    private List<Feature> features;
    private String characterClass;
    private List<Spells> spells;
    private List<String> languages;
    private List<String> proficiencies;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRace() {
        return this.race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getBackstory() {
        return this.backstory;
    }

    public void setBackstory(String backstory) {
        this.backstory = backstory;
    }

    public List<Feature> getFeatures() {
        return this.features;
    }

    public void setFeatures(List<Feature> features) {
        this.features = features;
    }

    public String getCharacterClass() {
        return this.characterClass;
    }

    public void setCharacterClass(String characterClass) {
        this.characterClass = characterClass;
    }

    public List<Spells> getSpells() {
        return this.spells;
    }

    public void setSpells(List<Spells> spells) {
        this.spells = spells;
    }

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
}
