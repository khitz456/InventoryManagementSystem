# Ryzentech Inventory  Management System

This Java console-based system helps Ryzentech Shop organize and track its computer parts and accessories. It lets users add, update, and view products, while keeping them sorted into electronics and accessories. The system also monitors stock levels automatically. Overall, it makes inventory management easier and helps avoid mistakes that come with manual tracking.

## Table of Contents

- OOP Concepts applied
- Program Structure
- How to Run the Program
- Sample output
- Author and Acknowledgement

## OOP Concepts applied

This Inventory System applies several OOP principles to make the program modular, organized, and easier to maintain. The main concepts used are Encapsulation, Inheritance, Polymorphism, and Abstraction.

1. Encapsulation 

Encapsulation is the concept of bundling data variables and methods functions into a single unit (a class) and protecting them from unauthorized access.

How it was applied:

Encapsulation is the concept of bundling data variables and methods functions into a single unit (a class) and protecting them from unauthorized access.

The classes Electronics and Accessories have private attributes such as:

- name
- price
- quantity
- Encapsulation
- (brand/type depending on the category)

Benefit: Prevents accidental modification of internal data and keeps the program secure and stable.

2. Inheritance

Inheritance allows a class to acquire the properties and behaviors of another class.

How it was applied:

- The classes Electronics and Accessories most likely inherit from a base class, such as Product or a shared parent.
- Both share common attributes (name, price, quantity, category), which means they are structured using inheritance.

Benefit: Avoids code duplication and makes the system easier to expand when adding new product types.

3. Polymorphism 

Polymorphism allows objects to be treated as instances of their parent class rather than their actual class.

How it was applied:

- Although the main program stores them separately electronicsList, accessoriesList, each subclass Electronics, Accessories overrides methods from the parent c

For example, both may override:

- setCategory()
- or specific methods to display product details.

If the system were later expanded, both product types could be stored in a single ArrayList<Product> and processed using polymorphism.

Benefit: Makes the system flexible, allowing multiple object types to be used through a common interface.

4. Abstraction

Abstraction focuses on hiding complexity and showing only essential features.

How it was applied:

- The product classes hide internal details such as how the category, type, brand, or quantity are stored.
- The main program interacts only with simple methods like:
           
   - setName()
   - setBrand()
   - setType()
   - setQuantity()

Benefit: Makes the code clean, readable, and easier to maintain.

## Program Structure

The Main class acts as the central controller of the Ryzentech Inventory System.
It serves as the entry point of the program and handles all user interactions through a text-based menu.

### Roles of the Main Class:

1. Displays the Main Menu
    - Shows available options such as adding products, displaying products, editing quantities, and exiting.

2. Handles User Input
    - Collects user choices and product information using a Scanner.

3. Coordinates Program Flow
    - Uses loops and switch cases to control navigation and perform the selected operations.

4. Manages Product Collections
    - Stores two lists:
        1. ArrayList<Electronics> electronicsList
        2. ArrayList<Accessories> accessoriesList

5. Creates and Modifies Objects
     - Creates new Electronics or Accessories objects based on user input.
     - Updates product quantities during editing.

6. Displays Inventory
     - Prints formatted tables showing saved electronics and accessories.

7. Validates Input
     - Uses try–catch to handle invalid or non-numeric inputs safely.

### List of Relationships:

1. Main → Electronics
   - Creates electronics objects
   - Stores them in an ArrayList
   - Displays and edits them

2. Main → Accessories
   - Creates accessory objects
   - Stores them in an ArrayList
   - Displays and edits them

3. Electronics & Accessories → Product
   - Both are assumed to inherit common product attributes (like name, price, quantity, category)

## How to Run the Program


## Sample output


## Author and Acknowledgement 
