package org.example.royaltyrewards.services.impls;

import lombok.RequiredArgsConstructor;
import org.example.royaltyrewards.dtos.ProductDto;
import org.example.royaltyrewards.entities.Product;
import org.example.royaltyrewards.repositories.ProductRepository;
import org.example.royaltyrewards.services.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public List<ProductDto> getProducts(String name) {
        if (name != null && !name.isBlank()) {
            return productRepository.findAllByNameLikeIgnoreCase(name).stream().map(ProductDto::buildFromEntity).toList();
        }
        return productRepository.findAll().stream().map(ProductDto::buildFromEntity).toList();
    }

    @Override
    public List<Product> getProductsByIds(List<UUID> productIds) {
        return productRepository.findAllByIdIn(productIds);
    }
}
