package org.talento.java.dtos.orders;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record OrderListRes(
    Long id,
    LocalDateTime creationDate,
    BigDecimal total
) { }
