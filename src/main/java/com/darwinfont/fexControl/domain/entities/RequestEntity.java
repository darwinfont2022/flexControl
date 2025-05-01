package com.darwinfont.fexControl.domain.entities;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity(name = "request")
@Data
@Builder
public class RequestEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Builder.Default
    private String externalId = "";

    @Column(nullable = false)
    @Builder.Default
    private Integer number = 0; // Número del pedido

    @ManyToOne
    private ClientEntity client;

    @OneToMany(
            mappedBy = "requests",
            cascade = CascadeType.ALL
    )
    private List<WorksiteEntity> worksites = new ArrayList<>();

    @CreatedDate
    private Date createAt;
    @UpdateTimestamp
    private Date updateAt;
}
