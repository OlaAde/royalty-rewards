package org.example.royaltyrewards.dtos;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.example.royaltyrewards.entities.User;
import org.modelmapper.ModelMapper;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class AuthResponseDto extends UserDto {
    private String token;

    public static AuthResponseDto buildFromEntity(User user, String token) {
        AuthResponseDto authResponseDto = new ModelMapper().map(user, AuthResponseDto.class);
        authResponseDto.setToken(token);
        return authResponseDto;
    }
}
