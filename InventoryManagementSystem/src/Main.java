package src;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import components.*;

public class Main {

    public static final String CYAN_BOLD = "\u001B[1;36m";
    public static final String RESET = "\u001B[0m";

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Electronics> electronicsList = new ArrayList<>();
        ArrayList<Accessories> accessoriesList = new ArrayList<>();

        // Load existing data sa file
        SaveandLoadData.loadDataFile(electronicsList, accessoriesList);

        int choice = 0;

        System.out.println(CYAN_BOLD + "===========================================");
        System.out.println("█                                         █");
        System.out.println("█            W E L C O M E                █");
        System.out.println("█                TO                       █");
        System.out.println("█     RYZENTECH INVENTORY SYSTEM          █");
        System.out.println("█                AND                      █");
        System.out.println("█       WE ARE \"HAPPY FRIENDS\"            █");
        System.out.println("█                                         █");
        System.out.println("===========================================" + RESET);
        System.out.println("\nPress Enter to proceed to main menu...");
        sc.nextLine();

        do {
            clearScreen();

            System.out.println(CYAN_BOLD + "=======================================================");
            System.out.println(" ____  _  _ ____  ____  _  _ _____  ____   ___  _   _ ");
            System.out.println("|  _ \\| || |_  / | ___|| \\| |_   _|| ___| / __|| |_| |");
            System.out.println("| |_) | \\/ |/ /  | _|  | .` | | |  | _|  | |__ |  _  |");
            System.out.println("|_| \\_|\\__//___|_|_____|_|\\_| |_|  |____| \\___||_| |_|");
            System.out.println("=======================================================" + RESET);

            System.out.println("1. Add Product");
            System.out.println("2. Display Products");
            System.out.println("3. Edit Product");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            try {
                choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {

                    //ADD FUNCTION
                    case 1:
                        clearScreen();
                        System.out.print("Enter category (1 - Electronic, 2 - Accessory): ");
                        int cat = sc.nextInt();
                        sc.nextLine();

                        if (cat == 1) {
                            Electronics e = new Electronics();
                            System.out.print("Enter product name: ");
                            e.setName(sc.nextLine());
                            System.out.print("Enter brand: ");
                            e.setBrand(sc.nextLine());
                            System.out.print("Enter price: ");
                            e.setPrice(sc.nextDouble());
                            System.out.print("Enter quantity: ");
                            e.setQuantity(sc.nextInt());
                            sc.nextLine();
                            e.setCategory("Electronic");

                            electronicsList.add(e);

                            // Save after add
                            SaveandLoadData.saveDataFile(electronicsList, accessoriesList);

                            System.out.println("Electronic product added!");

                        } else if (cat == 2) {
                            Accessories a = new Accessories();
                            System.out.print("Enter product name: ");
                            a.setName(sc.nextLine());
                            System.out.print("Enter type: ");
                            a.setType(sc.nextLine());
                            System.out.print("Enter price: ");
                            a.setPrice(sc.nextDouble());
                            System.out.print("Enter quantity: ");
                            a.setQuantity(sc.nextInt());
                            sc.nextLine();
                            a.setCategory("Accessory");

                            accessoriesList.add(a);

                            // Save after add
                            SaveandLoadData.saveDataFile(electronicsList, accessoriesList);

                            System.out.println("Accessory product added!");
                        } else {
                            System.out.println("Invalid category choice.");
                        }

                        System.out.println("\nPress Enter to return to main menu...");
                        sc.nextLine();
                        break;

                    // DISPLAY FUNCTION
                    case 2:
                        clearScreen();
                        System.out.println("\n==================== ELECTRONICS ====================");
                        if (electronicsList.isEmpty()) {
                            System.out.println("No electronic products available.");
                        } else {
                            System.out.printf("%-20s %-15s %-10s %-10s\n",
                                    "Product Name", "Brand", "Price", "Qty");
                            System.out.println("-----------------------------------------------------");
                            for (Electronics e : electronicsList) {
                                System.out.printf("%-20s %-15s %-10.2f %-10d\n",
                                        e.getName(), e.getBrand(), e.getPrice(), e.getQuantity());
                            }
                        }

                        System.out.println("\n==================== ACCESSORIES ====================");
                        if (accessoriesList.isEmpty()) {
                            System.out.println("No accessories available.");
                        } else {
                            System.out.printf("%-20s %-15s %-10s %-10s\n",
                                    "Product Name", "Type", "Price", "Qty");
                            System.out.println("-----------------------------------------------------");
                            for (Accessories a : accessoriesList) {
                                System.out.printf("%-20s %-15s %-10.2f %-10d\n",
                                        a.getName(), a.getType(), a.getPrice(), a.getQuantity());
                            }
                        }

                        System.out.println("\nPress Enter to return to main menu...");
                        sc.nextLine();
                        break;

                    //EDIT FUNCTION
                    case 3:
                        clearScreen();
                        System.out.println("\nSelect category to edit:");
                        System.out.println("1. Electronics");
                        System.out.println("2. Accessories");
                        System.out.print("Enter choice: ");
                        int editCat = sc.nextInt();
                        sc.nextLine();

                        if (editCat == 1 && !electronicsList.isEmpty()) {
                            System.out.println("\n========== Electronics List ==========");
                            for (int i = 0; i < electronicsList.size(); i++) {
                                Electronics e = electronicsList.get(i);
                                System.out.println("ID: " + (i + 1) + " | " + e.getName() +
                                        " (" + e.getBrand() + ") Price: " + e.getPrice() +
                                        " | Qty: " + e.getQuantity());
                            }
                            System.out.print("Enter product number to update quantity: ");
                            int productNum = sc.nextInt();
                            sc.nextLine();

                            if (productNum >= 1 && productNum <= electronicsList.size()) {
                                Electronics selected = electronicsList.get(productNum - 1);
                                System.out.print("Enter new quantity (current: " + selected.getQuantity() + "): ");
                                int newQty = sc.nextInt();
                                sc.nextLine();
                                selected.setQuantity(newQty);

                                // Save after edit
                                SaveandLoadData.saveDataFile(electronicsList, accessoriesList);
                                System.out.println("Quantity updated successfully!");
                            } else {
                                System.out.println("Invalid product number!");
                            }

                        } else if (editCat == 2 && !accessoriesList.isEmpty()) {
                            System.out.println("\n---------- Accessories List ----------");
                            for (int i = 0; i < accessoriesList.size(); i++) {
                                Accessories a = accessoriesList.get(i);
                                System.out.println("ID: " + (i + 1) + " | " + a.getName() +
                                        " (" + a.getType() + ") Price: " + a.getPrice() +
                                        " | Qty: " + a.getQuantity());
                            }
                            System.out.print("Enter product number to update quantity: ");
                            int productNum = sc.nextInt();
                            sc.nextLine();

                            if (productNum >= 1 && productNum <= accessoriesList.size()) {
                                Accessories selected = accessoriesList.get(productNum - 1);
                                System.out.print("Enter new quantity (current: " + selected.getQuantity() + "): ");
                                int newQty = sc.nextInt();
                                sc.nextLine();
                                selected.setQuantity(newQty);

                                // Save after edit
                                SaveandLoadData.saveDataFile(electronicsList, accessoriesList);

                                System.out.println("Quantity updated successfully!");
                            } else {
                                System.out.println("Invalid product number!");
                            }
                        } else {
                            System.out.println("No products available or invalid category!");
                        }

                        System.out.println("\nPress Enter to return to main menu...");
                        sc.nextLine();
                        break;

                    //EXIT 
                    case 4:
                        clearScreen();
                       System.out.println();
                        System.out.println(CYAN_BOLD + "=======================================================");
                        System.out.println("   _____                 _ _                  _ ");
                        System.out.println("  / ____|               | | |                | |");
                        System.out.println(" | |  __  ___   ___   __| | |__  _   _  ___  | |");
                        System.out.println(" | | |_ |/ _ \\ / _ \\ / _` | '_ \\| | | |/ _ \\ | |");
                        System.out.println(" | |__| | (_) | (_) | (_| | |_) | |_| |  __/ |_|");
                        System.out.println("  \\_____|\\___/ \\___/ \\__,_|_.__/ \\__, |\\___| (_)"); 
                        System.out.println("                                  __/ |         ");
                        System.out.println("                                 |___/          ");
                        System.out.println("=======================================================");
                        System.out.println("█                                                     █");
                        System.out.println("█         RYZENTECH INVENTORY SYSTEM - OFFLINE        █");
                        System.out.println("█                                                     █");
                        System.out.println(   "=======================================================" + RESET);
                        System.out.println();
                        break;

                    default:
                        System.out.println("Invalid choice! Please try again.");
                        System.out.println("\nPress Enter to return to main menu...");
                        sc.nextLine();
                }

            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter numbers only.");
                sc.nextLine();
                System.out.println("\nPress Enter to return to main menu...");
                sc.nextLine();
            }

        } while (choice != 4);

        sc.close();
    }
}
