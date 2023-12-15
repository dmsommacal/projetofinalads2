package com.senac.projetoFinal.resource;

import com.senac.projetoFinal.enterprise.ValidationException;
import com.senac.projetoFinal.models.ItensReserva;
import com.senac.projetoFinal.models.Produto;
import com.senac.projetoFinal.service.ItensReservaService;
import com.senac.projetoFinal.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("api/itensReservas")
public class ItensReservaController {


    @Autowired
    private ItensReservaService itensReservaService;

    @PostMapping
    public ResponseEntity createItem(@RequestBody ItensReserva entity) {
        try {
            ItensReserva save = itensReservaService.salvar(entity);

            // Verifica se a quantidade solicitada é maior que zero
            if (entity.getQuantidadeProdutos() <= 0) {
                throw new ValidationException("A quantidade solicitada deve ser maior que zero.");
            }

            // Verifica se a quantidade solicitada é maior que a disponível em estoque
            if (entity.getQuantidadeProdutos() > 0) {
                itensReservaService.subtraiEstoque(save.getId(), entity.getQuantidadeProdutos());
                URI location = URI.create("/api/itensReservas/" + save.getId());
                return ResponseEntity.created(location).body(save);
            } else {
                throw new ValidationException("A quantidade solicitada é maior que a disponível em estoque.");
            }
        } catch (ValidationException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao criar o item de reserva.");
        }
    }


    @GetMapping
    public ResponseEntity findAll() {
        List<ItensReserva> itens = itensReservaService.buscaTodos();
        return ResponseEntity.ok(itens);
    }

    @GetMapping("{id}")
    public ResponseEntity findAllByReservaId(@PathVariable("id") Long id) {
        ItensReserva itens = (ItensReserva) itensReservaService.buscaTodosPorReserva(id);
        return ResponseEntity.ok(itens);
    }

    @DeleteMapping("{id}")
    public ResponseEntity remove(@PathVariable("id") Long id) {
        itensReservaService.remover(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity update(@PathVariable("id") Long id, @RequestBody ItensReserva entity) {
        ItensReserva alterado = itensReservaService.alterar(id, entity);
        return ResponseEntity.ok().body(alterado);
    }
}
