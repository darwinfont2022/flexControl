package com.darwinfont.fexControl.domain.repository;

import com.darwinfont.fexControl.domain.entities.NestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NestRepository extends JpaRepository<NestEntity, Long> {
}
