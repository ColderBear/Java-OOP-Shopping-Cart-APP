package Catalog;
import java.util.HashMap;
import java.util.Map;
import java.util.Collection;

public class ProductCatalog {
    private Map<String, Product> products = new HashMap<>();

    // Method to add a product to the catalog
    public void addProduct(Product product) {
        products.put(product.getId(), product);
    }

    // Method to get a product by ID
    public Product getProduct(String productId) {
        return products.get(productId);
    }

    // Method to remove a product from the catalog
    public void removeProduct(String productId) {
        products.remove(productId);
    }

    // Method to get all products in the catalog
    public Collection<Product> getAllProducts() {
        return products.values();
    }
}
