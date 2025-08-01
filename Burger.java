package com.JavaStudent25;

public class Burger {
    public static final Burger[] AVAILABLE_BURGERS = {
            new Burger("Hamburger",1.50,"Standard small hamburger"),
            new Burger("Cheeseburger", 2.00, "Classic small cheeseburger"),
            new Burger("Double Cheeseburger",3.00,"Double cheeseburger"),
            new Burger("Chicken Burger", 3.50, "Chicken burger"),
    };

    private String name;
    private double price;
    private String description;
    private Topping[] toppingsList;
    private Topping topping1;
    private Topping topping2;
    private Topping topping3;

    public Burger() {
        this.name = "Hamburger";
        this.price = 1.50;
        this.description = "Standard small hamburger.";
        this.toppingsList = new Topping[3];
        this.topping1 = null;
        this.topping2 = null;
        this.topping3 = null;
    }

    public Burger(String name, double price, String description) {
        this.name = name;
        this.price = price;
        this.toppingsList = new Topping[3];
        this.description = description;
    }

    public Burger(String name, double price, String description, Topping[] toppingsList) {
        this.name = name;
        this.price = price;
        this.toppingsList = toppingsList;
        this.description = description;
    }

    public Burger(int index){
        if (index >= 0 && index < AVAILABLE_BURGERS.length){
            this.name= AVAILABLE_BURGERS[index].getName();
            this.price= AVAILABLE_BURGERS[index].getPrice();
            this.description= AVAILABLE_BURGERS[index].getDescription();
        }
        else {
            this.name="Nothing burger";
            this.price = 0.00;
            this.description = "An absolute nothing-burger, courtesy of invalid index input. Enjoy";
        }
        this.topping1 = null;
        this.topping2 = null;
        this.topping3 = null;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        double totalPrice = price;
        if (topping1 != null) totalPrice += topping1.getPrice();
        if (topping2 != null) totalPrice += topping2.getPrice();
        if (topping3 != null) totalPrice += topping3.getPrice();
        return totalPrice;
    }

    public String getDescription() {
        return description;
    }

    public String getToppingsDetail(StringBuilder toppings) {
        double toppingsPrice = 0;
        if (topping1 == null) {
            return "";
        } else {
          toppingsPrice = topping1.getPrice();
            if (topping2 != null) toppingsPrice += topping2.getPrice();
            if (topping3 != null) toppingsPrice += topping3.getPrice();

            return "\nToppings: " + toppings + "\nToppings Price: $" + String.format("%.2f", toppingsPrice);
        }
    }

    public boolean addTopping(Topping topping) {
        if (topping1 == null) {
            topping1 = topping;
            return true;
        } if (topping2 == null) {
            topping2 = topping;
            return true;
        } if (topping3 == null) {
            topping3 = topping;
            return true;
        }
        return false;
    }

    public boolean changeTopping(int toppingNum, Topping newTopping) {
        if (newTopping == null) return false;
        if (toppingNum == 1 && topping1 != null) {
            topping1 = newTopping;
            return true;
        }
        if (toppingNum == 2 && topping2 != null) {
            topping2 = newTopping;
            return true;
        }
        if (toppingNum == 3 && topping3 != null) {
            topping3 = newTopping;
            return true;
        }
        return false;
    }

    public boolean removeTopping(int toppingNum) {
        if (toppingNum == 1 && topping1 != null) {
            topping1 = null;
            return true;
        }
        if (toppingNum == 2 && topping2 != null) {
            topping2 = null;
            return true;
        }
        if (toppingNum == 3 && topping3 != null) {
            topping3 = null;
            return true;
        }
        return false;
    }

    public void clearToppings() {
        topping1 = null;
        topping2 = null;
        topping3 = null;
    }

    @Override
    public String toString() {
        return "Burger{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", topping1=" + topping1 +
                ", topping2=" + topping2 +
                ", topping3=" + topping3 +
                '}';
    }
}
