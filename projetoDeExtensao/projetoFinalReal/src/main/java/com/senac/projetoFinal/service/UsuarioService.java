package com.senac.projetoFinal.service;

import com.senac.projetoFinal.enterprise.ValidationException;
import com.senac.projetoFinal.models.Usuario;
import com.senac.projetoFinal.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository repository;

    public Usuario salvar(Usuario entity) {
        if(entity.getNomeUsuario().length()<3 || entity.getNomeUsuario().isBlank()){
            throw new ValidationException("O nome do usuário deve ter mais que 3 caracteres e não pode ser nulo!");
        }

        if(repository.findByNomeUsuario(entity.getNomeUsuario()) != null){
            throw new ValidationException("Nome usuário já cadastrado!");
        }

        if(entity.getSenha().length()<3 || entity.getSenha().length()> 12){
            throw  new ValidationException("Senha tem que ter no mínimo 3 caracteres e menor que 12 caracteres!");
        }

        if (entity.getEmail() == null || entity.getEmail().isBlank()) {
            throw new ValidationException("E-mail não pode ser vazio!");
        }

        return repository.save(entity);
    }

    public List<Usuario> buscaTodos() {
        return repository.findAll();
    }

    public Usuario buscaPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Usuario alterar(Long id, Usuario alterado) {
        Optional<Usuario> encontrado = repository.findById(id);
        if (encontrado.isPresent()) {
            Usuario usuario = encontrado.get();

            usuario.setNomeUsuario(alterado.getNomeUsuario());
            usuario.setSenha(alterado.getSenha());
//            usuario.setTipo(alterado.getTipo());
            usuario.setEmail(alterado.getEmail());
            return repository.save(usuario);
        }
        return null;
    }

    public void remover(Long id) {
        repository.deleteById(id);
    }
}
