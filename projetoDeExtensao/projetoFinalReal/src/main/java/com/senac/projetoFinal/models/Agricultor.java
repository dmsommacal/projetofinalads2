package com.senac.projetoFinal.models;

import javax.persistence.*;

@Entity
public class Agricultor extends Pessoa {
    @Column(name = "cidade", nullable = false)
    private String cidade;
    @Column(name = "endereco", nullable = false)
    private String endereco;
    @Column(name = "numero", nullable = false)
    private Integer numero;
    @Column(name = "informacoes_adicionais")
    private String informacoesAdicionais;
    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getInformacoesAdicionais() {
        return informacoesAdicionais;
    }

    public void setInformacoesAdicionais(String informacoesAdicionais) {
        this.informacoesAdicionais = informacoesAdicionais;
    }

    @Override
    public String toString() {
        return "Agricultor{" +
                "cidade='" + cidade + '\'' +
                ", endereco='" + endereco + '\'' +
                ", numero=" + numero +
                ", informacoesAdicionais='" + informacoesAdicionais + '\'' +
                '}';
    }
}
