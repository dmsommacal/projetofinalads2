package com.senac.projetoFinal.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Entity
public class Reserva extends EntityId{

    @ManyToOne
    @JoinColumn(name = "id_produto")
    private Produto produto;
    @Column(name = "data_reserva")
    private LocalDate dataReserva;
    @Column(name = "observacao")
    private String observacao;
    @ManyToOne
    @JoinColumn(name = "consumidor_id")
    private Consumidor consumidor;

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public LocalDate getDataReserva() {
        return dataReserva;
    }

    public void setDataReserva(LocalDate dataReserva) {
        this.dataReserva = dataReserva;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Consumidor getConsumidor() {
        return consumidor;
    }

    public void setConsumidor(Consumidor consumidor) {
        this.consumidor = consumidor;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "produto=" + produto +
                ", dataReserva=" + dataReserva +
                ", observacao='" + observacao + '\'' +
                ", consumidor=" + consumidor +
                '}';
    }
}
