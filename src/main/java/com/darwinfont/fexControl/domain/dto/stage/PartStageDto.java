package com.darwinfont.fexControl.domain.dto.stage;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PartStageDto {
    private Long id;
    private String state; // PLANEADA, CORTADA, etc.
    private int produced;
    private int dead;
    private String causeOfDeath;
    private String operatorName;
}
