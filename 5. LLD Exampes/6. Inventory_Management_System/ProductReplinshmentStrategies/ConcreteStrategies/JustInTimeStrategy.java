package ProductReplinshmentStrategies.ConcreteStrategies;

import ProductFactory.Product;
import ProductReplinshmentStrategies.ProductReplinshmentStrategy;

public class JustInTimeStrategy implements ProductReplinshmentStrategy {
    @Override
    public void replenish(Product product) {
        // Implement Just-In-Time replenishment logic
        System.out.println("Applying Just-In-Time replenishment for " + product.getName());
        // Calculate optimal order quantity based on demand rate
    }
}
