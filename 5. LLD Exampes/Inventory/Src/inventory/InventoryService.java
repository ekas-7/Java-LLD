package Inventory.Src.inventory;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class InventoryService {
    private final InventoryRepository repo;

    public InventoryService(InventoryRepository repo) {
        this.repo = repo;
    }

    // Create new item and return created Item
    public Item createItem(String name, String sku, String description, int quantity, double price) {
        // basic validation
        if (name == null || name.isBlank()) throw new IllegalArgumentException("name is required");
        if (sku == null || sku.isBlank()) throw new IllegalArgumentException("sku is required");
        if (quantity < 0) throw new IllegalArgumentException("quantity cannot be negative");
        if (price < 0) throw new IllegalArgumentException("price cannot be negative");

        String id = UUID.randomUUID().toString();
        Item item = new Item(id, name.trim(), sku.trim(), description == null ? "" : description.trim(), quantity, price);
        repo.save(item);
        return item;
    }

    public Optional<Item> getItem(String id) {
        return repo.findById(id);
    }

    public List<Item> listItems() {
        return repo.findAll();
    }

    public List<Item> searchByName(String query) {
        return repo.searchByName(query);
    }

    public List<Item> searchBySku(String skuQuery) {
        return repo.searchBySku(skuQuery);
    }

    public boolean deleteItem(String id) {
        Optional<Item> found = repo.findById(id);
        if (found.isEmpty()) return false;
        repo.delete(id);
        return true;
    }

    public boolean updateQuantity(String id, int delta) {
        Optional<Item> found = repo.findById(id);
        if (found.isEmpty()) return false;
        Item item = found.get();
        int newQty = item.getQuantity() + delta;
        if (newQty < 0) return false;
        item.setQuantity(newQty);
        repo.save(item);
        return true;
    }

    public Optional<Item> updatePrice(String id, double newPrice) {
        Optional<Item> found = repo.findById(id);
        if (found.isEmpty()) return Optional.empty();
        Item item = found.get();
        item.setPrice(newPrice);
        repo.save(item);
        return Optional.of(item);
    }

    public Optional<Item> updateDetails(String id, String name, String sku, String desc) {
        Optional<Item> found = repo.findById(id);
        if (found.isEmpty()) return Optional.empty();
        Item item = found.get();
        if (name != null) item.setName(name);
        if (sku != null) item.setSku(sku);
        if (desc != null) item.setDescription(desc);
        repo.save(item);
        return Optional.of(item);
    }
}
