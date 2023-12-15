package com.senac.projetoFinal.service;

import com.senac.projetoFinal.enterprise.ValidationException;
import com.senac.projetoFinal.models.ItensReserva;
import com.senac.projetoFinal.models.Produto;
import com.senac.projetoFinal.repository.ItensReservaRepository;
import com.senac.projetoFinal.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItensReservaService {
    @Autowired
    private ItensReservaRepository itensReservaRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    public void subtraiEstoque(Long itemId, Integer qtd){
        Optional<ItensReserva> optional= itensReservaRepository.findById(itemId);

        if (optional.isPresent()){
            Optional<Produto> byId = produtoRepository.findById(optional.get().getProduto().getId());

            if(byId.isPresent()){
                Integer quantidade = byId.get().getQuantidadeDisponivel();
                if(quantidade>=qtd) {
                    Integer novaQuantidade = quantidade - qtd;
                    Produto produto = byId.get();
                    produto.setQuantidadeDisponivel(novaQuantidade);
                    produtoRepository.save(produto);
                }else{
                    throw new ValidationException("Quantidade solicita indisponível! Apenas "+quantidade+" em estoque.");
                }
            }
        }
    }

    public ItensReserva salvar(ItensReserva entity) {

        return itensReservaRepository.save(entity);
    }
    public List<ItensReserva> buscaTodosPorReserva(Long id){
        return itensReservaRepository.findAllByReservaId(id);
    }

    public List<ItensReserva> buscaTodos() {
        return itensReservaRepository.findAll();
    }

    public ItensReserva buscaPorId(Long id) {
        return itensReservaRepository.findById(id).orElse(null);
    }
    public ItensReserva alterar(Long id, ItensReserva alterado) {
        Optional<ItensReserva> encontrado = itensReservaRepository.findById(id);
        if (encontrado.isPresent()) {

            ItensReserva itensReserva = encontrado.get();
            itensReserva.setReserva(alterado.getReserva());
            itensReserva.setProduto(alterado.getProduto());
            itensReserva.setQuantidadeProdutos(alterado.getQuantidadeProdutos());
            return itensReservaRepository.save(itensReserva);
        }
        return null;
    }

    public void remover(Long id) {itensReservaRepository.deleteById(id);}
}