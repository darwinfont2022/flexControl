package com.darwinfont.fexControl.service.client;

import com.darwinfont.fexControl.domain.entities.ClientEntity;
import com.darwinfont.fexControl.domain.entities.PartEntity;
import com.darwinfont.fexControl.domain.exeptions.NotFoundError;
import com.darwinfont.fexControl.domain.repository.ClientRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ClientLoadImp implements ClientLoad {
    private final ClientRepository clientRepository;

    public ClientLoadImp(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public ClientEntity loadById(Long id) {
        ClientEntity client = getById(id);
        if (Objects.nonNull(client)) {
            return client;
        }
        throw new NotFoundError("client id", id.toString(), "client not exist");
    }

    @Override
    public ClientEntity getById(Long id) {
        return  clientRepository.findById(id).orElse(null);
    }

    @Override
    public List<ClientEntity> loadAll() {
        return clientRepository.findAll();
    }

    @Override
    public Page<ClientEntity> filter(Long id, Integer externalId, String name) {
        return clientRepository.findAll((Root<ClientEntity> root, CriteriaQuery<?> query, CriteriaBuilder cb) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (Objects.nonNull(id)) {
                predicates.add(cb.equal(root.get("id"), id));
            }

            if (Objects.nonNull(externalId)) {
                predicates.add(cb.equal(root.get("externalId"), externalId));
            }

            if (Objects.nonNull(name)) {
                predicates.add(cb.like(root.get("name").as(String.class), "%" + name + "%"));
            }

            return cb.or(predicates.toArray(new Predicate[predicates.size()]));
        }, Pageable.unpaged());
    }
}
