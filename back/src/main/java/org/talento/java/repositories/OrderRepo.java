package org.talento.java.repositories;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.talento.java.models.Order;

import java.util.List;
import java.util.Optional;

public interface OrderRepo extends JpaRepository<Order, Long> {

    @Override @NonNull
    @EntityGraph(attributePaths = {"orderItems"})
    Optional<Order> findById(@NonNull Long id);

    List<Order> findByUserId(Long userId);
}
