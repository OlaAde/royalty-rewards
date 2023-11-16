package org.example.royaltyrewards.controllers;

import lombok.RequiredArgsConstructor;
import org.example.royaltyrewards.dtos.*;
import org.example.royaltyrewards.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
@CrossOrigin(origins = {"http://localhost:3000"})
public class UserController {
    private final UserService userService;

    @GetMapping("/me")
    public ResponseEntity<UserDto> getCurrentUser() {
        try {
            return ResponseEntity.ok(UserDto.buildFromEntity(userService.getCurrentUser()));
        } catch (Exception e) {
            return ResponseEntity.of(ProblemDetail.forStatusAndDetail(HttpStatus.INTERNAL_SERVER_ERROR, e.getLocalizedMessage())).build();
        }
    }

}
