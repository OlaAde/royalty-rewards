package org.example.royaltyrewards.dtos;

import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class PurchaseRequestDto {
    private List<UUID> productIds;
    private Integer pointsToRedeem;
}
