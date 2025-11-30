package org.talento.java.models;

import org.talento.java.exceptions.ExistentCartItemException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cart {
    Map<Long, CartItem> items = new HashMap<>();

    public CartItem addItem(CartItem item) {
        if (this.items.containsKey(item.productId())) {
            throw new ExistentCartItemException();
        }

        items.put(item.productId(), item);
        return item;
    }

    public CartItem delete(Long id) {
        return this.items.remove(id);
    }

    public List<Long> productsIds() {
        return new ArrayList<>(this.items.keySet());
    }

    public Integer getQuantityBy(Long itemId) {
        CartItem item = this.items.get(itemId);

        if (item != null) {
            return item.quantity();
        } else {
            return null;
        }
    }

    public int size() {
        return this.items.size();
    }
}
