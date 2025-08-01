package com.JavaStudent25;

public class DeluxeBurger extends Burger{
    private Topping topping4;
    private Topping topping5;

    public DeluxeBurger() {
        super("Deluxe Burger", 5.00, "Premium double-beef deluxe burger with extra toppings.", new Topping[5]);
        this.topping4 = null;
        this.topping5 = null;
    }

@Override
    public double getPrice() {
        return 5.00;
    }

        @Override
    public boolean addTopping(Topping topping) {
         if (super.addTopping(topping)) return true;
         if (topping4 == null) {
            topping4 = topping;
            return true;
        } else if (topping5 == null) {
            topping5 = topping;
            return true;
        }
         return false;
    }

@Override
    public boolean changeTopping(int toppingNum, Topping newTopping) {
        if(super.changeTopping(toppingNum, newTopping)) return true;
        if (toppingNum == 4 && topping4 != null) {
            topping4 = newTopping;
            return true;
        }
        if (toppingNum == 5 && topping5 != null) {
            topping5 = newTopping;
            return true;
        }
        return false;
    }

@Override
    public boolean removeTopping(int toppingNum) {
        if(super.removeTopping(toppingNum)) return true;
        if (toppingNum == 4 && topping4 != null) {
            topping4 = null;
            return true;
        }
        if (toppingNum == 5 && topping5 != null) {
            topping5 = null;
            return true;
        }
        return false;
    }

    @Override
    public void clearToppings() {
        super.clearToppings();
        topping4 = null;
        topping5 = null;
    }

    @Override
    public String toString() {
        return "DeluxeBurger{" +
                "topping4=" + topping4 +
                ", topping5=" + topping5 +
                "} " + super.toString();
    }
}