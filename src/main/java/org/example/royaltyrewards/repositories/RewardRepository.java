package org.example.royaltyrewards.repositories;

import org.example.royaltyrewards.entities.Reward;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RewardRepository extends JpaRepository<Reward, UUID> {

}
