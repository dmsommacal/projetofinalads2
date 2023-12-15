package com.senac.projetoFinal.service;

import com.senac.projetoFinal.models.Produto;
import com.senac.projetoFinal.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {
//    @Autowired
//    private UsuarioRepository usuarioRepository;
    @Autowired
    private ProdutoRepository produtoRepository;


    public Produto salvar(Produto entity) {
//        Usuario usuario = usuarioRepository.findById(usuarioId)
//                .orElseThrow(()-> new RuntimeException("Usuário não encontrado!"));
//        if (usuario.getTipo() != TipoUsuario.AGRICULTOR) {
//            throw new RuntimeException("Apenas AGRICULTORES podem cadastrar produtos!");
//        }
        if (entity.getQuantidadeDisponivel() < 0){
            throw new RuntimeException("A quantidade de produtos precisa ser maior que 0!");
        }
        return produtoRepository.save(entity);

    }
    public List<Produto> buscaTodos(){
        return produtoRepository.findAll();}
    public Produto buscarPorId(Long id) {
        return produtoRepository.findById(id).orElse(null);
    }
    public Produto alterar(Long id,Produto alterado){
        Optional<Produto> encontrado = produtoRepository.findById(id);
        if(encontrado.isPresent()){
            Produto produto = encontrado.get();

            produto.setNome(alterado.getNome());
            produto.setDescricao(alterado.getDescricao());
            produto.setValor(alterado.getValor());
            produto.setQuantidadeDisponivel(alterado.getQuantidadeDisponivel());

            return produtoRepository.save(produto);
        }
        return null;
    }
    public void remover(Long id) {produtoRepository.deleteById(id);}

//    public Produto salvar(Produto entity) {
//        return null;
//    }
}
