package org.example.royaltyrewards.services;

import org.example.royaltyrewards.dtos.AuthResponseDto;
import org.example.royaltyrewards.dtos.UserLoginPayload;
import org.example.royaltyrewards.dtos.UserRegistrationPayload;
import org.example.royaltyrewards.exceptions.InvalidPayloadException;

public interface AuthService {

    AuthResponseDto registerUser(UserRegistrationPayload payload) throws InvalidPayloadException;

    AuthResponseDto loginUser(UserLoginPayload payload) throws InvalidPayloadException;
}
