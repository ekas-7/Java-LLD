import CommanEnum.ProductCategory;
import InventoryManager.InventoryManager;
import ProductReplinshmentStrategies.ConcreteStrategies.BulkOrderStrategy;
import ProductReplinshmentStrategies.ConcreteStrategies.JustInTimeStrategy;
import ProductReplinshmentStrategies.ProductReplinshmentStrategy;
import ProductFactory.Product;
import ProductFactory.ProductFactory;
import UtilityClasses.Warehouse;

public class Main {
    public static void main(String[] args) {
        // Get the singleton instance of InventoryManager
        ProductReplinshmentStrategy replenishmentStrategy = new JustInTimeStrategy();
        InventoryManager inventoryManager = InventoryManager.getInstance(replenishmentStrategy);

        // Create and add warehouses
        Warehouse warehouse1 = new Warehouse(1, "Warehouse 1", "Location A");
        Warehouse warehouse2 = new Warehouse(2, "Warehouse 2", "Location B");
        inventoryManager.addWarehouse(warehouse1);
        inventoryManager.addWarehouse(warehouse2);

        // Create products using ProductFactory
        ProductFactory productFactory = new ProductFactory();
        Product laptop = productFactory.createProduct(
                ProductCategory.ELECTONICS, "SKU123", "Laptop", 1000.0, 50, 25);
        Product tShirt = productFactory.createProduct(
                ProductCategory.CLOTHING, "SKU456", "T-Shirt", 20.0, 200, 100);
        Product apple = productFactory.createProduct(
                ProductCategory.GROCERY, "SKU789", "Apple", 1.0, 100, 200);

        // Add products to warehouses
        warehouse1.addProduct(laptop, 15);
        warehouse1.addProduct(tShirt, 20);
        warehouse2.addProduct(apple, 50);

        // Set replenishment strategy to Just-In-Time
        inventoryManager.setReplenishmentStrategy(new JustInTimeStrategy());

        // Perform inventory check and replenish if needed
        inventoryManager.performInventoryCheck();

        // Switch replenishment strategy to Bulk Order
        inventoryManager.setReplenishmentStrategy(new BulkOrderStrategy());

        // Replenish a specific product if needed
        inventoryManager.checkAndReplenish("SKU123");
    }
}

/*

Output :

15 units of Laptop (SKU: SKU123) added to Warehouse 1. New quantity: 15
20 units of T-Shirt (SKU: SKU456) added to Warehouse 1. New quantity: 20
50 units of Apple (SKU: SKU789) added to Warehouse 2. New quantity: 50


*/