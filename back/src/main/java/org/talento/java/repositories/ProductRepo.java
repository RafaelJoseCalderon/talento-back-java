package org.talento.java.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.talento.java.models.Product;

public interface ProductRepo extends JpaRepository<Product, Long> {
    @Query("SELECT p FROM Product p WHERE p.title LIKE %:query% OR p.description LIKE %:query%")
    Page<Product> findBy(String query, Pageable page);
}
