package org.example.royaltyrewards.services.impls;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.royaltyrewards.dtos.PointRedemptionDto;
import org.example.royaltyrewards.dtos.PointRedemptionPayload;
import org.example.royaltyrewards.entities.*;
import org.example.royaltyrewards.repositories.PointRedemptionRepository;
import org.example.royaltyrewards.services.PointRedemptionService;
import org.example.royaltyrewards.services.RewardService;
import org.example.royaltyrewards.services.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PointRedemptionServiceImpl implements PointRedemptionService {
    private final PointRedemptionRepository pointRedemptionRepository;
    private final UserService userService;
    private final RewardService rewardService;

    @Override
    public List<PointRedemptionDto> getPointRedemptions() {
        String currentUserEmail = userService.getCurrentUserEmail();
        return pointRedemptionRepository.findAllByCreatedBy(currentUserEmail).stream().map(PointRedemptionDto::buildFromEntity).toList();
    }

    @Override
    public PointRedemptionDto savePurchasePointRedemption(Purchase purchase, int points) {
        PointRedemption pointRedemption = new PointRedemption();
        pointRedemption.setPurchase(purchase);
        pointRedemption.setPoints(points);
        pointRedemption.setType(PointRedemptionType.DISCOUNT);
        pointRedemption = pointRedemptionRepository.save(pointRedemption);
        return PointRedemptionDto.buildFromEntity(pointRedemption);
    }

    @Override
    @Transactional
    public PointRedemptionDto redeemPoints(PointRedemptionPayload payload) throws Exception {
        User currentUser = userService.getCurrentUser();
        Reward reward = rewardService.getReward(payload.getRewardId());

        if (currentUser.getPointsBalance() < reward.getPointsNeeded()) {
            throw new Exception("You don't have enough points to redeem this item");
        }

        currentUser.setPointsBalance(currentUser.getPointsBalance() - reward.getPointsNeeded());
        userService.save(currentUser);

        PointRedemption pointRedemption = new PointRedemption();
        pointRedemption.setReward(reward);
        pointRedemption.setPoints(reward.getPointsNeeded());
        pointRedemption.setType(PointRedemptionType.FREE_PRODUCT);
        pointRedemption = pointRedemptionRepository.save(pointRedemption);

        return PointRedemptionDto.buildFromEntity(pointRedemption);
    }
}
