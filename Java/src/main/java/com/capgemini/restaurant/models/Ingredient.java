package com.capgemini.restaurant.models;

import javax.persistence.ManyToOne;

public class Ingredient {
    private String description;
    private String branch;
    private String supplier;
    private String id;
    private String unit;
    private String amount;
    private String price;
    private String VAT;
    private String pricePerUnit;
    private String category;
    private String stock;
    private String stockValue;
    // more than 1 ingredient possible in a dish
    @ManyToOne
    private Dish dish;

    public Ingredient(String id) {
        this.id = id;
    }

    public Ingredient(String description, String branch, String supplier, String id, String unit, String amount, String price, String VAT, String pricePerUnit, String category, String stock, String stockValue) {
        this.description = description;
        this.branch = branch;
        this.supplier = supplier;
        this.id = id;
        this.unit = unit;
        this.amount = amount;
        this.price = price;
        this.VAT = VAT;
        this.pricePerUnit = pricePerUnit;
        this.category = category;
        this.stock = stock;
        this.stockValue = stockValue;
    }

    public Ingredient() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getVAT() {
        return VAT;
    }

    public void setVAT(String VAT) {
        this.VAT = VAT;
    }

    public String getPricePerUnit() {
        return pricePerUnit;
    }

    public void setPricePerUnit(String pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
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

    public String getStockValue() {
        return stockValue;
    }

    public void setStockValue(String stockValue) {
        this.stockValue = stockValue;
    }
}
