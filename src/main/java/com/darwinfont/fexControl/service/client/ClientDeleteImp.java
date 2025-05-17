package com.darwinfont.fexControl.service.client;

import com.darwinfont.fexControl.domain.exeptions.NotFoundError;
import com.darwinfont.fexControl.domain.repository.ClientRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ClientDeleteImp implements ClientDelete {
    private final ClientRepository clientRepository;

    public ClientDeleteImp(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public void deleteById(Long id) {
        if (clientRepository.existsById(id)) {
            clientRepository.deleteById(id);
            log.info("[D-1] Deleted client {}", id);
        } else {
            log.error("[D-2] Error client {} not exist", id);
            throw new NotFoundError("id", id.toString(), "Error client not exist");
        }
    }
}
