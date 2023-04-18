package com.mycompany.model;

import java.time.LocalDate;

public class ResultadoModel {
    private String nome;
    private Double valor;
    private LocalDate data;

    public String getNome() {
        return nome;
    }

    public ResultadoModel(String nome, Double valor) {
        this.nome = nome;
        this.valor = valor;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }
    
}
