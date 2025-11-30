package org.talento.java.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.talento.java.dtos.cart.*;
import org.talento.java.models.CartItem;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CartMapper {
    CartItem toEntity(CartReq item);
    CartItemRes toItemRes(CartItem cartItem);

    @Mapping(target = "item")
    @Mapping(target = "cart", expression = "java(mapCartState(cartSize))")
    CartRes toDto(CartItem item, int cartSize);

    @Mapping(target = "items")
    @Mapping(target = "cart", expression = "java(mapCartState(cartSize))")
    CartListRest toDtoList(List<CartProductRes> items, int cartSize);

    default CartStateRes mapCartState(int totalItems) {
        return new CartStateRes(totalItems);
    }
}
