package org.example;

public class Item {

    private String name;
    private int quantity;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "{" +
                "\"name\": \"" + name + "\", " +
                "\"quantity\": " + quantity +
                '}';
    }
}
