package org.CharacterCreator.HTTP;

import java.util.List;

public class SpellsByClass {
    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public List<Spellcasting_ability> getSpellcasting_ability() {
        return spellcasting_ability;
    }

    public void setSpellcasting_ability(List<Spellcasting_ability> spellcasting_ability) {
        this.spellcasting_ability = spellcasting_ability;
    }

    public List<Info> getInfo() {
        return info;
    }

    public void setInfo(List<Info> info) {
        this.info = info;
    }

    private String level;
    private List<Spellcasting_ability> spellcasting_ability;
    private List<Info> info;


}
