package org.example;

import java.util.List;

public class Race {

    int bonuses;
    int speed;
    String size;

    List<String> languages;
    int proficiencies;

    public List<String> getLanguages() {
        return this.languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    public int getProficiencies() {
        return this.proficiencies;
    }

    public void setProficiencies(int proficiencies) {
        this.proficiencies = proficiencies;
    }

    public int getBonuses() {
        return this.bonuses;
    }

    public String getSize() {
        return this.size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setBonuses(int bonuses) {
        this.bonuses = bonuses;
    }

    public int getSpeed() {
        return this.speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
