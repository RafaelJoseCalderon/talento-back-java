package org.talento.java.dtos.products;

import org.talento.java.dtos.category.CategoryRes;
import org.talento.java.models.Product;

import java.math.BigDecimal;

public record ProductRes(
    Long id,
    String title,
    BigDecimal price,
    int stock,
    String image,
    RatingRes rating,
    String description,
    CategoryRes category
) {
    public record RatingRes(
        double rate,
        int count
    ) {
        public RatingRes(Product product) {
            this(product.getRatingRate(), product.getRatingCount());
        }
    }
}
