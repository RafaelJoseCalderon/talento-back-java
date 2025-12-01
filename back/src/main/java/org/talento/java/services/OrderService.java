package org.talento.java.services;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.talento.java.dtos.orders.OrderItemReq;
import org.talento.java.dtos.orders.OrderListRes;
import org.talento.java.dtos.orders.OrderRes;
import org.talento.java.exceptions.NonExistentOrderException;
import org.talento.java.exceptions.OrderItemListException;
import org.talento.java.mappers.OrderMapper;
import org.talento.java.models.Order;
import org.talento.java.models.OrderItem;
import org.talento.java.models.Product;
import org.talento.java.repositories.OrderRepo;
import org.talento.java.repositories.ProductRepo;
import org.talento.java.repositories.UserRepo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrderService {
    private final UserRepo users;
    private final ProductRepo products;
    private final OrderRepo orders;
    private final OrderMapper mapper;

    public OrderService(
        UserRepo users,
        ProductRepo products,
        OrderRepo orders,
        OrderMapper mapper
    ) {
        this.users = users;
        this.products = products;
        this.orders = orders;
        this.mapper = mapper;
    }

    public List<OrderListRes> getOrders(Long id) {
        return this.mapper.toDtos(this.orders.findByUserId(id));
    }

    private Map<Long, Product> getProducts(List<OrderItemReq> items) {
        Map<Long, Product> productsMap = new HashMap<>();
        List<Long> productIds = new ArrayList<>();
        List<Product> products;

        if (items.isEmpty()) {
            throw new OrderItemListException();
        }

        for (OrderItemReq item : items) {
            productIds.add(item.productId());
        }

        products = this.products.findAllById(productIds);

        if (items.size() != products.size()) {
            throw new OrderItemListException();
        }

        for (Product product : products) {
            productsMap.put(product.getId(), product);
        }

        return productsMap;
    }

    private OrderItem makeOrderItem(OrderItemReq itemReq, Product product) {
        product.decreaseStock(itemReq.quantity());

        OrderItem item = new OrderItem();
        item.setProductId(product.getId());
        item.setTitle(product.getTitle());
        item.setPrice(product.getPrice());
        item.setQuantity(itemReq.quantity());

        return item;
    }

    @Transactional
    public OrderRes completeSale(Long userId, List<OrderItemReq> items) {
        Map<Long, Product> products = this.getProducts(items);
        Order order = new Order();

        order.setUser(users.getReferenceById(userId));

        items.forEach(item -> {
            Product product = products.get(item.productId());
            OrderItem oItem = this.makeOrderItem(item, product);

            order.add(oItem);
        });

        this.products.saveAll(products.values());
        return this.mapper.toDto(this.orders.save(order));
    }

    public OrderRes getById(Long id) {
        Order order = this.orders.findById(id).orElseThrow(NonExistentOrderException::new);
        return this.mapper.toDto(order);
    }
}
