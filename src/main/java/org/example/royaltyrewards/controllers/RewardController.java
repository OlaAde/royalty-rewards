package org.example.royaltyrewards.controllers;

import lombok.RequiredArgsConstructor;
import org.example.royaltyrewards.dtos.RewardDto;
import org.example.royaltyrewards.services.RewardService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/rewards")
@RequiredArgsConstructor
@CrossOrigin(origins = {"http://localhost:3000"})
public class RewardController {
    private final RewardService rewardService;

    @GetMapping
    public ResponseEntity<List<RewardDto>> getRewards() {
        try {
            List<RewardDto> responseDto = rewardService.getRewards();
            return ResponseEntity.ok(responseDto);
        } catch (Exception e) {
            return ResponseEntity.of(ProblemDetail.forStatusAndDetail(HttpStatus.INTERNAL_SERVER_ERROR, e.getLocalizedMessage())).build();
        }
    }
}
