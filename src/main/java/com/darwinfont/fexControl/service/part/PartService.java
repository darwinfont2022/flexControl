package com.darwinfont.fexControl.service.part;

import com.darwinfont.fexControl.domain.dto.FilterDto;
import com.darwinfont.fexControl.domain.dto.PageDto;
import com.darwinfont.fexControl.domain.dto.part.PartCreateDto;
import com.darwinfont.fexControl.domain.dto.part.PartUpdateDto;
import com.darwinfont.fexControl.domain.entities.PartEntity;

import java.util.List;

public interface PartService {
    PartEntity addPart(PartCreateDto dto);
    PartEntity loadById(Integer id);
    PageDto<PartEntity> loadParts(FilterDto filters);
    void removeParts(List<Integer> ids);
    void updatePart(Integer id, PartUpdateDto dto);

    List<PartEntity> loadAll();
}
