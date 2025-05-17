package com.darwinfont.fexControl.service.part;

import com.darwinfont.fexControl.domain.dto.FilterDto;
import com.darwinfont.fexControl.domain.dto.PageDto;
import com.darwinfont.fexControl.domain.dto.part.PartCreateDto;
import com.darwinfont.fexControl.domain.dto.part.PartUpdateDto;
import com.darwinfont.fexControl.domain.entities.PartEntity;
import com.darwinfont.fexControl.domain.mapper.PageMapper;
import com.darwinfont.fexControl.domain.mapper.PartMapper;
import com.darwinfont.fexControl.domain.repository.PartRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@Slf4j
public class PartServiceImp implements PartService {
    private final PartRepository partRepository;
    public PartServiceImp(PartRepository partRepository){
        this.partRepository = partRepository;
    }

    @Override
    public PartEntity addPart(PartCreateDto dto) {
        PartEntity part = PartMapper.entityFromDto(dto);
        return partRepository.save(part);
    }

    @Override
    public PartEntity loadById(Integer id) {
        return partRepository.findById(id).orElseThrow();
    }

    @Override
    public PageDto<PartEntity> loadParts(FilterDto filters) {
//        Page<PartEntity> rsl =  partRepository.findAll((Root<PartEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
//           List<Predicate> predicates = new ArrayList<>();
//
//           if(Objects.nonNull(filters.getClientName())){
//               predicates.add(criteriaBuilder.like(root.get("clientName").as(String.class), "%" + filters.getClientName() + "%"));
//           }
//           if (Objects.nonNull(filters.getRequested())){
//               predicates.add(criteriaBuilder.equal(root.get("requested"), filters.getRequested()));
//           }
//           if (Objects.nonNull(filters.getCityName())){
//               predicates.add(criteriaBuilder.like(root.get("cityName").as(String.class), "%" + filters.getCityName() + "%"));
//           }
//           if (Objects.nonNull(filters.getStage())) {
//               predicates.add(criteriaBuilder.like(root.get("stage").as(String.class), "%" + filters.getStage() + "%"));
//           }
//           if (Objects.nonNull(filters.getNestName())){
//               predicates.add(criteriaBuilder.like(root.get("nestName").as(String.class), "%" + filters.getNestName() + "%"));
//           }
//           if (Objects.nonNull(filters.getNestUrl())){
//               predicates.add(criteriaBuilder.like(root.get("nestUrl").as(String.class), "%" + filters.getNestUrl() + "%"));
//           }
//
//           if (predicates.isEmpty()){
//               return criteriaBuilder.conjunction();
//           }
//
//            return criteriaBuilder.or(predicates.toArray(new Predicate[predicates.size()]));
//        }, Pageable.unpaged());

        return null; //PageMapper.toPageDto(rsl);
    }

    @Override
    public void removeParts(List<Integer> ids) {
        partRepository.deleteAllById(ids);
    }

    @Override
    public void updatePart(Integer id, PartUpdateDto dto) {
//        PartEntity part = PartMapper.entityFromDto(dto);
//        part.setId(id);
//
//        partRepository.save(part);
    }

    @Override
    public List<PartEntity> loadAll() {
        return partRepository.findAll();
    }
}
