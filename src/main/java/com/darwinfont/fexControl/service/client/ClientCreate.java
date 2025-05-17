package com.darwinfont.fexControl.service.client;

import com.darwinfont.fexControl.domain.dto.client.ClientCreateDto;
import com.darwinfont.fexControl.domain.entities.ClientEntity;

public interface ClientCreate {
    ClientEntity dtoToEntity(ClientCreateDto dto);
    ClientEntity addClient(ClientCreateDto dto);
    ClientEntity save(ClientEntity client);
}
