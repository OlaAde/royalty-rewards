package org.example.royaltyrewards.repositories;

import org.example.royaltyrewards.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {
    List<Product> findAllByNameLikeIgnoreCase(String name);

    List<Product> findAllByIdIn(List<UUID> productIds);
}
