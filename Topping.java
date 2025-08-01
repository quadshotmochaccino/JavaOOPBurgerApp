package com.JavaStudent25;

public class Topping {
    public static final Topping[] AVAILABLE_TOPPINGS = {
            new Topping("Cheese slice", 0.20, "Cheesy cheese slice"),
            new Topping("Lettuce", 0.10, "Fresh green lettuce"),
            new Topping("Pickles", 0.10, "Sliced dill pickles"),
            new Topping("Tomato", 0.10, "Ripe tomato slices"),
            new Topping("Onions", 0.10, "Caramelized onions"),
            new Topping("Spinach", 0.10, "Baby spinach leaves"),
    };

    private String name;
    private double price;
    private String description;

    public Topping(String name, double price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public Topping(int index){
        if (index >= 0 && index < AVAILABLE_TOPPINGS.length) {
            this.name = AVAILABLE_TOPPINGS[index].getName();
            this.price = AVAILABLE_TOPPINGS[index].getPrice();
            this.description = AVAILABLE_TOPPINGS[index].getDescription();
        }
        else {
            this.name = "no toppings";
            this.price = 0.00;
            this.description = "No topping - invalid index detected.";
        }
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
        return "Topping{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                '}';
    }
}