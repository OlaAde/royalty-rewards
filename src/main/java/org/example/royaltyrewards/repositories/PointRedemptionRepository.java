package org.example.royaltyrewards.repositories;

import org.example.royaltyrewards.entities.PointRedemption;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface PointRedemptionRepository extends CrudRepository<PointRedemption, UUID> {
    List<PointRedemption> findAllByCreatedBy(String email);
}
