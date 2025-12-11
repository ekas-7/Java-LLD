package ProductReplinshmentStrategies.ConcreteStrategies;

import ProductFactory.Product;
import ProductReplinshmentStrategies.ProductReplinshmentStrategy;

public class BulkOrderStrategy implements ProductReplinshmentStrategy {
    @Override
    public void replenish(Product product) {
        // Implement Bulk Order replenishment logic
        System.out.println("Applying Bulk Order replenishment for " + product.getName());
        // Order in large quantities to minimize order costs
    }
}
