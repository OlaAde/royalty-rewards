package org.example.royaltyrewards.services;

import org.example.royaltyrewards.dtos.ProductDto;
import org.example.royaltyrewards.entities.Product;

import java.util.List;
import java.util.UUID;

public interface ProductService {
    List<ProductDto> getProducts(String name);

    List<Product> getProductsByIds(List<UUID> productIds);
}
