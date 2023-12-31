package Catalog;
public class ClothingProduct extends Product {
    private String id;
    private String name;
    private double price;
    private String description;

    public ClothingProduct(String id, String name, double price, String description) {
        super(id, name, price, description);
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
    }

    // Clothing-specific methods
    @Override
    public String toString() {
        return "id: '" + id + '\'' +
                ", Type: Clothing" +
                ", name: '" + name + '\'' +
                ", price: " + price +
                ", description: '" + description + '\'';
    }
}