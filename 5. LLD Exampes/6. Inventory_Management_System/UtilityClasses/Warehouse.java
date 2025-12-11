package UtilityClasses;

import java.util.Map;

import ProductFactory.Product;

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
