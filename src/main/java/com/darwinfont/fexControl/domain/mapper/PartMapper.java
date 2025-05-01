package com.darwinfont.fexControl.domain.mapper;

import com.darwinfont.fexControl.domain.dto.PartCreateDto;
import com.darwinfont.fexControl.domain.entities.PartEntity;

import java.util.List;

public class PartMapper {
    public static List<PartCreateDto> pratList(List<PartEntity> partDtoList) {
        return partDtoList.stream().map(PartMapper::dtoFromEntity).toList();
    }

    public static PartEntity entityFromDto(PartCreateDto dto) {
        return PartEntity.builder()
//                .stage(dto.getStage())
//                .length(dto.getLength())
//                .width(dto.getWidth())
//                .weight(dto.getWeight())
//                .position(dto.getPosition())
//                .quantity(dto.getQuantity())
//                .thickness(dto.getThickness())
//                .imageUrl(dto.getImageUrl())
//                .currentStage(dto.getCurrentStage())
//                .nestName(dto.getNestName())
//                .nestUrl(dto.getNestUrl())
//                .createdAt(new Date())
//                .updateAt(new Date())
                .build();
    }

    public static PartCreateDto dtoFromEntity(PartEntity entity) {
//        return PartCreateDto.builder()
//                .id(entity.getId())
//                .requested(entity.getRequested())
//                .clientName(entity.getClientName())
//                .cityName(entity.getCityName())
//                .stage(entity.getStage())
//                .length(entity.getLength())
//                .width(entity.getWidth())
//                .weight(entity.getWeight())
//                .position(entity.getPosition())
//                .quantity(entity.getQuantity())
//                .thickness(entity.getThickness())
//                .imageUrl(entity.getImageUrl())
//                .currentStage(entity.getCurrentStage())
//                .nestName(entity.getNestName())
//                .nestUrl(entity.getNestUrl())
//                .createdAt(entity.getCreatedAt())
//                .updateAt(entity.getUpdateAt())
//                .build();
        return null;
    }
}