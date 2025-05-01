package com.darwinfont.fexControl.domain.entities;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity(name = "worksite")
@Data
@Builder
public class WorksiteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Builder.Default
    private String name = "";

    @ManyToOne
    private RequestEntity requests;

    @ManyToOne
    private CityEntity city;

    @OneToMany()
    private List<StageEntity> stages = new ArrayList<>();

    @CreatedDate
    private Date createAt;
    @UpdateTimestamp
    private Date updateAt;
}
