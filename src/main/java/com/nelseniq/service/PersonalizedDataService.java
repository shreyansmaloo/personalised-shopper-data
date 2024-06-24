package com.nelseniq.service;

import com.nelseniq.dto.ProductResponseDTO;
import com.nelseniq.model.ProductMetadata;
import com.nelseniq.model.ShopperProduct;
import com.nelseniq.repository.ProductMetadataRepository;
import com.nelseniq.repository.ShopperProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonalizedDataService {
    @Autowired
    private ProductMetadataRepository productMetadataRepository;

    @Autowired
    private ShopperProductRepository shopperProductRepository;

    @Autowired
    private InternalDataService internalDataService;

    public List<ProductResponseDTO> getPersonalizedData(Long shopperId, String category, String brand, int limit) {
        List<ProductResponseDTO> response = new ArrayList<>();

        List<ShopperProduct> shopperProducts = shopperProductRepository.findByShopperId(shopperId);

        if (shopperProducts.isEmpty()) {
            shopperProducts = internalDataService.fetchShopperProducts(shopperId);
            shopperProductRepository.saveAll(shopperProducts);
        }
        for (ShopperProduct shopperProduct : shopperProducts) {
            ProductMetadata metadata = productMetadataRepository.findById(shopperProduct.getProductId()).orElse(null);
            if (metadata == null) {
                metadata = internalDataService.fetchProductMetadata(shopperProduct.getProductId());
                if (metadata != null) {
                    productMetadataRepository.save(metadata);
                }
            }

            if (metadata != null &&
                    (category == null || metadata.getCategory().equals(category)) &&
                    (brand == null || metadata.getBrand().equals(brand))) {
                response.add(new ProductResponseDTO(shopperProduct, metadata));
            }
            if (response.size() >= limit) {
                break;
            }
        }

        return response;
    }
}
