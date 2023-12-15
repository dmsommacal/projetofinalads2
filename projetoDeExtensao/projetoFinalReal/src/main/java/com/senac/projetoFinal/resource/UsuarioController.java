package com.senac.projetoFinal.resource;

import com.senac.projetoFinal.models.Usuario;
import com.senac.projetoFinal.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController  extends AbstractController{

    @Autowired
    private UsuarioService service;

    @PostMapping
    public ResponseEntity create(@RequestBody Usuario entity) {
        Usuario save = service.salvar(entity);
        return ResponseEntity.created(URI.create("/api/usuarios/" + entity.getId())).body(save);
    }

    @GetMapping
    public ResponseEntity findAll() {
        List<Usuario> usuarios = service.buscaTodos();
        return ResponseEntity.ok(usuarios);
    }

    @GetMapping("{id}")
    public ResponseEntity findById(@PathVariable("id") Long id) {
        Usuario usuario = service.buscaPorId(id);
        return ResponseEntity.ok(usuario);
    }

    @DeleteMapping("{id}")
    public ResponseEntity remove(@PathVariable("id") Long id) {
        service.remover(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity update(@PathVariable("id") Long id, @RequestBody Usuario entity) {
        Usuario alterado = service.alterar(id, entity);
        return ResponseEntity.ok().body(alterado);
    }
}
