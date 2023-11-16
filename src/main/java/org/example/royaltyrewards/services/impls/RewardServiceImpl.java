package org.example.royaltyrewards.services.impls;

import lombok.RequiredArgsConstructor;
import org.example.royaltyrewards.dtos.ProductDto;
import org.example.royaltyrewards.dtos.RewardDto;
import org.example.royaltyrewards.entities.Reward;
import org.example.royaltyrewards.repositories.ProductRepository;
import org.example.royaltyrewards.repositories.RewardRepository;
import org.example.royaltyrewards.services.ProductService;
import org.example.royaltyrewards.services.RewardService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RewardServiceImpl implements RewardService {
    private final RewardRepository rewardRepository;

    @Override
    public List<RewardDto> getRewards() {
        return rewardRepository.findAll().stream().map(RewardDto::buildFromEntity).toList();
    }

    @Override
    public Reward getReward(UUID id) throws Exception {
        return rewardRepository.findById(id).orElseThrow(() -> new Exception("Reward not found"));
    }
}
