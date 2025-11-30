package org.talento.java.dtos.orders;

import org.talento.java.dtos.cart.CartStateRes;

public record OrderCartRes(
    OrderRes order,
    CartStateRes cart
) { }
