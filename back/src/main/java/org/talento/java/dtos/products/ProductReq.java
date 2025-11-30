package org.talento.java.dtos.products;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public record ProductReq(
    @NotBlank(message = "El titulo del producto es obligatorio.")
    String title,

    @Positive(message = "El precio debe ser un número positivo.")
    BigDecimal price,

    @Min(value = 0, message = "El stock debe ser positivo mayor a cero.")
    int stock,

    String image,

    @NotNull(message = "La información de rating es obligatoria.")
    @Valid
    RatingReq rating,

    @NotBlank(message = "La descripción del producto es obligatoria.")
    @Size(max = 1023, message = "La descripción no puede exceder los 1023 caracteres.")
    String description,

    @NotNull(message = "La información de categoría es obligatoria.")
    Long categoryId
) {
    public record RatingReq(
        @Min(value = 0, message = "La calificación mínima debe ser 0.")
        @Max(value = 5, message = "La calificación máxima debe ser 5.")
        double rate,

        @Min(value = 0, message = "El número de valoraciones (count) no puede ser negativo.")
        int count
    ) {}
}
