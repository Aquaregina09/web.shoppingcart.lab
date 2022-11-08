package com.webshoppe.ecommerce.bean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cart {
    private Map<String, CartItem> items;
    BigDecimal grandTotal;

    public Cart() {
        items = new HashMap<>();
    }
    
    public BigDecimal getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(BigDecimal grandTotal) {
        this.grandTotal = grandTotal;
    }



    public int countItems() {
        return items.size();
    }

    public void add(CartItem item) {
        if (item == null) {
            throw new IllegalArgumentException("Cart item cannot be null");
        }
        if(items.containsKey(item.getId())) {
            CartItem itemInCart = items.get(item.getId());
            itemInCart.setQuantity(itemInCart.getQuantity()+1);
            items.replace(item.getId(), itemInCart);
        }
        else
            items.put(item.getId(), item);
    }

    public void remove(String id) {
        CartItem item = items.get(id);
        if (item == null) {
            throw new RuntimeException("Item not found");
        }
        items.remove(id);
    }

    public Map<String, CartItem> getItems() {
        return items;
    }

    public List<CartItem> getItemsAsList() {
        return new ArrayList<>(items.values());
    }    
}
