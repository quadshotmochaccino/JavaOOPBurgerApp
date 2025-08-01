package com.JavaStudent25;
import java.util.Scanner;

public class MenuSelector {
    public static void startMenu() {
        boolean orderComplete = false;
        Scanner output = new Scanner(System.in);
        while (!orderComplete) {
            Meal meal = new Meal();
            boolean isDefaultMeal = false;
            boolean isDeluxe = false;
            System.out.println("Welcome to Bill's burger joint!");
            System.out.println("Orders come in the form of 'Meals' - a burger, side, & a drink.");
            System.out.println("****BILL'S BURGER MENU****\n");
            System.out.println("1. Quick Meal - Small Hamburger Combo $2.25");
            System.out.println("2. Deluxe Burger Combo");
            System.out.println("3. Create-Your-Own-Combo ");
            System.out.println("4. Exit");
            System.out.println();
            int numSelector = inputNumValidator(output, 1,4,"Please choose from the options above: ");
            Burger selectedBurger;
            SideItem selectedSide = null;
            Drink selectedDrink = null;
            StringBuilder toppingsString = new StringBuilder();
            if (numSelector == 1) {
                isDefaultMeal = true;
                selectedBurger = meal.getBurger();
                selectedSide = meal.getSideItem();
                selectedDrink = meal.getDrink();
            }
            else if (numSelector == 2) {
                isDeluxe = true;
                System.out.println("Option 2, Deluxe Burger Combo selected.");
                System.out.println("Toppings, sides & drinks are all free with a Deluxe Burger Combo!");
                selectedBurger = new DeluxeBurger();
                meal.setBurger(selectedBurger);
                toppingsString = addBurgerToppings(output, selectedBurger, isDeluxe);
            }
            else if (numSelector == 3) {
                System.out.println("Option 3 Selected - Create-Your-Own-Combo!\n****************");
                selectedBurger = selectBurger(output);
                meal.setBurger(selectedBurger);
                toppingsString = addBurgerToppings(output, selectedBurger, isDeluxe);
            }
            else {
                System.out.println("Thank you for visiting. Have a great day!");
                return;
            }
            if (!isDefaultMeal) {
                selectedSide = selectSide(output, isDeluxe);
                meal.setSideItem(selectedSide);
                selectedDrink = selectDrink(output, isDeluxe);
                meal.setDrink(selectedDrink);
            } else {
                System.out.printf("You ordered the " + meal.defaultMeal());
            }
            boolean isOrderFinished = false;
            while (!isOrderFinished) {
                if(!isDefaultMeal) {
                    System.out.printf("You ordered the %s with %s, %s, and a %s.", selectedBurger.getName(), toppingsString.toString().toLowerCase(), selectedSide.getName().toLowerCase(), selectedDrink.getName().toLowerCase());
                }
                if(!isDeluxe){
                    System.out.println(meal.getItemisedMealList(toppingsString));
                    System.out.println("A 10% discount is automatically applied for Combo meals.");
                }
                System.out.printf("\nThe Grand Total for your order will be $%.2f.\n", meal.getPrice());
                System.out.println("Are you happy with this Selection? (Y/N)");
                String yesNo = inputStringValidator(output);

                if (yesNo.equalsIgnoreCase("Y")) {
                    System.out.printf("You paid $%.2f. ", calculatePrice(meal));
                    orderComplete = true;
                    break;
                } else {
                    System.out.println("What would you like to update?");
                    System.out.println("1. Change Burger selection");
                    System.out.println("2. Change toppings selection");
                    System.out.println("3. Change Side Item selection");
                    System.out.println("4. Change Drink selection");
                    System.out.println("5. Clear entire order - start again");
                    System.out.println("6. Go Back");
                    int numSelector8 = inputNumValidator(output,1,6,"Select an option: ");
                    switch (numSelector8) {
                        case 1 -> {
                            selectedBurger = selectBurger(output);
                            meal.setBurger(selectedBurger);
                            if(isDeluxe){
                                isDeluxe = false;
                                System.out.println("Note: only three toppings allowed on normal burger menu.");
                                toppingsString = addBurgerToppings(output, selectedBurger, isDeluxe);
                            }
                        }
                        case 2 -> toppingsString = addBurgerToppings(output, selectedBurger, isDeluxe);
                        case 3 -> {
                            selectedSide = selectSide(output, isDeluxe);
                            meal.setSideItem(selectedSide);
                        }
                        case 4 -> {
                            selectedDrink = selectDrink(output, isDeluxe);
                            meal.setDrink(selectedDrink);
                        }
                        case 5 -> {
                            System.out.println("Please confirm: clear entire order and return to start menu? (Y/N)");
                            String resetMeal = inputStringValidator(output);
                            if (resetMeal.equalsIgnoreCase("Y")) {
                                meal = null;
                                isOrderFinished = true;
                                System.out.println("Returning to welcome menu...\n**************************");
                            }
                            else System.out.println("No selections where changed.");
                        }
                        case 6 -> System.out.println("No selections where changed.");
                    }
                }
             }
        }
        System.out.println("Thank you for visiting Bill's Burgers. Enjoy your meal!");
        output.close();
    }

