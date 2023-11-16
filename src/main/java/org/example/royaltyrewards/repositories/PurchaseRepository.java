package org.example.royaltyrewards.repositories;

import org.example.royaltyrewards.entities.Purchase;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface PurchaseRepository extends CrudRepository<Purchase, UUID> {
    List<Purchase> findAllByCreatedBy(String email);
}
