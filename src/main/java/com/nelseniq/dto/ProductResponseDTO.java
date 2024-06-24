package com.nelseniq.dto;

import com.nelseniq.model.ProductMetadata;
import com.nelseniq.model.ShopperProduct;

public class ProductResponseDTO {
    private long shopperId;
    private long productId;
    private double relevancyScore;
    private String category;
    private String brand;

    public ProductResponseDTO(ShopperProduct shopperProduct, ProductMetadata productMetadata) {
        this.shopperId = shopperProduct.getShopperId();
        this.productId = shopperProduct.getProductId();
        this.relevancyScore = shopperProduct.getRelevancyScore();
        this.category = productMetadata.getCategory();
        this.brand = productMetadata.getBrand();
    }

    // Getters and setters
    public long getShopperId() {
        return shopperId;
    }

    public void setShopperId(long shopperId) {
        this.shopperId = shopperId;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public double getRelevancyScore() {
        return relevancyScore;
    }

    public void setRelevancyScore(double relevancyScore) {
        this.relevancyScore = relevancyScore;
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
