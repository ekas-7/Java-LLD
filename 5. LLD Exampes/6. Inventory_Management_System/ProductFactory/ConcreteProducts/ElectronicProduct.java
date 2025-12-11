package ProductFactory.ConcreteProducts;

import ProductFactory.Product;
import CommanEnum.ProductCategory;

public class ElectronicProduct extends Product {
    private String brand;
    private int warrantyMonths;

    public ElectronicProduct(String sku, String name, double price, int quantity, int threshold) {
        super(sku, name, price, quantity, threshold, ProductCategory.ELECTONICS);
    }

    // Getters and setters for electronics-specific attributes
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getWarrantyMonths() {
        return warrantyMonths;
    }

    public void setWarrantyMonths(int warrantyMonths) {
        this.warrantyMonths = warrantyMonths;
    }
}
