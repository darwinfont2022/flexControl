package com.darwinfont.fexControl.domain.dto;

import com.darwinfont.fexControl.domain.entities.CityEntity;
import com.darwinfont.fexControl.domain.entities.RequestEntity;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClientRspDto {
    private Long id;
    private Integer externalId = 0;
    private String name = "";
    private List<RequestRspDto> requests;
    private List<CityRspDto> cities;
}
