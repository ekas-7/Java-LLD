package ProductFactory.ConcreteProducts;

import ProductFactory.Product;
import CommanEnum.ProductCategory;
import java.time.LocalDate;

public class GroceryProduct extends Product {
    private LocalDate expiryDate;
    private boolean isPerishable;

    public GroceryProduct(String sku, String name, double price, int quantity, int threshold) {
        super(sku, name, price, quantity, threshold, ProductCategory.GROCERY);
    }

    // Getters and setters for grocery-specific attributes
    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public boolean isPerishable() {
        return isPerishable;
    }

    public void setPerishable(boolean isPerishable) {
        this.isPerishable = isPerishable;
    }
}
