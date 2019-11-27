package com.capgemini.restaurant.models;

import javax.persistence.*;

@Entity
@Table(name = "Ingredient")
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column
    private String name;
    @Column
    private String category;
    @Column
    private String stock;
    @ManyToOne
    // TODO: remove Transient
    @Transient
    private Dish dish;

    public Ingredient() {
    }

    public Ingredient(long id, String name, String category, String stock) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.stock = stock;
    }

    public Ingredient(String name, String category, String stock) {
        this.name = name;
        this.category = category;
        this.stock = stock;
    }

    public Ingredient(long id) {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }
}