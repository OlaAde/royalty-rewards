package org.example.royaltyrewards.services.impls;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.royaltyrewards.dtos.AuthResponseDto;
import org.example.royaltyrewards.dtos.UserLoginPayload;
import org.example.royaltyrewards.dtos.UserRegistrationPayload;
import org.example.royaltyrewards.entities.User;
import org.example.royaltyrewards.services.AuthService;
import org.example.royaltyrewards.services.JwtService;
import org.example.royaltyrewards.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final PasswordEncoder passwordEncoder;
    private final UserService userService;
    private final JwtService jwtService;
    private final UserDetailsService userDetailsService;
    private final AuthenticationManager authenticationManager;

    @Override
    @Transactional
    public AuthResponseDto registerUser(UserRegistrationPayload payload) {
        User user = new ModelMapper().map(payload, User.class);
        user.setPassword(passwordEncoder.encode(payload.getPassword()));
        user = userService.save(user);
        String token = jwtService.generateToken(user.getEmail());

        return AuthResponseDto.buildFromEntity(user, token);
    }

    @Override
    public AuthResponseDto loginUser(UserLoginPayload payload) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(payload.getEmail());

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, payload.getPassword());

        Authentication authentication = authenticationManager.authenticate(authenticationToken);

        if (!authentication.isAuthenticated()) {
            throw new BadCredentialsException("Invalid credentials.");
        }

        String token = jwtService.generateToken(userDetails.getUsername());
        User user = userService.findByEmail(userDetails.getUsername()).orElseThrow(() -> new BadCredentialsException("User not found"));

        return AuthResponseDto.buildFromEntity(user, token);
    }
}
