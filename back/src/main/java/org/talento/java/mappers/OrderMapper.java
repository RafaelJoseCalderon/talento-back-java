package org.talento.java.mappers;

import org.mapstruct.Mapper;
import org.talento.java.dtos.orders.OrderListRes;
import org.talento.java.dtos.orders.OrderRes;
import org.talento.java.models.Order;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    OrderRes toDto(Order order);
    List<OrderListRes> toDtos(List<Order> orders);
}
