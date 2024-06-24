package com.nelseniq.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class ProductMetadata {
    @Id
    private long productId;
    private String category;
    private String brand;

    // Getters and Setters

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
