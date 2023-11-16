package org.example.royaltyrewards.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Entity
@Table(name = "rewards")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Reward {
    @Id
    @Column(nullable = false)
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @Column(name = "points_needed", nullable = false)
    private Integer pointsNeeded;

    @Column(nullable = false)
    private String name;
}
