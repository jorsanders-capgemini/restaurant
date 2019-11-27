package com.capgemini.restaurant.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Dish")
public class Dish {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column
    private String description;
    @Column
    private double sellingPrice;
    @Column
    @ManyToMany
    private List<Ingredient> ingredients;
    @Column
    private double margin;
    @Column
    private boolean available;

    public Dish() {
    }

    public Dish(long id) {
        this.id = id;
    }

    public Dish(long id, String description, double sellingPrice, List<Ingredient> ingredient, double margin, boolean available) {
        this.id = id;
        this.description = description;
        this.sellingPrice = sellingPrice;
        this.ingredients = ingredient;
        this.margin = margin;
        this.available = available;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public double getMargin() {
        return margin;
    }

    public void setMargin(double margin) {
        this.margin = margin;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

}
