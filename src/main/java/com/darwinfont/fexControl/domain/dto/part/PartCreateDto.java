package com.darwinfont.fexControl.domain.dto.part;

import com.darwinfont.fexControl.domain.dto.nest.NestDto;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class PartCreateDto {
    // --- CLIENTE ---
    private String clientExternalId;
    private String clientName;

    // --- PEDIDO (REQUEST) ---
    private String requestCode;
    private String requestDescription;

    // --- OBRA / CIUDAD ---
    private String cityName;
    private String projectName;

    // --- ETAPA ---
    private String stageName;

    // --- DATOS DE LA PIEZA ---
    private String partName;
    private String position;
    private BigDecimal length;
    private BigDecimal width;
    private BigDecimal thickness;
    private BigDecimal weight;
    private Integer quantity;
    private Integer plannedQuantity;
    private String imageUrl;

    // --- NESTS ASOCIADOS ---
    private List<NestDto> nests;

    private String initialStage;
}
