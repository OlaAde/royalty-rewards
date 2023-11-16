package org.example.royaltyrewards.dtos;

import lombok.Data;
import org.example.royaltyrewards.entities.Product;
import org.modelmapper.ModelMapper;

import java.util.UUID;

@Data
public class ProductDto {
    private UUID id;
    private String name, image, price;
    private Integer pointsToBeAwarded;

    public static ProductDto buildFromEntity(Product product) {
        return new ModelMapper().map(product, ProductDto.class);
    }
}
