package com.darwinfont.fexControl.domain.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NestDto {
    private String name;
    private String url;
}
