package com.JavaStudent25;

public class Drink {
    public static final Drink[] AVAILABLE_DRINKS = {
        new Drink("Small soda", 0.50, "Small soda"),
        new Drink("Medium soda", 0.80, "Medium soda"),
        new Drink("Large soda", 1.00, "Large soda"),
    };

    private String name;
    private double price;
    private String description;

    public Drink(){
        this.name = "Small soda";
        this.price = 0.50;
        this.description = "Small soda.";
    }

    public Drink(int index){
        if (index >= 0 && index < AVAILABLE_DRINKS.length) {
            this.name = AVAILABLE_DRINKS[index].getName();
            this.price = AVAILABLE_DRINKS[index].getPrice();
            this.description = AVAILABLE_DRINKS[index].getDescription();
        }
        else {
            this.name = "No drink";
            this.price = 0.00;
            this.description = "No drink - invalid index detected.";
        }
    }

    public Drink(String name, double price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }


    @Override
    public String toString() {
        return "Drink{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                '}';
    }
}
