package Order;

public class OrderProcessor {
    private static OrderProcessor instance;

    // Private constructor to prevent instantiation
    public OrderProcessor() {
    }

    // Static method to get the instance of the class
    public static OrderProcessor getInstance() {
        if (instance == null) {
            instance = new OrderProcessor();
        }
        return instance;
    }

    // Process an order from the shopping cart
    public Order processOrder(ShoppingCart cart) {
        if (cart.getItems().isEmpty()) {
            throw new IllegalStateException("Cannot process an order with an empty cart.");
        }

        // Create the order from the items in the cart
        Order order = new Order(cart.getItems());

        // Clear the cart after creating the order
        cart.clear();

        return order;
    }

    //Future addition: additional methods for order validation, payment, etc.
}

