package com.senac.projetoFinal.resource;

import com.senac.projetoFinal.models.ItensReserva;
import com.senac.projetoFinal.models.Reserva;
import com.senac.projetoFinal.service.ItensReservaService;
import com.senac.projetoFinal.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/reservas")
public class ReservaController extends AbstractController {

    @Autowired
    private ReservaService service;

    @Autowired
    private ItensReservaService itensReservaService;

    @PostMapping
    public ResponseEntity create(@RequestBody Reserva entity) {
        Reserva save = service.salvar(entity);
        return ResponseEntity.created(URI.create("/api/reservas/" + entity.getId())).body(save);
    }

    @GetMapping
    public ResponseEntity findAll() {
        List<Reserva> reservas = service.buscaTodos();
        return ResponseEntity.ok(reservas);
    }

    @GetMapping("{id}")
    public ResponseEntity findById(@PathVariable("id") Long id) {
        Reserva reserva = service.buscaPorId(id);
        return ResponseEntity.ok(reserva);
    }

    @DeleteMapping("{id}")
    public ResponseEntity remove(@PathVariable("id") Long id) {
        service.remover(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity update(@PathVariable("id") Long id, @RequestBody Reserva entity) {
        Reserva alterado = service.alterar(id, entity);
        return ResponseEntity.ok().body(alterado);
    }
}
