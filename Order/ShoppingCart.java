package Order;
import Catalog.Product;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class ShoppingCart {
    private Map<Product, Integer> items;

    public ShoppingCart() {
        this.items = new HashMap<>();
    }

    public void addProduct(Product product) {
        items.put(product, items.getOrDefault(product, 0) + 1);
    }

    public void removeProduct(Product product, int quantity) {
        if (!items.containsKey(product)) {
            System.out.println("Product not found in the cart.");
            return;
        }

        int currentQuantity = items.get(product);
        if (quantity < 0 || quantity > currentQuantity) {
            System.out.println("Invalid quantity. Cannot remove more than the existing amount.");
            return;
        }

        if (quantity < currentQuantity) {
            items.put(product, currentQuantity - quantity);
        } else {
            items.remove(product);
        }
    }

    public double getTotalAmount() {
        double total = 0.0;
        for (Entry<Product, Integer> entry : items.entrySet()) {
            total += entry.getKey().getPrice() * entry.getValue();
        }
        return total;
    }

    public Map<Product, Integer> getItems() {
        return new HashMap<>(items); // Return a copy of the items map
    }

    public void clear() {
        items.clear();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Shopping Cart:\n");
        for (Entry<Product, Integer> entry : items.entrySet()) {
            sb.append(entry.getKey()).append(", Quantity: ").append(entry.getValue()).append("\n");
        }
        sb.append("Total: $").append(getTotalAmount());
        return sb.toString();
    }
}
