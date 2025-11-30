package org.talento.java.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.talento.java.dtos.cart.CartStateRes;
import org.talento.java.dtos.orders.OrderCartRes;
import org.talento.java.dtos.orders.OrderListRes;
import org.talento.java.dtos.orders.OrderRes;
import org.talento.java.models.Order;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    OrderRes toDto(Order order);
    List<OrderListRes> toDtos(List<Order> orders);

    @Mapping(target = "order")
    @Mapping(target = "cart", expression = "java(mapCartState(cartSize))")
    OrderCartRes toSale(Order order, int cartSize);

    default CartStateRes mapCartState(int totalItems) {
        return new CartStateRes(totalItems);
    }
}
