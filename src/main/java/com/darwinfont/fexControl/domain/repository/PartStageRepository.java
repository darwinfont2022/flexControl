package com.darwinfont.fexControl.domain.repository;

import com.darwinfont.fexControl.domain.entities.PartStageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartStageRepository extends JpaRepository<PartStageEntity, Long> {
}
