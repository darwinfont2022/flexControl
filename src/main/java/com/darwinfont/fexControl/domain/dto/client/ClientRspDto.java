package com.darwinfont.fexControl.domain.dto.client;

import com.darwinfont.fexControl.domain.dto.city.CityRspDto;
import com.darwinfont.fexControl.domain.dto.request.RequestRspDto;
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
