package components;

import java.io.*;
import java.util.ArrayList;

public class SaveandLoadData {

    private static final String FILE_NAME = "RyzenTechDatabase.txt";

    // SAVE DATA
    public static void saveDataFile(ArrayList<Electronics> electronicsList,
                                    ArrayList<Accessories> accessoriesList) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(FILE_NAME))) {

            pw.println("===ELECTRONICS===");
            for (Electronics e : electronicsList) {
                pw.println(e.getName() + "|" + e.getBrand() + "|" + e.getPrice() + "|" + e.getQuantity());
            }

            pw.println("===ACCESSORIES===");
            for (Accessories a : accessoriesList) {
                pw.println(a.getName() + "|" + a.getType() + "|" + a.getPrice() + "|" + a.getQuantity());
            }

        } catch (IOException e) {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }

    // LOAD DATA
    public static void loadDataFile(ArrayList<Electronics> electronicsList, ArrayList<Accessories> accessoriesList) {

        File file = new File(FILE_NAME);
        if (!file.exists()) return;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            boolean isElectronics = false;
            boolean isAccessories = false;

            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue;

                if (line.equals("===ELECTRONICS===")) {
                    isElectronics = true;
                    isAccessories = false;
                    continue;
                }

                if (line.equals("===ACCESSORIES===")) {
                    isElectronics = false;
                    isAccessories = true;
                    continue;
                }

                String[] parts = line.split("\\|");
                if (parts.length != 4) continue;

                String name = parts[0];
                String second = parts[1]; // brand or type
                double price = Double.parseDouble(parts[2]);
                int qty = Integer.parseInt(parts[3]);

                if (isElectronics) {
                    Electronics e = new Electronics();
                    e.setName(name);
                    e.setBrand(second);
                    e.setPrice(price);
                    e.setQuantity(qty);
                    e.setCategory("Electronic");
                    electronicsList.add(e);
                } else if (isAccessories) {
                    Accessories a = new Accessories();
                    a.setName(name);
                    a.setType(second);
                    a.setPrice(price);
                    a.setQuantity(qty);
                    a.setCategory("Accessory");
                    accessoriesList.add(a);
                }
            }

        } catch (Exception e) {
            System.out.println("Error loading file: " + e.getMessage());
        }
    }
}
