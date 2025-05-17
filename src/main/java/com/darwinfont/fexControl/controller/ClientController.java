package com.darwinfont.fexControl.controller;

import com.darwinfont.fexControl.domain.dto.client.ClientCreateDto;
import com.darwinfont.fexControl.domain.dto.client.ClientUpdateDto;
import com.darwinfont.fexControl.service.client.ClientCreate;
import com.darwinfont.fexControl.service.client.ClientDelete;
import com.darwinfont.fexControl.service.client.ClientLoad;
import com.darwinfont.fexControl.service.client.ClientUpdate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/client")
public class ClientController {
    private final ClientCreate clientCreate;
    private final ClientLoad clientLoad;
    private final ClientUpdate clientUpdate;
    private final ClientDelete clientDelete;

    public ClientController(ClientCreate clientCreate, ClientLoad clientLoad, ClientUpdate clientUpdate, ClientDelete clientDelete) {
        this.clientCreate = clientCreate;
        this.clientLoad = clientLoad;
        this.clientUpdate = clientUpdate;
        this.clientDelete = clientDelete;
    }

    @PostMapping()
    public ResponseEntity<?> saveClient(@RequestBody ClientCreateDto clientDto) {
        return ResponseEntity.status(HttpStatus.OK).body(clientCreate.addClient(clientDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return ResponseEntity.ok(clientLoad.loadById(id));
    }

    @GetMapping()
    public ResponseEntity<?> filter(@RequestParam(required = false) Long id, @RequestParam(required = false) Integer externalId, @RequestParam(required = false) String name) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(clientLoad.filter(id, externalId, name));
    }

    @PutMapping()
    public ResponseEntity<?> updateClient(@RequestParam() Long id, @RequestBody ClientUpdateDto dto) {
        clientUpdate.update(id, dto);
        return ResponseEntity.ok().body(null);
    }

    @DeleteMapping()
    public ResponseEntity<?> deleteClient(@RequestParam Long id) {
        clientDelete.deleteById(id);
        return ResponseEntity.ok().body(null);
    }
}
