package com.darwinfont.fexControl.service.client;

import com.darwinfont.fexControl.domain.dto.client.ClientCreateDto;
import com.darwinfont.fexControl.domain.entities.ClientEntity;
import com.darwinfont.fexControl.domain.exeptions.ConflictError;
import com.darwinfont.fexControl.domain.repository.ClientRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ClientCreateImp implements ClientCreate {
    private final ClientRepository clientRepository;

    public ClientCreateImp(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public ClientEntity dtoToEntity(ClientCreateDto dto) {
        log.info("[P-1] Parsing dto -> client entity");
        return ClientEntity.builder()
                .name(dto.getName())
                .externalId(dto.getExternalId())
                .build();
    }

    @Override
    public ClientEntity addClient(ClientCreateDto dto) {
        log.info("Creating client");
        return save(dtoToEntity(dto));
    }

    @Override
    public ClientEntity save(ClientEntity client) {
        log.info("[S-2] Saving client {}", client);
        try {
            return clientRepository.save(client);
        } catch (Exception e) {
            throw new ConflictError("client", "null", "Error creating client");
        }
    }
}
