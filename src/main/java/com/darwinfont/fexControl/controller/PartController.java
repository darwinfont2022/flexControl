package com.darwinfont.fexControl.controller;

import com.darwinfont.fexControl.domain.dto.FilterDto;
import com.darwinfont.fexControl.domain.dto.part.PartCreateDto;
import com.darwinfont.fexControl.domain.dto.part.PartUpdateDto;
import com.darwinfont.fexControl.domain.entities.PartProgressState;
import com.darwinfont.fexControl.domain.mapper.PartMapper;
import com.darwinfont.fexControl.service.part.PartService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/part")
public class PartController {
    private final PartService partService;
    public PartController(PartService partService){
        this.partService = partService;
    }

    @PostMapping()
    private void savePart(@RequestBody() PartCreateDto partDto){
        partService.addPart(partDto);
    }

    @PutMapping("/{id}")
    private void updatePart(@PathVariable() Integer id, @RequestBody() PartUpdateDto partDto){
        partService.updatePart(id, partDto);
    }

    @GetMapping()
    private ResponseEntity<PartCreateDto> loadById(@RequestParam() Integer id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(PartMapper.dtoFromEntity(partService.loadById(id)));
    }

    @GetMapping("/all")
    private ResponseEntity<?> loadAll(){
        return ResponseEntity.status(HttpStatus.OK)
                .body(partService.loadAll());
    }

    @GetMapping("/filter")
    private ResponseEntity<?> loadParts(
            @RequestParam(required = false) Integer id,
            @RequestParam(required = false) Integer requested,
            @RequestParam(required = false) String clientName,
            @RequestParam(required = false) String cityName,
            @RequestParam(required = false) String stage,
            @RequestParam(required = false) Double length,
            @RequestParam(required = false) Double width,
            @RequestParam(required = false) Double weight,
            @RequestParam(required = false) String position,
            @RequestParam(required = false) Integer quantity,
            @RequestParam(required = false) Double thickness,
            @RequestParam(required = false) String imageUrl,
            @RequestParam(required = false) PartProgressState currentStage,
            @RequestParam(required = false) String nestName,
            @RequestParam(required = false) String nestUrl,
            @RequestParam(required = false) Date createdAt,
            @RequestParam(required = false) Date updateAt
    ){
        FilterDto filters = FilterDto.builder()
                .id(id)
                .requested(requested)
                .clientName(clientName)
                .cityName(cityName)
                .stage(stage)
                .length(length)
                .width(width)
                .weight(weight)
                .position(position)
                .quantity(quantity)
                .thickness(thickness)
                .imageUrl(imageUrl)
                .currentStage(currentStage)
                .nestName(nestName)
                .nestUrl(nestUrl)
                .createdAt(createdAt)
                .updateAt(updateAt)
                .build();
        return ResponseEntity.status(HttpStatus.OK)
                .body(partService.loadParts(filters));
    }
}
