package com.darwinfont.fexControl.domain.repository;

import com.darwinfont.fexControl.domain.entities.PartEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartRepository extends JpaRepository<PartEntity, Integer> {
    Page<PartEntity> findAll(Specification<PartEntity> specification, Pageable pageable);
}
