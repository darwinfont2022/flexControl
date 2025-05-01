package com.darwinfont.fexControl.domain.repository;

import com.darwinfont.fexControl.domain.entities.WorksiteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorksiteRepository extends JpaRepository<WorksiteEntity, Long> {
}
