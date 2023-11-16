package org.example.royaltyrewards.services;

import org.example.royaltyrewards.dtos.PointRedemptionDto;
import org.example.royaltyrewards.dtos.PointRedemptionPayload;
import org.example.royaltyrewards.entities.Purchase;

import java.util.List;

public interface PointRedemptionService {
    List<PointRedemptionDto> getPointRedemptions();

    PointRedemptionDto savePurchasePointRedemption(Purchase purchase, int points);

    PointRedemptionDto redeemPoints(PointRedemptionPayload payload) throws Exception;
}
