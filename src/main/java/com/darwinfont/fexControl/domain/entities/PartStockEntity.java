package com.darwinfont.fexControl.domain.entities;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Entity(name = "part_stock")
@Data
@Builder
public class PartStockEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private PartEntity part;

    @Enumerated(EnumType.STRING)
    private PartProgressState state;

    @Column(nullable = false)
    @Builder.Default
    private Integer quantity = 0;
}
