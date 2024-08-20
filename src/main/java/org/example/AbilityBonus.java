package org.example;

public class AbilityBonus {

    private String name;
    private int value;

    public String getName() {
        return this.name;
    }

    public int getValue() {
        return this.value;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "{" +
                "\"name\": \"" + name + "\", " +
                "\"value\": " + value +
                '}';
    }
}
