package com.senac.projetoFinal.repository;

import com.senac.projetoFinal.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    public Usuario findByNomeUsuario(String userName);
}
