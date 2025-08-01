package com.JavaStudent25;

public class Main {

    public static void main(String[] args) {
        MenuSelector.startMenu();
    }
}
/*
CODE PLAN FOR MENU SELECTOR

Scanner output = new Scanner(System.in);
        System.out.println("Welcome to Bill's burger joint!");
        System.out.println("Orders come in the form of 'Meals' - one Burger, one Drink, & one Side Item.");
        System.out.println("Please choose from the following options: ");
    }


COMBO LIST
1. Today's Deal! - Small Hamburger Combo $2.25
2. Deluxe Burger Combo
3. Create-Your-Own
4. Exit

Please Choose Your Burger:
{Array List of Burgers}
1.
2.
3.
4.


---Would you like to add toppings?(Y/N):

If Y
--Please select your toppings: (up to 3):
{Array List of Toppings}
1.
2.
3.

{repeat up to 3x - select your next topping: +finalNum = No more toppings}

## Are you happy with this selection?
{List selected toppings OR no toppings selected.}
(Y/N):

If Y move onto #$

If N
Please modify your toppings:
{if toppings not full}
1. Add
-------->
2. Remove
3. Change


Remove
Which Topping would you like to remove?
1.
2.
3.
{repeat up until all gone - no toppings. Go back to ##}

CHANGE
Which Topping would you like to change?
1.
2.
3.


If N


#$
Please Choose Your Sides:
1.
2.
3.
4.

#!
Please Choose Your Drink:
1.
2.
3.


ORDER SUMMARY:
You ordered the (Burger)( with {topping list}),(Side), and a (Drink).
The total for your order will be: {Price}
A 10% discount is automatically applied for Combo meals.
---------------
Are you happy with this order? (Y/N)
Y - You paid x.
Thank you for visiting Bill's Burgers. Enjoy your Meal!

--EXIT

N
Which part would you like to change?
1. Burger --> Loop back to Burger, loop back again.
2. Burger toppings --> Loop back to Toppings, loop back again.
3. Side ---> Loop back to Side, loop back again.
4. Drink ---> Loop back to Drink, loop back again.
5. Go back --> Are you happy with this order?


 */