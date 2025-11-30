package org.talento.java.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.talento.java.dtos.orders.OrderCartRes;
import org.talento.java.dtos.orders.OrderListRes;
import org.talento.java.dtos.orders.OrderRes;
import org.talento.java.exceptions.NonExistentOrderException;
import org.talento.java.exceptions.NonExistentUserException;
import org.talento.java.exceptions.SaleException;
import org.talento.java.mappers.OrderMapper;
import org.talento.java.models.*;
import org.talento.java.repositories.CartRepo;
import org.talento.java.repositories.OrderRepo;
import org.talento.java.repositories.ProductRepo;
import org.talento.java.repositories.UserRepo;

import java.util.List;

@Service
public class OrderService {
    private final UserRepo users;
    private final ProductRepo products;
    private final OrderRepo orders;
    private final OrderMapper mapper;

    private final CartRepo carts;

    public OrderService(
        UserRepo users,
        ProductRepo products,
        OrderRepo orders,
        OrderMapper mapper,
        CartRepo carts
    ) {
        this.users = users;
        this.products = products;
        this.orders = orders;
        this.mapper = mapper;
        this.carts = carts;
    }

    public List<OrderListRes> getOrders(Long userId) {
        List<Order> orders = this.orders.findByUserId(userId);
        return this.mapper.toDtos(orders);
    }

    @Transactional
    public OrderCartRes completeSale(Long userId) {
        Cart cart = this.carts.get(userId);

        if (cart != null) {
            List<Long> ids = cart.productsIds();
            List<Product> products = this.products.findAllById(ids);
            User user = this.users.findById(userId)
                    .orElseThrow(NonExistentUserException::new);

            Order order = new Order();
            order.setUser(user);

            products.forEach(product -> {
                OrderItem item = new OrderItem();
                Integer quantity = cart.getQuantityBy(product.getId());

                item.setProductId(product.getId());
                item.setTitle(product.getTitle());
                item.setPrice(product.getPrice());
                item.setQuantity(quantity);

                product.decreaseStock(quantity);
                order.add(item);
            });

            this.products.saveAll(products);
            var orders = this.orders.save(order);

            carts.remove(userId);

            return this.mapper.toSale(orders, 0);
        }

        throw new SaleException();
    }

    public OrderRes getById(Long id) {
        Order order = this.orders.findById(id).orElseThrow(NonExistentOrderException::new);
        return this.mapper.toDto(order);
    }
}
