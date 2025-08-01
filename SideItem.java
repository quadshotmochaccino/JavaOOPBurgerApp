package com.JavaStudent25;

public class SideItem {
    public static final SideItem[] AVAILABLE_SIDE_ITEMS = {
            new SideItem("Small fries", 0.50, "Small fries"),
            new SideItem("Medium fries", 0.80, "Medium fries"),
            new SideItem("Large fries", 1.00, "Large fries"),
            new SideItem("Garden salad",1.00,"Garden salad")
    };

    private String name;
    private double price;
    private String description;

    public SideItem(){
        this.name = "Small fries";
        this.price = 0.50;
        this.description = "Small fries";
    }

    public SideItem(int index){
        if (index >= 0 && index < AVAILABLE_SIDE_ITEMS.length) {
            this.name = AVAILABLE_SIDE_ITEMS[index].getName();
            this.price = AVAILABLE_SIDE_ITEMS[index].getPrice();
            this.description = AVAILABLE_SIDE_ITEMS[index].getDescription();
        }
        else {
            this.name = "No side item";
            this.price = 0.00;
            this.description = "No side item - invalid index detected.";
        }
    }

    public SideItem(String name, double price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "SideItem{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                '}';
    }
}
