package com.senac.projetoFinal.models;

import javax.persistence.*;

@Entity
public class ItensReserva extends EntityId{
    @ManyToOne
    @JoinColumn(name = "reserva_id")
    private Reserva reserva;
    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;
    @Column(name = "qtde_produtos", nullable = false)
    private Integer quantidadeProdutos;

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public Integer getQuantidadeProdutos() {
        return quantidadeProdutos;
    }

    public void setQuantidadeProdutos(Integer quantidadeProdutos) {
        this.quantidadeProdutos = quantidadeProdutos;
    }

    @Override
    public String toString() {
        return "ItensReserva{" +
                "reserva=" + reserva +
                ", produto=" + produto +
                ", quantidadeProdutos=" + quantidadeProdutos +
                '}';
    }
}