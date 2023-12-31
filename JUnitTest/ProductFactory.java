package JUnitTest;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import Catalog.*;

class ProductFactoryTest {

    @Test
    void createElectronicsProduct() {
        Product product = ProductFactory.createProduct("Electronics", "E001", "Laptop", 1200.00, "High-end gaming laptop");
        assertTrue(product instanceof ElectronicsProduct);
        assertEquals("E001", product.getId());
    }

    @Test
    void createClothingProduct() {
        Product product = ProductFactory.createProduct("Clothing", "C001", "T-Shirt", 29.99, "Cotton graphic tee");
        assertTrue(product instanceof ClothingProduct);
        assertEquals("C001", product.getId());
    }

    @Test
    void createUnknownProduct() {
        assertThrows(IllegalArgumentException.class, () -> {
            ProductFactory.createProduct("Unknown", "U001", "Unknown Product", 100.00, "Mystery item");
        });
    }
}