    public static void main(String[] args) {
        startMenu();
    }

    public static int inputNumValidator(Scanner output, int min, int max, String message) {
        while (true){
            System.out.println(message);
            try {
                int number = Integer.parseInt(output.nextLine());
                if (number >= min && number <= max) {
                    return number;
                } else {
                    System.out.println("Please enter a number between " + min + " and " + max + ":");
                }
            }
            catch(NumberFormatException e){
                System.out.println("Please enter a valid number:");
            }
        }
    }

    public static String inputStringValidator(Scanner output){
        while (true) {
            String yesOrNo = output.nextLine();
            if ("Y".equalsIgnoreCase(yesOrNo) || "N".equalsIgnoreCase(yesOrNo)) {
                return yesOrNo;
            } else {
                System.out.println("Invalid—please enter Y or N.");
                System.out.println("Are you happy with this Selection? (Y/N)");
            }
        }
    }

    public static double calculatePrice(Meal meal){
        return meal.getPrice();
    }

    public static Burger selectBurger(Scanner output){
        for (int i = 0; i < Burger.AVAILABLE_BURGERS.length; i++) {
            System.out.printf("%d. %s, $%.2f - %s%n",i+1,
                    Burger.AVAILABLE_BURGERS[i].getName(),
                    Burger.AVAILABLE_BURGERS[i].getPrice(),
                    Burger.AVAILABLE_BURGERS[i].getDescription());
        }
        int choice = inputNumValidator(output, 1, Burger.AVAILABLE_BURGERS.length, "Please select your burger: ");
        System.out.println("You ordered the " + Burger.AVAILABLE_BURGERS[choice-1].getName() + ".");
        return (Burger.AVAILABLE_BURGERS[choice-1]);
    }

    public static Topping selectTopping(Scanner output, boolean isDeluxe){
        System.out.println("********TOPPINGS******** \n");
        for (int i = 0; i < Topping.AVAILABLE_TOPPINGS.length; i++) {
            if(isDeluxe){
                System.out.printf("%d. %s - %s%n", i+1,
                        Topping.AVAILABLE_TOPPINGS[i].getName(),
                        Topping.AVAILABLE_TOPPINGS[i].getDescription());
            }
            else {
                System.out.printf("%d. %s, $%.2f - %s%n", i + 1,
                        Topping.AVAILABLE_TOPPINGS[i].getName(),
                        Topping.AVAILABLE_TOPPINGS[i].getPrice(),
                        Topping.AVAILABLE_TOPPINGS[i].getDescription());
            }
        }
        System.out.println(Topping.AVAILABLE_TOPPINGS.length+1 + ". No additional toppings please");
        int choice = inputNumValidator(output, 1, Topping.AVAILABLE_TOPPINGS.length+1, "Please select your toppings: \n");
        if (choice == Topping.AVAILABLE_TOPPINGS.length+1){
              System.out.println("No additional toppings selected.");
              return null;
            }
            return (Topping.AVAILABLE_TOPPINGS[choice - 1]);
    }

