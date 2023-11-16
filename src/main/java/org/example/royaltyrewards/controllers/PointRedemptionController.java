package org.example.royaltyrewards.controllers;

import lombok.RequiredArgsConstructor;
import org.example.royaltyrewards.dtos.PointRedemptionDto;
import org.example.royaltyrewards.dtos.PointRedemptionPayload;
import org.example.royaltyrewards.services.PointRedemptionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/point-redemptions")
@RequiredArgsConstructor
@CrossOrigin(origins = {"http://localhost:3000"})
public class PointRedemptionController {
    private final PointRedemptionService pointRedemptionService;

    @GetMapping
    public ResponseEntity<PointRedemptionDto> redeemPoints(@RequestBody PointRedemptionPayload payload) {
        try {
            PointRedemptionDto responseDto = pointRedemptionService.redeemPoints(payload);

            return ResponseEntity.ok(responseDto);
        } catch (Exception e) {
            return ResponseEntity.of(ProblemDetail.forStatusAndDetail(HttpStatus.INTERNAL_SERVER_ERROR, e.getLocalizedMessage())).build();
        }
    }

    @GetMapping("/me")
    public ResponseEntity<List<PointRedemptionDto>> getPointRedemptions() {
        try {
            List<PointRedemptionDto> responseDto = pointRedemptionService.getPointRedemptions();

            return ResponseEntity.ok(responseDto);
        } catch (Exception e) {
            return ResponseEntity.of(ProblemDetail.forStatusAndDetail(HttpStatus.INTERNAL_SERVER_ERROR, e.getLocalizedMessage())).build();
        }
    }
}
