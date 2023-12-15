package com.senac.projetoFinal.service;

import com.senac.projetoFinal.models.Agricultor;
import com.senac.projetoFinal.models.Usuario;
import com.senac.projetoFinal.repository.AgricultorRepository;
import com.senac.projetoFinal.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AgricultorService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private AgricultorRepository agricultorRepository;

    public Agricultor salvar(Agricultor entity) {

        return agricultorRepository.save(entity);

    }
    public List<Agricultor> buscaTodos(){
        return agricultorRepository.findAll();}
    public Agricultor buscarPorId(Long id) {
        return agricultorRepository.findById(id).orElse(null);
    }
    public Agricultor alterar(Long id,Agricultor alterado){
        Optional<Agricultor> encontrado = agricultorRepository.findById(id);
        if(encontrado.isPresent()){
            Agricultor agricultor = encontrado.get();

            agricultor.setCidade(alterado.getCidade());
            agricultor.setEndereco(alterado.getEndereco());
            agricultor.setNumero(alterado.getNumero());
            agricultor.setInformacoesAdicionais(alterado.getInformacoesAdicionais());

            return agricultorRepository.save(agricultor);
        }
        return null;
    }
    public void remover(Long id) {agricultorRepository.deleteById(id);}

}
