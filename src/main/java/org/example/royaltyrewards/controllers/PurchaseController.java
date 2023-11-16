package org.example.royaltyrewards.controllers;

import lombok.RequiredArgsConstructor;
import org.example.royaltyrewards.dtos.PurchaseDto;
import org.example.royaltyrewards.dtos.PurchaseResponseDto;
import org.example.royaltyrewards.dtos.PurchaseRequestDto;
import org.example.royaltyrewards.services.PurchaseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/purchases")
@RequiredArgsConstructor
@CrossOrigin(origins = {"http://localhost:3000"})
public class PurchaseController {
    private final PurchaseService purchaseService;

    @PostMapping
    public ResponseEntity<PurchaseResponseDto> createPurchase(@RequestBody PurchaseRequestDto payload) {
        try {
            PurchaseResponseDto responseDto = purchaseService.createPurchase(payload);
            return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.of(ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, e.getLocalizedMessage())).build();
        }
    }

    @GetMapping("/me")
    public ResponseEntity<List<PurchaseDto>> getCurrentUserPurchases() {
        try {
            List<PurchaseDto> responseDto = purchaseService.getCurrentUserPurchases();
            return ResponseEntity.ok(responseDto);
        } catch (Exception e) {
            return ResponseEntity.of(ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, e.getLocalizedMessage())).build();
        }
    }

}
