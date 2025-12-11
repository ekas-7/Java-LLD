package InventoryManager;

import UtilityClasses.Warehouse;
import Product.ProductFactory;
import ProductReplinshmentStrategies.ProductReplinshment;

import java.util.List;

public class InventoryManager {
    private static InventoryManager instance;
    private List<Warehouse> warehouses;
    private ProductFactory productFactory;
    private ProductReplinshment replinshmentStrategy;
}
