package com.capgemini.restaurant.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Dish")
public class Dish {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    @Column
    private String description;
    @Column
    private double sellingPrice;
    @Column
    private List<Ingredient> ingredients = new ArrayList<Ingredient>();
    @Column
    private double margin;
    @Column
    private boolean available;

    public Dish(long id) {
        id = id;
    }

    public Dish(long id, String description, double sellingPrice, List<Ingredient> ingredients, double margin, boolean available) {
        id = id;
        this.description = description;
        this.sellingPrice = sellingPrice;
        this.ingredients = ingredients;
        this.margin = margin;
        this.available = available;
    }

    public Dish() {
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

    public Double getSellingPrice() {
        return sellingPrice;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(ArrayList<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public void setSellingPrice(Double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
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
