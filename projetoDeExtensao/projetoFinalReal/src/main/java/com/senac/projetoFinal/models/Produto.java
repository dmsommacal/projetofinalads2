package com.senac.projetoFinal.models;

import javax.persistence.Column;
import javax.persistence.Entity;
@Entity
public class Produto extends EntityId{
    @Column(name = "nm_produto", nullable = false)
    private String nome;
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "qtde_disponivel", nullable = false)
    private Integer quantidadeDisponivel;
    @Column(name = "vl_produto", nullable = false)
    private Double valor;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getQuantidadeDisponivel() {
        return quantidadeDisponivel;
    }
    public void setQuantidadeDisponivel(Integer quantidadeDisponivel) {
        this.quantidadeDisponivel = quantidadeDisponivel;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", quantidade=" + quantidadeDisponivel +
                ", valor=" + valor +
                '}';
    }
}
