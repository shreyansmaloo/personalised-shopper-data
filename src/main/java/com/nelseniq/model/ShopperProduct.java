package com.nelseniq.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ShopperProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long shopperId;
    private long productId;
    private double relevancyScore;

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
}
