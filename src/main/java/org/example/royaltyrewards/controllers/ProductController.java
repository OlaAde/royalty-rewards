package org.example.royaltyrewards.controllers;

import lombok.RequiredArgsConstructor;
import org.example.royaltyrewards.dtos.ProductDto;
import org.example.royaltyrewards.services.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
@CrossOrigin(origins = {"http://localhost:3000"})
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductDto>> getProducts(@RequestParam(required = false) String name) {
        return ResponseEntity.ok(productService.getProducts(name));
    }
}
