package com.darwinfont.fexControl.domain.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestCreateDto {
    private String externalId = "";

    private Integer number = 0; // Número del pedido

}
