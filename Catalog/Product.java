package Catalog;
public abstract class Product {
    private String id;
    private String name;
    private double price;
    private String description;

    // Constructor for Product
    public Product(String id, String name, double price, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
    }

    // Getters and setters for the product attributes
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    // Retern the full product info as a string
    @Override
    public String toString() {
        return "id: '" + id + '\'' +
                ", name: '" + name + '\'' +
                ", price: " + price +
                ", description: '" + description + '\'';
    }
}
