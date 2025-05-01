package com.darwinfont.fexControl.domain.entities;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "stage")
@Data
@Builder
public class StageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Builder.Default
    private String name = "";

    @ManyToOne
    private WorksiteEntity worksite;

    @OneToMany(mappedBy = "stage", cascade = CascadeType.ALL)
    private List<PartEntity> parts = new ArrayList<>();
}
