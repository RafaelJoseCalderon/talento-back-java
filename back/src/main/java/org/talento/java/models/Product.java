package org.talento.java.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import org.talento.java.exceptions.InsufficientStockException;

import java.math.BigDecimal;

import static jakarta.persistence.CascadeType.*;
import static jakarta.persistence.GenerationType.SEQUENCE;

@Entity @Table(name = "products")
public class Product {
    @Id @GeneratedValue(strategy = SEQUENCE)
    private Long id;

    private String title;
    private BigDecimal price;
    private int stock;
    private String image;
    private double ratingRate;
    private int ratingCount;

    @Column(length = 1023)
    private String description;

    @ManyToOne(cascade = {PERSIST, MERGE})
    private Category category;

    // region getters and setters
    public Long getId() {
        return id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getStock() {
        return this.stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getRatingRate() {
        return this.ratingRate;
    }

    public void setRatingRate(double ratingRate) {
        this.ratingRate = ratingRate;
    }

    public int getRatingCount() {
        return ratingCount;
    }

    public void setRatingCount(int ratingCount) {
        this.ratingCount = ratingCount;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return this.category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
    // endregion

    public void decreaseStock(int quantity) {
        if (this.getStock() < quantity) {
            throw new InsufficientStockException();
        }

        this.stock -= quantity;
    }
}