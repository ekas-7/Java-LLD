package ProductFactory;

import CommanEnum.ProductCategory;
import ProductFactory.ConcreteProducts.ClothingProduct;
import ProductFactory.ConcreteProducts.ElectronicProduct;
import ProductFactory.ConcreteProducts.GroceryProduct;

// Product Factory class implementing Factory Pattern
public class ProductFactory {
    public Product createProduct(ProductCategory category, String sku, String name, double price, int quantity, int threshold) {
        switch (category) {
            case ELECTONICS:
                return new ElectronicProduct(sku, name, price, quantity, threshold);
            case CLOTHING:
                return new ClothingProduct(sku, name, price, quantity, threshold);
            case GROCERY:
                return new GroceryProduct(sku, name, price, quantity, threshold);
            default:
                throw new IllegalArgumentException(
                        "Unsupported product category: " + category);
        }
    }
}