package org.example.royaltyrewards.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "purchases")
@Getter
@Setter
@NoArgsConstructor
public class Purchase extends AuditEntity {
    @Id
    @Column(nullable = false)
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @Column(nullable = false)
    private Double price;

    @Column(nullable = false)
    @ManyToMany
    private List<Product> products;

    @ManyToOne(optional = false)
    private User user;

    @Column(name = "points_earned")
    private Integer pointsEarned;

    public Purchase(Double price, List<Product> products, User user) {
        this.price = price;
        this.products = products;
        this.user = user;
    }
}