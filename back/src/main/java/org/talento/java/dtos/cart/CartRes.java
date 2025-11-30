package org.talento.java.dtos.cart;

public record CartRes(
    CartItemRes item,
    CartStateRes cart
) { }
