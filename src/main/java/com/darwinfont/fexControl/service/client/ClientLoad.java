package com.darwinfont.fexControl.service.client;

import com.darwinfont.fexControl.domain.dto.PageDto;
import com.darwinfont.fexControl.domain.entities.ClientEntity;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ClientLoad {
    ClientEntity loadById(Long id);
    ClientEntity getById(Long id);
    List<ClientEntity> loadAll();
    Page<ClientEntity> filter(Long id, Integer externalId, String name);
}
