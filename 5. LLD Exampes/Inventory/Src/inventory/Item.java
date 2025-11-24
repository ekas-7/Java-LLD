package Inventory.Src.inventory;

import java.util.Objects;
import java.util.Locale;
import java.text.NumberFormat;

public class Item {
    private final String id; // unique identifier
    private String name;
    private String sku;
    private String description;
    private int quantity;
    private double price;

    public Item(String id, String name, String sku, String description, int quantity, double price) {
        if (id == null || id.isBlank()) throw new IllegalArgumentException("id is required");
        if (name == null || name.isBlank()) throw new IllegalArgumentException("name is required");
        if (sku == null || sku.isBlank()) throw new IllegalArgumentException("sku is required");
        if (quantity < 0) throw new IllegalArgumentException("quantity cannot be negative");
        if (price < 0) throw new IllegalArgumentException("price cannot be negative");

        this.id = id;
        this.name = name;
        this.sku = sku;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price < 0) throw new IllegalArgumentException("price cannot be negative");
        this.price = price;
    }

    @Override
    public String toString() {
    NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.getDefault());
    String priceStr = nf.format(price);
    return "Item{" +
        "id='" + id + '\'' +
        ", name='" + name + '\'' +
        ", sku='" + sku + '\'' +
        ", description='" + (description == null ? "" : description) + '\'' +
        ", quantity=" + quantity +
        ", price=" + priceStr +
        '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(id, item.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
