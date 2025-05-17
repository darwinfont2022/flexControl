package com.darwinfont.fexControl.domain.repository;

import com.darwinfont.fexControl.domain.entities.ClientEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<ClientEntity, Long> {
    Page<ClientEntity> findAll(Specification<ClientEntity> specification, Pageable pageable);
}
