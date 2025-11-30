package org.talento.java.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.talento.java.models.Category;

public interface CategoryRepo extends JpaRepository<Category, Long> {
}
