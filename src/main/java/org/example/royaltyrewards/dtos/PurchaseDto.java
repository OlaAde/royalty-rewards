package org.example.royaltyrewards.dtos;

import lombok.Data;
import org.example.royaltyrewards.entities.Purchase;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.UUID;

@Data
public class PurchaseDto {
    private UUID id;
    private Double price;
    private Integer pointsEarned;
    private List<ProductDto> products;

    public static PurchaseDto buildFromEntity(Purchase purchase) {
        PurchaseDto purchaseDto = new ModelMapper().map(purchase, PurchaseDto.class);
        purchaseDto.setProducts(purchase.getProducts().stream().map(ProductDto::buildFromEntity).toList());
        return purchaseDto;
    }
}
