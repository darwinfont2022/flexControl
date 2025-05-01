
package com.darwinfont.fexControl.domain.repository;

import com.darwinfont.fexControl.domain.entities.StageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StageRepository extends JpaRepository<StageEntity, Long> {
}
