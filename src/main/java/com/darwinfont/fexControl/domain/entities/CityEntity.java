package com.darwinfont.fexControl.domain.entities;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Entity(name = "city")
@Data
@Builder
public class CityEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    @Builder.Default
    private String name = "";
    @ManyToOne
    private ClientEntity client;
}
