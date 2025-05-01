package com.darwinfont.fexControl.domain.entities;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "client")
@Data
@Builder
public class ClientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Builder.Default
    private Integer externalId = 0;
    @Column(nullable = false)
    @Builder.Default
    private String name = "";
    @OneToMany(
            mappedBy = "client",
            cascade = CascadeType.ALL
    )
    private List<RequestEntity> requests = new ArrayList<>();
    @OneToMany(
            mappedBy = "client",
            cascade = CascadeType.ALL
    )
    private List<CityEntity> cities = new ArrayList<>();
}
