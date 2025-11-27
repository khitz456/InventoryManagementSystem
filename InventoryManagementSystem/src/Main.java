package src;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import Component.*;

public class Main {

    public static void clearScreen() {
        System.out.print("\033[H\033[2J"); 
        System.out.flush();            
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in); 
        ArrayList<Electronics> electronicsList = new ArrayList<>();
        ArrayList<Accessories> accessoriesList = new ArrayList<>();
        int choice = 0;

        do {
            clearScreen();
            System.out.println("=======================================================");
            System.out.println(" ____  _  _ ____  ____  _  _ _____  ____   ___  _   _ ");
            System.out.println("|  _ \\| || |_  / | ___|| \\| |_   _|| ___| / __|| |_| |");
            System.out.println("| |_) | \\/ |/ /  | _|  | .` | | |  | _|  | |__ |  _  |");
            System.out.println("|_| \\_|\\__//___|_|_____|_|\\_| |_|  |____| \\___||_| |_|");
            System.out.println("=======================================================");

            System.out.println("1. Add Product");
            System.out.println("2. Display Products");
            System.out.println("3. Edit Product");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
