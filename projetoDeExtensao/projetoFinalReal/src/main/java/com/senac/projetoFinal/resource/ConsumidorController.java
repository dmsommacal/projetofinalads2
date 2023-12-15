package com.senac.projetoFinal.resource;

import com.senac.projetoFinal.models.Consumidor;
import com.senac.projetoFinal.service.ConsumidorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/consumidores")
public class ConsumidorController {

    @Autowired
    private ConsumidorService service;

    @PostMapping
    public ResponseEntity create(@RequestBody Consumidor entity) {
        Consumidor save = service.salvar(entity);
        return ResponseEntity.created(URI.create("/api/consumidores/" + entity.getId())).body(save);
    }

    @GetMapping
    public ResponseEntity findAll() {
        List<Consumidor> consumidores = service.buscaTodos();
        return ResponseEntity.ok(consumidores);
    }

    @GetMapping("{id}")
    public ResponseEntity findById(@PathVariable("id") Long id) {
        Consumidor consumidor = service.buscarPorId(id);
        return ResponseEntity.ok(consumidor);
    }

    @DeleteMapping("{id}")
    public ResponseEntity remove(@PathVariable("id") Long id) {
        service.remover(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity update(@PathVariable("id") Long id, @RequestBody Consumidor entity) {
        Consumidor alterado = service.alterar(id, entity);
        return ResponseEntity.ok().body(alterado);
    }
}
