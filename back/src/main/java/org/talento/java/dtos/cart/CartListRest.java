package org.talento.java.dtos.cart;

import java.util.List;

public record CartListRest(
    List<CartProductRes> items,
    CartStateRes cart
) { }
