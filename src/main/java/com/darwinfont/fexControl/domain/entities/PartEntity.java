package com.darwinfont.fexControl.domain.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity(name = "part")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PartEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(
            nullable = false,
            precision = 10,
            scale = 2
    )
    @Builder.Default
    private BigDecimal length = BigDecimal.valueOf(0.0);
    @Column(
            nullable = false,
            precision = 10,
            scale = 2
    )
    @Builder.Default
    private BigDecimal width = BigDecimal.valueOf(0.0);

    @Column(
            nullable = false,
            precision = 10,
            scale = 2
    )
    @Builder.Default
    private BigDecimal weight = BigDecimal.valueOf(0.0);

    @Column(nullable = false)
    @Builder.Default
    private String position = "";

    @Column(nullable = false)
    @Builder.Default
    private Integer quantity = 1;

    @Column(
            nullable = false,
            precision = 10,
            scale = 2
    )
    @Builder.Default
    private BigDecimal thickness = BigDecimal.valueOf(0.0);

    @Column(nullable = false)
    private String imageUrl;

    // Cantidad planificada de esta pieza
    @Column(nullable = false)
    @Builder.Default
    private int plannedQuantity = 1;

    @Enumerated(EnumType.STRING)
    @Builder.Default
    private PartProgressState currentStage = PartProgressState.CUTTING;

    @ManyToMany
    @JoinTable(
            name = "part_nest",
            joinColumns = @JoinColumn(name = "part_id"),
            inverseJoinColumns = @JoinColumn(name = "nest_id")
    )
    private List<NestEntity> nests = new ArrayList<>();

    // Etapa de la obra
    @ManyToOne
    private StageEntity stage;

    // Historial de producción por estado (producción, muertes, operador, causa, etc.)
    @OneToMany(
            mappedBy = "part",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<PartStageEntity> states = new ArrayList<>();

    // Stock actual por etapa del proceso
    @OneToMany(mappedBy = "part", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PartStockEntity> stockByState = new ArrayList<>();

    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date createdAt;
    @Temporal(TemporalType.TIMESTAMP)
    @UpdateTimestamp
    private Date updateAt;
}