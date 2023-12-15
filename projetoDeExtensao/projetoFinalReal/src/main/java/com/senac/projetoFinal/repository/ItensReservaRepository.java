package com.senac.projetoFinal.repository;

import com.senac.projetoFinal.models.ItensReserva;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItensReservaRepository extends JpaRepository<ItensReserva, Long> {
    List<ItensReserva> findAllByReservaId(Long id);
}
