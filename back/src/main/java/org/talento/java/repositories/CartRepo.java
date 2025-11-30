package org.talento.java.repositories;

import org.springframework.stereotype.Repository;
import org.talento.java.models.Cart;

import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

@Repository
public class CartRepo {
    private final ConcurrentHashMap<Long, Cart> dataStore = new ConcurrentHashMap<>();

    public Cart computeIfAbsent(Long key, Function<Long, Cart> mappingFunction) {
        return this.dataStore.computeIfAbsent(key, mappingFunction);
    }

    public Cart get(Long key) {
        return this.dataStore.get(key);
    }

    public void remove(Long key) {
        this.dataStore.remove(key);
    }
}
