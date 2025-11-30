package org.talento.java.models;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import static jakarta.persistence.CascadeType.PERSIST;
import static jakarta.persistence.GenerationType.SEQUENCE;

@Entity @Table(name = "invoice")
public class Order {
    @Id @GeneratedValue(strategy = SEQUENCE)
    private Long id;

    private LocalDateTime creationDate;
    private BigDecimal total = BigDecimal.ZERO;

    @ManyToOne(cascade = {PERSIST})
    private User user;

    @OneToMany(cascade = PERSIST)
    @JoinColumn(name = "order_id", nullable = false)
    private Set<OrderItem> orderItems = new HashSet<>();

    // region getters
    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getCreationDate() {
        return this.creationDate;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public Set<OrderItem> getOrderItems() {
        return this.orderItems;
    }
    // endregion

    public void add(OrderItem orderItem) {
        if (this.orderItems.contains(orderItem)) {
            throw new RuntimeException("Repeated products in 'Order' class");
        }

        this.orderItems.add(orderItem);
    }

    private void makeCreationDate() {
        this.creationDate = LocalDateTime.now();
    }

    private void calculateTotal() {
        for (OrderItem item : this.orderItems) {
            this.total = this.total.add(item.paymentAmount());
        }
    }

    @PrePersist
    private void prePersist() {
        this.makeCreationDate();
        this.calculateTotal();
    }
}
