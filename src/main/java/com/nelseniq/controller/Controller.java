package com.nelseniq.controller;

import com.nelseniq.dto.ProductResponseDTO;
import com.nelseniq.service.PersonalizedDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/data")
public class Controller {

    @Autowired
    private PersonalizedDataService service;

    public Controller(PersonalizedDataService service) {
        this.service = service;
    }

    @GetMapping("/shopper-products")
    public List<ProductResponseDTO> getShopperProducts(
            @RequestParam Long shopperId,
            @RequestParam(required = false) String category,
            @RequestParam(required = false) String brand,
            @RequestParam(defaultValue = "10") int limit) {

        return service.getPersonalizedData(shopperId, category, brand, limit);
    }
}
