package org.example.vendingMachin.entities;

import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private final Map<String, Product> products = new HashMap<>();

    public void addProduct(Product product) {
        products.put(product.getName(), product);
    }

    public Product getProduct(String name) {
        return products.get(name);
    }

    public boolean isAvailable(String name) {
        Product p = products.get(name);
        return p != null && p.getQuantity() > 0;
    }
}
