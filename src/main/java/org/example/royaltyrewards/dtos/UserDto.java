package org.example.royaltyrewards.dtos;

import lombok.Data;
import org.example.royaltyrewards.entities.User;
import org.modelmapper.ModelMapper;

import java.util.UUID;

@Data
public class UserDto {
    private UUID id;
    private String fullName, email, phoneNumber, address;
    private Integer pointsBalance;

    public static UserDto buildFromEntity(User user){
        return new ModelMapper().map(user, UserDto.class);
    }

}
