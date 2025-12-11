package InventoryManager;

import UtilityClasses.Warehouse;
import ProductReplinshmentStrategies.ProductReplinshmentStrategy;
import ProductFactory.Product;

import java.util.List;
import java.util.ArrayList;

import ProductFactory.ProductFactory;

public class InventoryManager {
    // Singleton instance
    private static InventoryManager instance;

    // System components
    private List<Warehouse> warehouses;
    private ProductFactory productFactory;
    private ProductReplinshmentStrategy replenishmentStrategy;

    // Private constructor to prevent instantiation from outside
    private InventoryManager(ProductReplinshmentStrategy replenishmentStrategy) {
        // Initialize collections and dependencies
        warehouses = new ArrayList<>();
        productFactory = new ProductFactory();
        this.replenishmentStrategy = replenishmentStrategy;
    }

    // Static method to get the singleton instance with thread safety
    public static synchronized InventoryManager getInstance(ProductReplinshmentStrategy replenishmentStrategy) {
        if (instance == null) {
            instance = new InventoryManager(replenishmentStrategy);
        }
        return instance;
    }

    // Strategy pattern method
    public void setReplenishmentStrategy(ProductReplinshmentStrategy replenishmentStrategy) {
        this.replenishmentStrategy = replenishmentStrategy;
    }

    // Warehouse management
    public void addWarehouse(Warehouse warehouse) {
        warehouses.add(warehouse);
    }

    public void removeWarehouse(Warehouse warehouse) {
        warehouses.remove(warehouse);
    }

    // Product inventory operations
    public Product getProductById(String productId) {
        for (Warehouse warehouse : warehouses) {
            Product product = warehouse.getProductById(productId);
            if (product != null) {
                return product;
            }
        }
        return null;
    }

    // Check stock levels and apply replenishment strategy if needed
    public void checkAndReplenish(String productId) {
        Product product = getProductById(productId);
        if (product != null) {
            // If product is below threshold
            if (product.getQuantity() < product.getThreshold()) {
                // Apply current replenishment strategy
                if (replenishmentStrategy != null) {
                    replenishmentStrategy.replenish(product);
                }
            }
        }
    }

    // Global inventory check
    public void performInventoryCheck() {
        for (Warehouse warehouse : warehouses) {
            for (Product product : warehouse.getAllProducts()) {
                if (product.getQuantity() < product.getThreshold()) {
                    if (replenishmentStrategy != null)  replenishmentStrategy.replenish(product);
                }
            }
        }
    }
}