package Catalog;
public class ProductFactory {
    // Factory method to create products based on a type
    public static Product createProduct(String type, String id, String name, double price, String description) {
        switch (type) {
            case "Electronics":
                return new ElectronicsProduct(id, name, price, description);
            case "Clothing":
                return new ClothingProduct(id, name, price, description);
            // Add more cases for different product types
            default:
                throw new IllegalArgumentException("Unknown product type: " + type);
        }
    }
}

