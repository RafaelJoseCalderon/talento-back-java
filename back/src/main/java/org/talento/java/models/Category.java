package org.talento.java.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Entity @Table(name = "category")
public class Category {
    @Id @GeneratedValue(strategy = SEQUENCE)
    private Long id;

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    // region getters and setters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    // endregion
}
