package com.darwinfont.fexControl.domain.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class PartUpdateDto {
    private String partName;
    private String position;
    private BigDecimal length;
    private BigDecimal width;
    private BigDecimal thickness;
    private BigDecimal weight;
    private Integer quantity;
    private Integer plannedQuantity;
    private String imageUrl;
}
