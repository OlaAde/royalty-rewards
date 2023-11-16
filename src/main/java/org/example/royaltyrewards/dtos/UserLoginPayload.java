package org.example.royaltyrewards.dtos;

import lombok.Data;

@Data
public class UserLoginPayload {
    private String email, password;
}
