package Catalog;
public class ElectronicsProduct extends Product {
    private String id;
    private String name;
    private double price;
    private String description;

    public ElectronicsProduct(String id, String name, double price, String description) {
        super(id, name, price, description);
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
    }

    // Electronics-specific methods
    @Override
    public String toString() {
        return "id: '" + id + '\'' +
                ", Type: Electronics" +
                ", name: '" + name + '\'' +
                ", price: " + price +
                ", electronic description: '" + description + '\'';
    }
}