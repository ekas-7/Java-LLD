package UtilityClasses;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import ProductFactory.Product;

public class Warehouse {
    private int warehouseId;
    private String location;
    private String name;
    private Map<String, Product> products;

    public Warehouse(int warehouseId, String name, String location) {
        this.warehouseId = warehouseId;
        this.name = name;
        this.location = location;
        this.products = new HashMap<>();
    }

    // Getters and Setters
    public int getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(int warehouseId) {
        this.warehouseId = warehouseId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Add a product to the warehouse
    public void addProduct(Product product, int quantity) {
        String productId = product.getProductId();
        if (products.containsKey(productId)) {
            // Product exists, update quantity
            Product existingProduct = products.get(productId);
            existingProduct.addStock(quantity);
        } else {
            // New product, add to inventory
            product.setQuantity(quantity);
            products.put(productId, product);
        }
        System.out.println(quantity + " units of " + product.getName()
                + " (ID: " + productId + ") added to " + name
                + ". New quantity: " + getAvailableQuantity(productId));
    }

    // Remove a product from the warehouse
    public boolean removeProduct(String productId, int quantity) {
        if (products.containsKey(productId)) {
            Product product = products.get(productId);
            int currentQuantity = product.getQuantity();
            if (currentQuantity >= quantity) {
                // Sufficient inventory to remove
                product.removeStock(quantity);
                System.out.println(quantity + " units of " + product.getName()
                        + " (ID: " + productId + ") removed from " + name
                        + ". Remaining quantity: " + product.getQuantity());
                // If quantity becomes zero, remove the product entirely
                if (product.getQuantity() == 0) {
                    products.remove(productId);
                    System.out.println("Product " + product.getName()
                            + " removed from inventory as quantity is now zero.");
                }
                return true;
            } else {
                System.out.println("Error: Insufficient inventory. Requested: "
                        + quantity + ", Available: " + currentQuantity);
                return false;
            }
        } else {
            System.out.println(
                    "Error: Product with ID " + productId + " not found in " + name);
            return false;
        }
    }

    // Get available quantity of a product
    public int getAvailableQuantity(String productId) {
        if (products.containsKey(productId)) {
            return products.get(productId).getQuantity();
        }
        return 0; // Product not found
    }

    // Get a product by ID
    public Product getProductById(String productId) {
        return products.get(productId);
    }

    // Get all products in this warehouse
    public Collection<Product> getAllProducts() {
        return products.values();
    }
}
