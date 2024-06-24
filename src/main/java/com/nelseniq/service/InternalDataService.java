package com.nelseniq.service;

import com.nelseniq.model.ProductMetadata;
import com.nelseniq.model.ShopperProduct;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class InternalDataService {

    private RestTemplate restTemplate;

    public List<ShopperProduct> fetchShopperProducts(Long shopperId) {
        // Replace with the actual URL of the internal service
        // TODO: Make it GRPC call instead since it is internal call
        String url = "http://internal-service/shopper-products?shopperId=" + shopperId;
        ShopperProduct[] shopperProducts = restTemplate.getForObject(url, ShopperProduct[].class);
        assert shopperProducts != null;
        return Arrays.asList(shopperProducts);
    }

    public ProductMetadata fetchProductMetadata(Long productId) {
        // Replace with the actual URL of the internal service
        String url = "http://internal-service/product-metadata?productId=" + productId;
        return restTemplate.getForObject(url, ProductMetadata.class);
    }
}
