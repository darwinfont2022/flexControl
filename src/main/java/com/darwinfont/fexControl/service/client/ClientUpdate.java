package com.darwinfont.fexControl.service.client;

import com.darwinfont.fexControl.domain.dto.client.ClientUpdateDto;

public interface ClientUpdate {
    void update(Long id, ClientUpdateDto dto);
}
