package com.darwinfont.fexControl.domain.repository;

import com.darwinfont.fexControl.domain.entities.PartStockEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartStockRepository extends JpaRepository<PartStockEntity, Long> {
}
