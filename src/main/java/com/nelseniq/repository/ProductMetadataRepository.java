package com.nelseniq.repository;

import com.nelseniq.model.ProductMetadata;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductMetadataRepository extends JpaRepository<ProductMetadata, Long> {
}
