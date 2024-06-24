package com.nelseniq.repository;

import com.nelseniq.model.ProductMetadata;
import com.nelseniq.model.ShopperProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShopperProductRepository extends JpaRepository<ShopperProduct, Long> {
    List<ShopperProduct> findByShopperId(Long shopperId);
}