package org.CharacterCreator.DataModel;


public class Feature {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return "{\"name\": "+name+"}";
    }
}

