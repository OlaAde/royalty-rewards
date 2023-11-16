package org.example.royaltyrewards.dtos;

import lombok.Data;

@Data
public class UserRegistrationPayload {
    private String email, fullName, phoneNumber, address, password, confirmPassword;
}
