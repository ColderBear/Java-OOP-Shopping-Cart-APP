import Authentication.AuthenticationService;
import Catalog.*;
import Order.*;
import Payment.*;

import java.util.Scanner;

public class Main {
    private static ProductCatalog catalog = new ProductCatalog();
    private static ShoppingCart cart = new ShoppingCart();
    private static boolean checkedout = false;

    public static void main(String[] args) {
        initializeCatalog(); // Populate the catalog with some products

        Scanner scanner = new Scanner(System.in);
        AuthenticationService authService = new AuthenticationService();

        System.out.println("Welcome to the Shopping System");
        System.out.println("1. Register");
        System.out.println("2. Login");
        System.out.print("Choose an option: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (choice) {
            case 1:
                handleRegistration(scanner, authService);
                break;
            case 2:
                if (handleLogin(scanner, authService)) {
                    System.out.println("Logged in successfully!");
                    handleShopping(scanner);
                } else {
                    System.out.println("Login failed.");
                }
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    private static void initializeCatalog() {
        catalog.addProduct(ProductFactory.createProduct("Electronics", "E001", "TeemoTech Laptop", 1200.00, "High-end gaming laptop"));
        catalog.addProduct(ProductFactory.createProduct("Clothing", "C001", "UniTeemo T-Shirt", 29.99, "Cotton graphic tee"));

    }

    private static void handleRegistration(Scanner scanner, AuthenticationService authService) {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        try {
            authService.register(username, password);
            System.out.println("Registration successful.");
        } catch (IllegalArgumentException e) {
            System.err.println("Registration failed: " + e.getMessage());
        }
    }


    private static boolean handleLogin(Scanner scanner, AuthenticationService authService) {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        return authService.login(username, password);
    }
    private static void handleShopping(Scanner scanner) {
        boolean shopping = true;
        while (shopping) {
            System.out.println("\nShopping Options:");
            System.out.println("1. View Products");
            System.out.println("2. Add Product to Cart");
            System.out.println("3. Remove Product from Cart");
            System.out.println("4. View Cart");
            System.out.println("5. Checkout");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
    
            switch (choice) {
                case 1:
                    displayProducts();
                    break;
                case 2:
                    System.out.print("Enter Product ID: ");
                    String productId = scanner.nextLine();
                    addProductToCart(productId);
                    break;
                case 3:
                    System.out.print("Enter Product ID to remove: ");
                    String removeProductId = scanner.nextLine();
                    System.out.print("Enter quantity to remove: ");
                    int quantity = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    removeProductFromCart(removeProductId, quantity);
                    break;
                case 4:
                    viewCart();
                    break;
                case 5:
                    checkout();
                    if(checkedout)
                    {
                        shopping = false;
                    }
                    break;

                case 6:
                    shopping = false;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
     

    private static void displayProducts() {
        for (Product product : catalog.getAllProducts()) {
            System.out.println(product);
        }
    }

    private static void addProductToCart(String productId) {
        Product product = catalog.getProduct(productId);
        if (product != null) {
            cart.addProduct(product);
            System.out.println(product.getName() + " added to cart.");
        } else {
            System.out.println("Product not found.");
        }
    }
    private static void removeProductFromCart(String productId, int quantity) {
        Product product = catalog.getProduct(productId);
        if (product != null) {
            cart.removeProduct(product, quantity);
        } else {
            System.out.println("Product not found.");
        }
    }

    private static void viewCart() {
        if (cart.getItems().isEmpty()) {
            System.out.println("Your cart is empty.");
        } else {
            System.out.println(cart);
        }
    }   

    private static void checkout() {
        if (cart.getItems().isEmpty()) {
            System.out.println("Your cart is empty. Add some products before checkout.");
            return;
        }
    
        System.out.println(cart);
    
        // Simulate getting payment details from the user
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter card number: ");
        String cardNumber = scanner.nextLine();
        System.out.print("Enter cardholder name: ");
        String cardHolderName = scanner.nextLine();
        PaymentDetails paymentDetails = new PaymentDetails(cardNumber, cardHolderName, cart.getTotalAmount());
    
        // Process payment
        PaymentProcessor paymentProcessor = new PaymentProcessor();
        if (paymentProcessor.processPayment(paymentDetails)) {
            System.out.println("Payment successful. Proceeding with order.");
            OrderProcessor processor = new OrderProcessor();
            Order order = processor.processOrder(cart);
            System.out.println(order);
        } else {
            System.out.println("Payment failed. Please try again or use a different payment method.");
        }
    }    

}

