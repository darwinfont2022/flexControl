package com.darwinfont.fexControl.domain.dto.worksite;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class WorksiteCreateDto {
    private String name = "";
    private List<String> stages;
}
