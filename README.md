Burger Builder: Interactive Console-Based Menu Customizer
Overview
This is Burger Builder, a Java-based console application that allows users to interactively build & customize their burger orders. 
What was meant to be a straightforward exercise in the middle of a Udemy course about object-oriented programming (OOP) evolved into a Java deep dive around fundamentals, design principles, & user experience (UX) considerations. The project is a simulation of a Burger App menu, where you can select burgers, toppings, and pair this with sides & drinks. 
It also has a simple option, a 2 step order process for a simple hamburger combo (Press 1, press Y, done!) It handles special cases like deluxe burgers with toppings, sides and drinks all inclusive. It's also designed with extensibility in mind, making it easy to expand the menu without having to completely redesign things.
The app runs entirely console run, giving a text-based interface for input and output. It's an example of applying OOP concepts like inheritance, encapsulation, and polymorphism in a real-world scenario.
Features
Customizable Menu Building: Users can select from a variety of burgers (including a deluxe option), add up to a set number of toppings, choose sides (like fries), and pick drinks. The system calculates the total price dynamically.
Extensibility: Menu items are stored in arrays within their respective classes (e.g., Burger, Side, Drink). Adding or removing items is simple - simply update these arrays, & the app adapts seamlessly without requiring code changes elsewhere.
Defensive Input Validation: Robust handling for user inputs, including validation for integers (e.g., menu selections) and strings (e.g., yes/no responses). This is managed through a dedicated InputValidator class, which uses try-catch blocks to prevent crashes from invalid entries.
Special Handling for Deluxe Burgers: With a ‘Deluxe Burger’ selection, prices for toppings, sides, and drinks are hidden in the menu display, since they're included for free. This ensures a consistent and intuitive user experience.
Order Summary: At the end, the app prints a clean summary of the order, completely leaving out sections like ‘toppings’ if none were added, for better readability.
OOP-Centric Design: Classes for each menu item type inherit from a base structure, promoting code reuse. I consciously avoided an additional abstract Item class to keep things simple, given the limited item types (burger, side, drink)—though it could be added for further abstraction in future iterations.

Installation and Setup
Pre-requisites: Ensure you have Java Development Kit (JDK) installed (version 8 or higher recommended). This project uses standard Java libraries, so no external dependencies are needed.
Clone the Repository:
 text
git clone https://github.com/yourusername/burger-builder.git
 (Replace with your actual repo URL.)
Navigate to the Project Directory:
 text
cd burger-builder


Compile the Code:
 text
javac *.java
 (Or use an IDE like IntelliJ or Eclipse to import and build the project.)
Usage
Run the Application:

 text
java Main

 (Assuming Main is your entry-point class with the main method.)


Interacting with the App:


Follow the on-screen prompts to select a burger type.
Add toppings (limited based on burger type).
Choose a side and drink.
View the final order summary with total pricing.
Example flow:

Welcome to Burger Builder!
Welcome to Bill's burger joint!
Orders come in the form of 'Meals' - a burger, side, & a drink.
****BILL'S BURGER MENU****

1. Quick Meal - Small Hamburger Combo $2.25
2. Deluxe Burger Combo
3. Create-Your-Own-Combo 
4. Exit

Please choose from the options above: 
(User Selects 1)
You ordered the Hamburger, Small fries, with a Small soda.
ORDER SUMMARY: 
Hamburger: $1.50
Small fries: $0.50
Small soda: $0.50
Total: $2.50
A 10% discount is automatically applied for Combo meals.

The Grand Total for your order will be $2.25.
Are you happy with this selection? (Y/N)
(User Selects Y)
You paid $2.25. Thank you for visiting Bill's Burgers. Enjoy your meal!

The app includes input safeguards, so if you enter something invalid (e.g., a letter instead of a number), it'll prompt you to try again without crashing.


Technologies Used
Java: Core language for all logic, focusing on OOP principles.
Console I/O: Built with Scanner for user input and System.out for output—no GUI libraries.
No External Libraries: Pure vanilla Java to emphasize fundamentals.
Lessons Learned (& Reflections)
This project was a bit of a marathon - almost 70 hours! It emphasized a need for me to lock in and persist over a long period of time on a single task like this particular project. I started with a basic build (about 12 hours), and following that, worked from the “PoC” to spend the bulk of the 70 hours in refactoring that underlying logic, redesigning it for better OOP adherence, and enhancing UX. 
I learned the practical value of breaking down overwhelming scopes into bite-sized problems (I’d read what that was, but never ‘got’ what that meant or its utilty until this project); for example, figuring out how to conditionally skip printing empty toppings in the summary part of the output, came from step by step debugging & methodically stepping through the code.


Key insights:
OOP Depth: I got familiar with some of the nuances around inheritance (e.g., how burgers extend a base class for shared behaviors) and why certain designs promote maintainability. Skipping an abstract Item class was a deliberate choice to avoid over-engineering for just three item types, but it sparked thoughts on the value of abstraction, as the scope of a project may grow.


UX Matters in Console Apps: Small touches, like hiding prices for free items or validating inputs defensively, make a big difference in usability. It was a big priority for me to ensure that the user at the end of the day was the main beneficiary from the type of build I spent time constructing. This led me down a rabbit hole of learning about exception handling and custom validators, and how that impacts the end result. The ‘ecosystem’ of what’s created in code, & the direct outcomes that are attached to that as a natural result of what lies behind the code, is something I find extremely interesting!


Problem-Solving Mindset: Frustration from expanding scope (e.g., adding interactive menus) was a WAY bigger task than I intended, leading to an almost complete re-thinking of how I understood the way classes and methods interact - pushing me to simplify iteratively. It reinforced that coding is often step by step incremental progress.


AI as a Thought Partner: I used tools like Grok and ChatGPT sparingly - not for writing code, but for discussing concepts, validating design ideas, and getting objective feedback. This "reflective" approach helped solidify my understanding without shortcuts, building a solid individual foundation in Java basics that I know and can execute as a practical skillset. To me it serves as a ‘correct view’ in my mind - that AI shines as a co-pilot, once you grasp the fundamentals yourself & can use it to extend one’s ability to individually construct complexity at scale with hyperspeed.
Overall, this exercise helped me to grasp and understand Java mechanics, & showed me the "why" behind developer practices. If you're building something similar, consider starting small, then iterate—extensibility will follow naturally.
Contributing
Feel free to fork this repo and suggest improvements! If adding new menu items, just update the arrays in the relevant classes and test thoroughly.
Acknowledgments
Shoutout to online resources and AI advisors for helping clarify Java concepts during brainstorming sessions. This project was completed amidst life changes like moving cities and starting a new job, making the finish line even sweeter.

