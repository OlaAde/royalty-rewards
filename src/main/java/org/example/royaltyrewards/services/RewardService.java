package org.example.royaltyrewards.services;

import org.example.royaltyrewards.dtos.RewardDto;
import org.example.royaltyrewards.entities.Reward;

import java.util.List;
import java.util.UUID;

public interface RewardService {
    List<RewardDto> getRewards();

    Reward getReward(UUID id) throws Exception;
}
