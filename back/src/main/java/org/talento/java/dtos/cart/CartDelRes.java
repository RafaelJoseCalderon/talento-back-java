package org.talento.java.dtos.cart;

public record CartDelRes(
    CartItemRes deleted,
    CartStateRes cart
) { }
