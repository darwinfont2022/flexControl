package com.darwinfont.fexControl.domain.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity(name = "part_stage")
public class PartStageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private PartProgressState state; // PLANEADA, CORTADA, etc.

    private int producedQuantity;
    private int deadQuantity;
    private String causeOfDeath;

    private String operatorName;

    @UpdateTimestamp
    private LocalDateTime timestamp;

    @ManyToOne
    private PartEntity part;
}
