package Component;
public class Product {
    protected String name;
    protected double price;
    protected int quantity;
    protected String category;

    public Product() {}

    // SETTERS
    public void setName(String name) { this.name = name; }
    public void setPrice(double price) { this.price = price; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public void setCategory(String category) { this.category = category; }

    // GETTERS
    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }
    public String getCategory() { return category; }

    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Price: ₱" + price);
        System.out.println("Quantity: " + quantity);
    }
}

