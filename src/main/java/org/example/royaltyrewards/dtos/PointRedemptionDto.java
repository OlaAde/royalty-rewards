package org.example.royaltyrewards.dtos;

import lombok.Data;
import org.example.royaltyrewards.entities.PointRedemption;
import org.example.royaltyrewards.entities.PointRedemptionType;
import org.modelmapper.ModelMapper;

import java.util.UUID;

@Data
public class PointRedemptionDto {
    private UUID id;
    private PointRedemptionType type;
    private Integer points;

    public static PointRedemptionDto buildFromEntity(PointRedemption pointRedemption) {
        return new ModelMapper().map(pointRedemption, PointRedemptionDto.class);
    }
}
