package com.darwinfont.fexControl.domain.dto.city;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CityRspDto {
    private String externalId;
    private String name;
}
