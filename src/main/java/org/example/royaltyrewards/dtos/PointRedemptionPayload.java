package org.example.royaltyrewards.dtos;

import lombok.Data;

import java.util.UUID;

@Data
public class PointRedemptionPayload {
    private UUID rewardId;
}
