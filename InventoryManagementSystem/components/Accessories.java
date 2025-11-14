(Accesories)
 package Component;

public class Accessories extends Product {
    private String type;

    public Accessories() {}

    public void setType(String type) { this.type=type;}

    public String getType() {return type;}

    @Override
    public void display(){
        System.out.print("=== ACCESSORY ITEM ===");
        System.out.print("Type: " + type);
        super.display();
    }
}    

