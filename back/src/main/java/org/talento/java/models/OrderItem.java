package org.talento.java.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.util.Objects;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Entity @Table(name = "order_items")
public class OrderItem {
    @Id @GeneratedValue(strategy = SEQUENCE)
    private Long id;

    private Long productId;
    private String title;
    private BigDecimal price = BigDecimal.ZERO;
    private int quantity;
    private BigDecimal total = BigDecimal.ZERO;

    // region getters and setters
    public Long getId() {
        return id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
    // endregion

    // region equals and hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderItem orderItem = (OrderItem) o;
        return Objects.equals(this.productId, orderItem.productId) &&
               this.quantity == orderItem.quantity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, quantity);
    }
    // endregion

    public BigDecimal paymentAmount() {
        return this.price.multiply(new BigDecimal(this.quantity));
    }

    @PrePersist
    private void prePersist() {
        this.total = this.paymentAmount();
    }
}
