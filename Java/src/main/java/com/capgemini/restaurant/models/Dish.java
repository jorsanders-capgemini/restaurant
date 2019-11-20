package com.capgemini.restaurant.models;

import java.util.ArrayList;
import java.util.List;

public class Dish {
    private String id;
    private String description;
    private double sellingPrice;
    private List<Ingredient> ingredients = new ArrayList<Ingredient>();
    private double margin;
    private boolean available;

    public Dish(String id) {this.id = id;}

    public Dish(String id, String description, double sellingPrice, ArrayList<Ingredient> ingredients, double margin, boolean available) {
        this.id = id;
        this.description = description;
        this.sellingPrice = sellingPrice;
        this.ingredients = ingredients;
        this.margin = margin;
        this.available = available;
    }

    public Dish() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
