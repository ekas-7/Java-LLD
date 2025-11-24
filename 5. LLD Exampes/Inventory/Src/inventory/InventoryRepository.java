package Inventory.Src.inventory;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class InventoryRepository {
    private final Map<String, Item> items = new ConcurrentHashMap<>();

    public Optional<Item> findById(String id) {
        return Optional.ofNullable(items.get(id));
    }

    public List<Item> findAll() {
        return new ArrayList<>(items.values());
    }

    public void save(Item item) {
        items.put(item.getId(), item);
    }

    public void delete(String id) {
        items.remove(id);
    }

    public List<Item> searchByName(String query) {
        if (query == null || query.isBlank()) return Collections.emptyList();
        String q = query.toLowerCase(Locale.ROOT);
        List<Item> res = new ArrayList<>();
        for (Item i : items.values()) {
            if (i.getName() != null && i.getName().toLowerCase(Locale.ROOT).contains(q)) {
                res.add(i);
            }
        }
        return res;
    }

    public List<Item> searchBySku(String skuQuery) {
        if (skuQuery == null || skuQuery.isBlank()) return Collections.emptyList();
        String q = skuQuery.toLowerCase(Locale.ROOT);
        List<Item> res = new ArrayList<>();
        for (Item i : items.values()) {
            if (i.getSku() != null && i.getSku().toLowerCase(Locale.ROOT).contains(q)) {
                res.add(i);
            }
        }
        return res;
    }
}
