package org.example.royaltyrewards.services;

import org.example.royaltyrewards.dtos.PurchaseDto;
import org.example.royaltyrewards.dtos.PurchaseRequestDto;
import org.example.royaltyrewards.dtos.PurchaseResponseDto;

import java.util.List;

public interface PurchaseService {

    PurchaseResponseDto createPurchase(PurchaseRequestDto payload) throws Exception;

    List<PurchaseDto> getCurrentUserPurchases();
}
