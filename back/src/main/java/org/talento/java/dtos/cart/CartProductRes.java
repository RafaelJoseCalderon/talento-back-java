package org.talento.java.dtos.cart;

import org.talento.java.dtos.products.ProductRes;

public record CartProductRes(
    ProductRes product,
    int quantity
) { }
