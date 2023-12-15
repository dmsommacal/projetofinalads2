package com.senac.projetoFinal.service;

import com.senac.projetoFinal.models.Consumidor;
import com.senac.projetoFinal.repository.ConsumidorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConsumidorService {
    @Autowired
    private ConsumidorRepository consumidorRepository;

    public Consumidor salvar(Consumidor entity) {

        return consumidorRepository.save(entity);

    }
    public List<Consumidor> buscaTodos(){
        return consumidorRepository.findAll();}
    public Consumidor buscarPorId(Long id) {
        return consumidorRepository.findById(id).orElse(null);
    }
    public Consumidor alterar(Long id,Consumidor alterado){
        Optional<Consumidor> encontrado = consumidorRepository.findById(id);
        if(encontrado.isPresent()){
            Consumidor consumidor = encontrado.get();

            return consumidorRepository.save(consumidor);
        }
        return null;
    }
    public void remover(Long id) {consumidorRepository.deleteById(id);}

}
