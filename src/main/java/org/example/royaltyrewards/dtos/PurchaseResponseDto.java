package org.example.royaltyrewards.dtos;

import lombok.Data;
import org.example.royaltyrewards.entities.Purchase;
import org.modelmapper.ModelMapper;

import java.util.UUID;

@Data
public class PurchaseResponseDto {
    private UUID id;
    private Double price;
    private Integer pointsEarned;


    public static PurchaseResponseDto buildFromEntity(Purchase purchase) {
        return new ModelMapper().map(purchase, PurchaseResponseDto.class);
    }
}
