package org.example.royaltyrewards.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Entity
@Table(name = "point_redemptions")
@Getter
@Setter
public class PointRedemption extends AuditEntity {
    @Id
    @Column(nullable = false)
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private PointRedemptionType type;

    @ManyToOne
    private Reward reward;

    @Column(nullable = false)
    private Integer points;

    @ManyToOne
    private Purchase purchase;
}
