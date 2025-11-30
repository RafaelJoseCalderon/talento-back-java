package org.talento.java.bootstrap;

import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;
import org.talento.java.models.Order;
import org.talento.java.models.OrderItem;
import org.talento.java.models.Product;
import org.talento.java.models.User;
import org.talento.java.repositories.OrderRepo;
import org.talento.java.repositories.ProductRepo;
import org.talento.java.repositories.UserRepo;

import java.util.ArrayList;
import java.util.List;

@Component(value = "InitOrder.beanName")
@DependsOn(value = {"InitProduct.beanName", "InitUser.beanName"})
public class InitOrder extends BootstrapBase {
    private final UserRepo userRepo;
    private final ProductRepo productRepo;
    private final OrderRepo orderRepo;

    private final PlatformTransactionManager transactionManager;

    public InitOrder(
        UserRepo userRepo,
        ProductRepo productRepo,
        OrderRepo orderRepo,
        PlatformTransactionManager transactionManager
    ) {
        this.userRepo = userRepo;
        this.productRepo = productRepo;
        this.orderRepo = orderRepo;
        this.transactionManager = transactionManager;
    }

    @Override
    public String entityMessage() {
        return "orders";
    }

    public void preload() {
        List<User> users = this.userRepo.findAll();
        List<Product> products = this.productRepo.findAll();
        List<Order> orders = new ArrayList<>();
        Order order;
        OrderItem orderItem;

        // #############################################################################################################
        order = new Order();
        order.setUser(users.get(1));

        orderItem = new OrderItem();
        orderItem.setProductId(products.get(1).getId());
        orderItem.setTitle(products.get(1).getTitle());
        orderItem.setPrice(products.get(1).getPrice());
        orderItem.setQuantity(5);
        order.add(orderItem);

        orderItem = new OrderItem();
        orderItem.setProductId(products.get(2).getId());
        orderItem.setTitle(products.get(2).getTitle());
        orderItem.setPrice(products.get(2).getPrice());
        orderItem.setQuantity(5);
        order.add(orderItem);

        orderItem = new OrderItem();
        orderItem.setProductId(products.get(3).getId());
        orderItem.setTitle(products.get(3).getTitle());
        orderItem.setPrice(products.get(3).getPrice());
        orderItem.setQuantity(5);
        order.add(orderItem);

        orders.add(order);

        // #############################################################################################################
        order = new Order();
        order.setUser(users.get(2));

        orderItem = new OrderItem();
        orderItem.setProductId(products.get(2).getId());
        orderItem.setTitle(products.get(2).getTitle());
        orderItem.setPrice(products.get(2).getPrice());
        orderItem.setQuantity(5);
        order.add(orderItem);

        orderItem = new OrderItem();
        orderItem.setProductId(products.get(3).getId());
        orderItem.setTitle(products.get(3).getTitle());
        orderItem.setPrice(products.get(3).getPrice());
        orderItem.setQuantity(5);
        order.add(orderItem);

        orderItem = new OrderItem();
        orderItem.setProductId(products.get(4).getId());
        orderItem.setTitle(products.get(4).getTitle());
        orderItem.setPrice(products.get(4).getPrice());
        orderItem.setQuantity(5);
        order.add(orderItem);

        orders.add(order);

        // #############################################################################################################
        order = new Order();
        order.setUser(users.get(2));

        orderItem = new OrderItem();
        orderItem.setProductId(products.get(3).getId());
        orderItem.setTitle(products.get(3).getTitle());
        orderItem.setPrice(products.get(3).getPrice());
        orderItem.setQuantity(5);
        order.add(orderItem);

        orderItem = new OrderItem();
        orderItem.setProductId(products.get(4).getId());
        orderItem.setTitle(products.get(4).getTitle());
        orderItem.setPrice(products.get(4).getPrice());
        orderItem.setQuantity(5);
        order.add(orderItem);

        orderItem = new OrderItem();
        orderItem.setProductId(products.get(5).getId());
        orderItem.setTitle(products.get(5).getTitle());
        orderItem.setPrice(products.get(5).getPrice());
        orderItem.setQuantity(5);
        order.add(orderItem);

        orders.add(order);

        this.orderRepo.saveAll(orders);
    }

    @Override
    public void load() {
        var transaction = new TransactionTemplate(transactionManager);
        transaction.execute(status -> {
            this.preload();
            return "status";
        });
    }
}
