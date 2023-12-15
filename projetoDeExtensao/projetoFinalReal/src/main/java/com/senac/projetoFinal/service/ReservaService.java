package com.senac.projetoFinal.service;

import com.senac.projetoFinal.models.Reserva;
import com.senac.projetoFinal.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservaService {
    @Autowired
    private ReservaRepository repository;
    public Reserva salvar(Reserva entity) {

        return repository.save(entity);
    }

    public List<Reserva> buscaTodos() {
        return repository.findAll();
    }

    public Reserva buscaPorId(Long id) {

        return repository.findById(id).orElse(null);
    }

    public Reserva alterar(Long id, Reserva alterado) {
        Optional<Reserva> encontrado = repository.findById(id);
        if (encontrado.isPresent()) {
            Reserva reserva = encontrado.get();

            reserva.setProduto(alterado.getProduto());
            reserva.setDataReserva(alterado.getDataReserva());
            reserva.setObservacao(alterado.getObservacao());
            reserva.setConsumidor(alterado.getConsumidor());
            return repository.save(reserva);
        }
        return null;
    }
    public void remover(Long id) {
        repository.deleteById(id);
    }
}