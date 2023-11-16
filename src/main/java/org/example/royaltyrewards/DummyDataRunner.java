package org.example.royaltyrewards;

import lombok.RequiredArgsConstructor;
import org.example.royaltyrewards.entities.Product;
import org.example.royaltyrewards.entities.Reward;
import org.example.royaltyrewards.repositories.ProductRepository;
import org.example.royaltyrewards.repositories.RewardRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class DummyDataRunner implements CommandLineRunner {
    private final ProductRepository productRepository;
    private final RewardRepository rewardRepository;


    @Override
    public void run(String... args) throws Exception {
        insertProducts();
        insertRewards();
    }

    private void insertProducts() {
        productRepository.save(new Product(UUID.randomUUID(), "Headphone", "https://images.unsplash.com/photo-1505740420928-5e560c06d30e?q=80&w=1470&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D", 19.99, 245));
        productRepository.save(new Product(UUID.randomUUID(), "Wristwatch", "https://images.unsplash.com/photo-1523275335684-37898b6baf30?q=80&w=1399&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D", 24.99, 245));
        productRepository.save(new Product(UUID.randomUUID(), "Sunglasses", "https://images.unsplash.com/photo-1572635196237-14b3f281503f?q=80&w=1480&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D", 455.99, 389));
        productRepository.save(new Product(UUID.randomUUID(), "Chair", "https://images.unsplash.com/photo-1503602642458-232111445657?q=80&w=1374&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D", 240.99, 432));
        productRepository.save(new Product(UUID.randomUUID(), "Toy Car", "https://images.unsplash.com/photo-1581235720704-06d3acfcb36f?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTF8fHByb2R1Y3R8ZW58MHx8MHx8fDI%3D", 74.99, 299));
        productRepository.save(new Product(UUID.randomUUID(), "Lipstick", "https://images.unsplash.com/photo-1586495777744-4413f21062fa?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8N3x8cHJvZHVjdHxlbnwwfHwwfHx8Mg%3D%3D", 24.99, 187));
        productRepository.save(new Product(UUID.randomUUID(), "Pepsi", "https://images.unsplash.com/photo-1553456558-aff63285bdd1?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8OXx8cHJvZHVjdHxlbnwwfHwwfHx8Mg%3D%3D", 474.99, 326));
        productRepository.save(new Product(UUID.randomUUID(), "Speaker", "https://images.unsplash.com/photo-1543512214-318c7553f230?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTZ8fHByb2R1Y3R8ZW58MHx8MHx8fDI%3D", 31.99, 158));
        productRepository.save(new Product(UUID.randomUUID(), "Thermos", "https://images.unsplash.com/photo-1602143407151-7111542de6e8?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTJ8fHByb2R1Y3R8ZW58MHx8MHx8fDI%3D", 68.99, 172));
        productRepository.save(new Product(UUID.randomUUID(), "Heels", "https://images.unsplash.com/photo-1543163521-1bf539c55dd2?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MTl8fHByb2R1Y3R8ZW58MHx8MHx8fDI%3D", 87.99, 311));
        productRepository.save(new Product(UUID.randomUUID(), "Bag", "https://images.unsplash.com/photo-1511556820780-d912e42b4980?w=500&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxzZWFyY2h8MjB8fHByb2R1Y3R8ZW58MHx8MHx8fDI%3D", 258.99, 425));
    }

    private void insertRewards() {
        rewardRepository.save(new Reward(UUID.randomUUID(), 300, "Free Meal"));
    }
}
