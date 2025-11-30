package org.talento.java.dtos.orders;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

public record OrderRes(
    Long id,
    LocalDateTime creationDate,
    BigDecimal total,
    Set<OrderItemRes> orderItems
) {
    public record OrderItemRes(
        Long id,
        Long productId,
        String title,
        BigDecimal price,
        int quantity,
        BigDecimal total
    ) { }
}
