package Inventory.Src;

import Inventory.Src.inventory.InventoryRepository;
import Inventory.Src.inventory.InventoryService;
import Inventory.Src.inventory.Item;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        InventoryRepository repo = new InventoryRepository();
        InventoryService service = new InventoryService(repo);

        boolean running = true;
        while (running) {
            printMenu();
            String choice = scanner.nextLine().trim();
            switch (choice) {
                case "1" -> handleAdd(service);
                case "2" -> handleList(service);
                case "3" -> handleSearch(service);
                case "4" -> handleUpdateQuantity(service);
                case "5" -> handleDelete(service);
                case "6" -> handleUpdatePrice(service);
                case "0" -> running = false;
                default -> System.out.println("Unknown option");
            }
        }
        System.out.println("Goodbye");
    }

    private static void printMenu() {
        System.out.println("--- Inventory CLI ---");
        System.out.println("1) Add item");
        System.out.println("2) List items");
        System.out.println("3) Search by name");
        System.out.println("4) Update quantity (+/-)");
        System.out.println("5) Delete item");
        System.out.println("6) Update price");
        System.out.println("0) Exit");
        System.out.print("Choose: ");
    }

    private static void handleAdd(InventoryService service) {
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("SKU: ");
        String sku = scanner.nextLine();
        System.out.print("Description: ");
        String desc = scanner.nextLine();
        System.out.print("Quantity: ");
        int qty = Integer.parseInt(scanner.nextLine().trim());
        System.out.print("Price: ");
        double price = Double.parseDouble(scanner.nextLine().trim());
        Item item = service.createItem(name, sku, desc, qty, price);
        System.out.println("Created: " + item.getId());
    }

    private static void handleList(InventoryService service) {
        List<Item> items = service.listItems();
        if (items.isEmpty()) {
            System.out.println("No items");
            return;
        }
        for (Item i : items) {
            System.out.println(i);
        }
    }

    private static void handleSearch(InventoryService service) {
        System.out.print("Query: ");
        String q = scanner.nextLine();
        List<Item> res = service.searchByName(q);
        if (res.isEmpty()) System.out.println("No matches");
        else res.forEach(System.out::println);
    }

    private static void handleUpdateQuantity(InventoryService service) {
        System.out.print("Item id: ");
        String id = scanner.nextLine();
        System.out.print("Delta (use negative to subtract): ");
        int delta = Integer.parseInt(scanner.nextLine().trim());
        boolean ok = service.updateQuantity(id, delta);
        System.out.println(ok ? "Updated" : "Failed (not found or insufficient qty)");
    }

    private static void handleDelete(InventoryService service) {
        System.out.print("Item id: ");
        String id = scanner.nextLine();
        boolean ok = service.deleteItem(id);
        System.out.println(ok ? "Deleted" : "Not found");
    }

    private static void handleUpdatePrice(InventoryService service) {
        System.out.print("Item id: ");
        String id = scanner.nextLine();
        System.out.print("New price: ");
        double p = Double.parseDouble(scanner.nextLine().trim());
        Optional<Item> updated = service.updatePrice(id, p);
        System.out.println(updated.isPresent() ? "Price updated" : "Not found");
    }
}
