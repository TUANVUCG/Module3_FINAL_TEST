package com.codegym.model.products;

public class Product {
    private int productId;
    private String productName;
    private float price;
    private int amount;
    private String color;
    private String description;
    private int category;

    public Product() {
    }

    public Product(String productName, float price, int amount, String color, String description, int category) {
        this.productName = productName;
        this.price = price;
        this.amount = amount;
        this.color = color;
        this.description = description;
        this.category = category;
    }

    public Product(int productId, String productName, float price, int amount, String color, String description, int category) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.amount = amount;
        this.color = color;
        this.description = description;
        this.category = category;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                ", amount=" + amount +
                ", color='" + color + '\'' +
                ", description='" + description + '\'' +
                ", category=" + category +
                '}';
    }
}