    public static SideItem selectSide(Scanner output, boolean isDeluxe){
        System.out.println("********SIDE ITEMS******** \n");
        for (int i = 0; i < SideItem.AVAILABLE_SIDE_ITEMS.length; i++) {
            if(isDeluxe){
                System.out.printf("%d. %s - %s%n", i+1,
                        SideItem.AVAILABLE_SIDE_ITEMS[i].getName(),
                        SideItem.AVAILABLE_SIDE_ITEMS[i].getDescription());
            }else {
                System.out.printf("%d. %s, $%.2f - %s%n", i + 1,
                        SideItem.AVAILABLE_SIDE_ITEMS[i].getName(),
                        SideItem.AVAILABLE_SIDE_ITEMS[i].getPrice(),
                        SideItem.AVAILABLE_SIDE_ITEMS[i].getDescription());
            }
        }
        int choice = inputNumValidator(output, 1, SideItem.AVAILABLE_SIDE_ITEMS.length, "Please choose your side: ");
        return SideItem.AVAILABLE_SIDE_ITEMS[choice -1];
    }

    public static Drink selectDrink(Scanner output, boolean isDeluxe){
        System.out.println("Please choose your drink: \n");
        for (int i = 0; i < Drink.AVAILABLE_DRINKS.length; i++) {
            if(isDeluxe){
                System.out.printf("%d. %s - %s%n", i+1,
                        Drink.AVAILABLE_DRINKS[i].getName(),
                        Drink.AVAILABLE_DRINKS[i].getDescription());
            }
            else {
                System.out.printf("%d. %s, $%.2f - %s%n", i + 1,
                        Drink.AVAILABLE_DRINKS[i].getName(),
                        Drink.AVAILABLE_DRINKS[i].getPrice(),
                        Drink.AVAILABLE_DRINKS[i].getDescription());
            }
        }
        int choice = inputNumValidator(output, 1,Drink.AVAILABLE_DRINKS.length,"Please choose your drink: ");
        return Drink.AVAILABLE_DRINKS[choice -1];
    }

    public static StringBuilder addBurgerToppings(Scanner output, Burger selectedBurger,
                                                  boolean isDeluxe){
        Topping toppingOne = null, toppingTwo = null, toppingThree = null, toppingFour = null, toppingFive = null;
        StringBuilder toppingsString = new StringBuilder();
        boolean toppingsConfirmed = false;
        while (!toppingsConfirmed) {
            int toppingCount = (!isDeluxe)? 3: 5;
                selectedBurger.clearToppings();
            for (int i = 1; i <= toppingCount; i++) {
                Topping selectedTopping = selectTopping(output, isDeluxe);
                if (selectedTopping == null && i == 1) {
                    return toppingsString.append("no toppings");
                }
                else if (selectedTopping == null) {
                    break;
                }
                if (i == 1) {toppingOne = selectedTopping;}
                if (i == 2) {toppingTwo = selectedTopping;}
                if (i == 3) {toppingThree = selectedTopping;}
                if (i == 4) {toppingFour = selectedTopping;}
                if (i == 5) {toppingFive = selectedTopping;}
                selectedBurger.addTopping(selectedTopping);
            }
            toppingsString.setLength(0);
            if (toppingOne != null) toppingsString.append(toppingOne.getName());
            if (toppingTwo != null) toppingsString.append(", ").append(toppingTwo.getName().toLowerCase());
            if (toppingThree != null) toppingsString.append(", ").append(toppingThree.getName().toLowerCase());
            if (toppingFour != null) toppingsString.append(", ").append(toppingFour.getName().toLowerCase());
            if (toppingFive != null) toppingsString.append(", ").append(toppingFive.getName().toLowerCase());
            System.out.println(toppingsString);
            System.out.println("Are you happy with this Selection? (Y/N)");
            String yesOrNo = inputStringValidator(output);
            if (yesOrNo.equalsIgnoreCase("Y")) {
                toppingsConfirmed = true;
            }else {
                System.out.println("Toppings removed. Please select new toppings: ");
            }
        }
        return toppingsString;
    }
}