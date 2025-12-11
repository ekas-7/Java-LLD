package ProductFactory;

import CommanEnum.ProductCategory;

public abstract class Product {
    private String productId;
    private String name;
    private double price;
    private int quantity;
    private int threshold;
    private ProductCategory category;

    // Constructor
    public Product(String productId, String name, double price, int quantity, int threshold, ProductCategory category) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.threshold = threshold;
        this.category = category;
    }

    // Getters and Setters
    public String getProductId(){
        return this.productId;
    }

    public String getName(){
        return this.name;
    }

    public double getPrice(){
        return this.price;
    }

    public int getQuantity(){
        return this.quantity;
    }

    public int getThreshold(){
        return this.threshold;
    }

    public ProductCategory getCategory(){
        return category;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setThreshold(int threshold) {
        this.threshold = threshold;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }

    public void addStock(int quantity) {
        this.quantity += quantity;
    }

    public void removeStock(int quantity) {
        this.quantity -= quantity;
    }
}
