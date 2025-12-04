package components;

public class Electronics extends Product {
    private String brand;

    public Electronics() {}

    public void setBrand(String brand) { this.brand = brand; }

    // GETTER
    public String getBrand() { return brand; }

    @Override
    public void displayInfo() {
        System.out.println("------ ELECTRONIC ITEM ------");
        System.out.println("Brand: " + brand);
        super.displayInfo();
    }
}
