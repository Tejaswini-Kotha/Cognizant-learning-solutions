import java.util.*;

class Product {
    String id;
    String name;
    int quantity;
    double price;

    public Product(String id, String name, int quantity, double price) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public String toString() {
        return "ID: " + id + " , Name: " + name + " , Qty: " + quantity + " , Price: " + price;
    }
}

public class InventoryManagementSystem {
    private Map<String, Product> inventory = new HashMap<>();

    public void addProduct(Product product) {
        if (inventory.containsKey(product.id)) {
            System.out.println("Product already exists with ID: " + product.id);
        } else {
            inventory.put(product.id, product);
            System.out.println("Product added: " + product.name);
        }
    }

    public void updateProduct(String id, int newQuantity, double newPrice) {
        Product p = inventory.get(id);
        if (p != null) {
            p.quantity = newQuantity;
            p.price = newPrice;
            System.out.println("Product updated: " + p.name);
        } else {
            System.out.println("Product not found with ID: " + id);
        }
    }

    public void deleteProduct(String id) {
        Product removed = inventory.remove(id);
        if (removed != null) {
            System.out.println("Product deleted: " + removed.name);
        } else {
            System.out.println("Product not found with ID: " + id);
        }
    }

    public void showAllProducts() {
        if (inventory.isEmpty()) {
            System.out.println("Inventory is empty.");
        } else {
            System.out.println("\n--- Product List ---");
            for (Product p : inventory.values()) {
                System.out.println(p);
            }
        }
    }

    public static void main(String[] args) {
        InventoryManagementSystem system = new InventoryManagementSystem();

        system.addProduct(new Product("P101", "Mouse", 50, 299.99));
        system.addProduct(new Product("P102", "Keyboard", 30, 499.99));
        system.addProduct(new Product("P103", "Monitor", 20, 5999.99));

        system.showAllProducts();

        system.updateProduct("P101", 45, 279.99);
        system.deleteProduct("P102");

        system.showAllProducts();
    }
}
