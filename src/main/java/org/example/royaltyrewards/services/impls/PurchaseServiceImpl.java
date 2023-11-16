package org.example.royaltyrewards.services.impls;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.royaltyrewards.dtos.PurchaseDto;
import org.example.royaltyrewards.dtos.PurchaseRequestDto;
import org.example.royaltyrewards.dtos.PurchaseResponseDto;
import org.example.royaltyrewards.entities.Product;
import org.example.royaltyrewards.entities.Purchase;
import org.example.royaltyrewards.entities.User;
import org.example.royaltyrewards.repositories.PurchaseRepository;
import org.example.royaltyrewards.services.PointRedemptionService;
import org.example.royaltyrewards.services.ProductService;
import org.example.royaltyrewards.services.PurchaseService;
import org.example.royaltyrewards.services.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PurchaseServiceImpl implements PurchaseService {
    private final ProductService productService;
    private final UserService userService;
    private final PurchaseRepository purchaseRepository;
    private final PointRedemptionService pointRedemptionService;

    @Override
    @Transactional
    public PurchaseResponseDto createPurchase(PurchaseRequestDto payload) throws Exception {
        User currentUser = userService.getCurrentUser();
        List<Product> products = productService.getProductsByIds(payload.getProductIds());
        double totalPrice = calculatePrice(products);
        int pointsEarned = calculatePointsEarned(products);

        if (payload.getPointsToRedeem() != null) {
            if (currentUser.getPointsBalance() < payload.getPointsToRedeem()) {
                throw new Exception("You current points are not up to the points you want to redeem");
            }

            currentUser.setPointsBalance(currentUser.getPointsBalance() - payload.getPointsToRedeem());
            userService.save(currentUser);
            totalPrice -= convertPointsToPrice(payload.getPointsToRedeem());
        }

        currentUser.setPointsBalance(currentUser.getPointsBalance() + pointsEarned);
        userService.save(currentUser);


        Purchase purchase = new Purchase(totalPrice, products, currentUser);
        purchase.setPointsEarned(pointsEarned);
        purchase = purchaseRepository.save(purchase);

        if (payload.getPointsToRedeem() != null) {
            pointRedemptionService.savePurchasePointRedemption(purchase, payload.getPointsToRedeem());
        }

        return PurchaseResponseDto.buildFromEntity(purchase);
    }

    private Double convertPointsToPrice(int points) {
        double POINT_TO_PRICE_RATE = 100;
        return points / POINT_TO_PRICE_RATE;
    }

    private int calculatePointsEarned(List<Product> products) {
        return products.stream().map(Product::getPointsToBeAwarded).reduce(Integer::sum).orElse(0);
    }

    private double calculatePrice(List<Product> products) {
        return products.stream().map(Product::getPrice).reduce(Double::sum).orElse(0D);
    }


    @Override
    public List<PurchaseDto> getCurrentUserPurchases() {
        String currentUserEmail = userService.getCurrentUserEmail();
        return purchaseRepository.findAllByCreatedBy(currentUserEmail)
                .stream().map(PurchaseDto::buildFromEntity).toList();
    }
}
