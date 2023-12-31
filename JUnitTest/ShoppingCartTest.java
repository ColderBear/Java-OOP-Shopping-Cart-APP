package JUnitTest;
import Catalog.*;
import Order.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ShoppingCartTest {

    private ShoppingCart cart;
    private Product laptop;
    private Product tShirt;

    @BeforeEach
    void setUp() {
        cart = new ShoppingCart();
        laptop = new ElectronicsProduct("E001", "Laptop", 1200.00, "High-end gaming laptop");
        tShirt = new ClothingProduct("C001", "T-Shirt", 29.99, "Cotton graphic tee");
    }

    @Test
    void addAndRemoveProduct() {
        cart.addProduct(laptop);
        cart.addProduct(tShirt);
        assertEquals(2, cart.getItems().size());
        cart.removeProduct(laptop, 1);
        assertEquals(1, cart.getItems().size());
    }

    @Test
    void calculateTotalAmount() {
        cart.addProduct(laptop);
        cart.addProduct(tShirt);
        double total = laptop.getPrice() + tShirt.getPrice();
        assertEquals(total, cart.getTotalAmount());
    }
}

