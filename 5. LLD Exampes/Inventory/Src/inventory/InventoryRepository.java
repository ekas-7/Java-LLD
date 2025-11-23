package Inventory.Src.inventory;

import java.util.*;

public class InventoryRepository {
    private final Map<String, Item> items = new HashMap<>();

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
        String q = query.toLowerCase(Locale.ROOT);
        List<Item> res = new ArrayList<>();
        for (Item i : items.values()) {
            if (i.getName() != null && i.getName().toLowerCase(Locale.ROOT).contains(q)) {
                res.add(i);
            }
        }
        return res;
    }
}
