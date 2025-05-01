package com.darwinfont.fexControl.domain.mapper;

import com.darwinfont.fexControl.domain.dto.PageDto;
import com.darwinfont.fexControl.domain.entities.PartEntity;
import org.springframework.data.domain.Page;

public class PageMapper {
    public static PageDto<PartEntity> toPageDto(Page<PartEntity> page) {
        PageDto<PartEntity> dto = new PageDto<>();

        dto.setEmpty(page.isEmpty());
        dto.setSize(page.getSize());
        dto.setPages(page.getTotalPages());
        dto.setTotalElements(page.getNumberOfElements());

        dto.setItems(page.stream().toList());

        return dto;
    }
}
