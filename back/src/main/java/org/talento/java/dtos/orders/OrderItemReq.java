package org.talento.java.dtos.orders;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record OrderItemReq(
        @NotNull(message = "El ID del producto es obligatorio.")
        @Positive(message = "El ID del producto debe ser mayor a cero.")
        Long productId,

        @Min(value = 1, message = "La cantidad no puede ser negativo o cero.")
        int quantity
) { }
