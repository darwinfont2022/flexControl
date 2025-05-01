package com.darwinfont.fexControl.domain.dto;

import com.darwinfont.fexControl.domain.entities.PartProgressState;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FilterDto {
    private Integer id;
    private Integer requested;
    private String clientName;
    private String cityName;
    private String stage;
    private Double length;
    private Double width;
    private Double weight;
    private String position;
    private Integer quantity;
    private Double thickness;
    private String imageUrl;
    private PartProgressState currentStage;
    private String nestName;
    private String nestUrl;
    private Date createdAt;
    private Date updateAt;
}
