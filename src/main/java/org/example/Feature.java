package org.example;


public class Feature {
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    //build JSON
    @Override
    public String toString() {
        return "{\"name\": "+name+"}";
    }

    public String getName() {
        return this.name;
    }
}

