package com.JavaStudent25;

public class Meal {

    private String name;
    private static final double COMBO_DISCOUNT = 0.90;
    private Burger burger;
    private Drink drink;
    private SideItem sideItem;

    public Meal() {
        this.name = "Small hamburger combo";
        this.burger = new Burger();
        this.drink = new Drink();
        this.sideItem = new SideItem();
    }

    public Meal(Burger burger, Drink drink, SideItem sideItem){
        this.name = burger.getName();
        this.burger = burger;
        this.drink = drink;
        this.sideItem = sideItem;
    }

    public String defaultMeal() {
        return burger.getName() + ", " + sideItem.getName() + ", with a " + drink.getName() + ".";
    }

    @Override
    public String toString() {
        return "Meal{" +
                "name='" + name + '\'' +
                ", price=" + getPrice() +
                ", burger=" + burger +
                ", drink=" + drink +
                ", sideItem=" + sideItem +
                '}';
    }

    public String getItemisedMealList(StringBuilder toppingsList) {

        return "\nORDER SUMMARY: \n" +
                burger.getName() + ": $" + String.format("%.2f", burger.getPrice()) +
                burger.getToppingsDetail(toppingsList) + "\n" +
                sideItem.getName() + ": $" + String.format("%.2f", sideItem.getPrice()) + "\n" +
                drink.getName() + ": $" + String.format("%.2f", drink.getPrice())  +
                "\nTotal: $" + String.format("%.2f", (burger.getPrice() + sideItem.getPrice()+ drink.getPrice()));
    }

    public void setBurger(Burger selectedBurger) {
        burger = selectedBurger;
        name = burger.getName();
    }

    public void setSideItem(SideItem selectedSide) {
        sideItem = selectedSide;
        name = sideItem.getName();
    }

    public void setDrink(Drink selectedDrink) {
        drink = selectedDrink;
        name = drink.getName();
    }

    public Burger getBurger() {
        return burger;
    }

    public Drink getDrink() {
        return drink;
    }

    public SideItem getSideItem() {
        return sideItem;
    }

    public double getPrice(){
            if (burger instanceof DeluxeBurger) {
                return burger.getPrice();
            }
            else return (burger.getPrice() + sideItem.getPrice() + drink.getPrice()) * COMBO_DISCOUNT;
    }

}
