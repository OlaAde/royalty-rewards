package org.example.royaltyrewards.dtos;

import lombok.Data;
import org.example.royaltyrewards.entities.Reward;
import org.modelmapper.ModelMapper;

import java.util.UUID;

@Data
public class RewardDto {
    private UUID id;
    private String name;
    private Integer pointsNeeded;

    public static RewardDto buildFromEntity(Reward reward) {
        return new ModelMapper().map(reward, RewardDto.class);
    }
}
