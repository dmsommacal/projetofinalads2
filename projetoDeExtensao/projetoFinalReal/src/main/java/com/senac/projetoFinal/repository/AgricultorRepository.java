package com.senac.projetoFinal.repository;

import com.senac.projetoFinal.models.Agricultor;
import org.springframework.data.jpa.repository.JpaRepository;
public interface AgricultorRepository extends JpaRepository<Agricultor, Long> {
}
