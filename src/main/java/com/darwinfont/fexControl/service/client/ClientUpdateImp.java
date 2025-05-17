package com.darwinfont.fexControl.service.client;

import com.darwinfont.fexControl.domain.dto.client.ClientUpdateDto;
import com.darwinfont.fexControl.domain.entities.ClientEntity;
import com.darwinfont.fexControl.domain.repository.ClientRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@Slf4j
public class ClientUpdateImp implements ClientUpdate {
    private final ClientLoad clientLoad;
    private final ClientRepository clientRepository;

    public ClientUpdateImp(ClientLoad clientLoad, ClientRepository clientRepository) {
        this.clientLoad = clientLoad;
        this.clientRepository = clientRepository;
    }

    //Update Name and ExternalId
    @Override
    public void update(Long id, ClientUpdateDto dto) {
        ClientEntity client = clientLoad.loadById(id);

        if (Objects.nonNull(dto.getName()) && !dto.getName().isBlank() && !dto.getName().equals(client.getName())) {
            log.info("[U-2] Updating client name");
            client.setName(dto.getName());
        }

        if (Objects.nonNull(dto.getExternalId()) && !dto.getExternalId().equals(client.getExternalId())) {
            log.info("[U-3] Updating externalId");
            client.setExternalId(dto.getExternalId());
        }
        log.info("[L-1] Saving client");
        clientRepository.save(client);
    }
}
