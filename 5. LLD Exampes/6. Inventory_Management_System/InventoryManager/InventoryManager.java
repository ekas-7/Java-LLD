package InventoryManager;

import UtilityClasses.Warehouse;
import ProductReplinshmentStrategies.ProductReplinshmentStrategy;

import java.util.List;

import ProductFactory.ProductFactory;

public class InventoryManager {
    private static InventoryManager instance;
    private List<Warehouse> warehouses;
    private ProductFactory productFactory;
    private ProductReplinshmentStrategy replinshmentStrategy;
}
