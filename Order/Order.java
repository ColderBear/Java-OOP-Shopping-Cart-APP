package Order;
import java.util.UUID;

import Catalog.Product;

import java.util.Map;
import java.util.HashMap;

public class Order {
    private String orderId;
    private Map<Product, Integer> items;
    private double totalAmount;

    public Order(Map<Product, Integer> items) {
        this.orderId = UUID.randomUUID().toString();
        this.items = new HashMap<>(items);
        this.totalAmount = calculateTotal();
    }

    private double calculateTotal() {
        double total = 0.0;
        for (Map.Entry<Product, Integer> entry : items.entrySet()) {
            total += entry.getKey().getPrice() * entry.getValue();
        }
        return total;
    }

    public String getOrderId() {
        return orderId;
    }

    public Map<Product, Integer> getItems() {
        return new HashMap<>(items);
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Order ID: ").append(orderId).append("\n");
        for (Map.Entry<Product, Integer> entry : items.entrySet()) {
            sb.append(entry.getKey().toString()).append(", Quantity: ").append(entry.getValue()).append("\n");
        }
        sb.append("Total Amount: $").append(totalAmount);
        return sb.toString();
    }
}
