package UtilityClasses;

import Product.Product;


import java.util.Map;

public class Warehouse {
    private int warehouseId;
    private String location;
    private String name;
    private Map<String, Product> products;
    public void addProduct(Product product, int quantity){

    }
    public void removeProduct(String productId, int quantity){

    }
    public int getAvailableQuantity(String productId){
        return -1;
    }


}
