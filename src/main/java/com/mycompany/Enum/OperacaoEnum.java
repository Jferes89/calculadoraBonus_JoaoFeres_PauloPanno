
package com.mycompany.Enum;


public enum OperacaoEnum {
   
    SOMATORIO("Somatorio"),
    MEDIA("Media"),
    DESVIOPADRAO("Desvio Padrão"),
    VARIANCA("Variança"),
    MAXIMO("Máximo"),
    MINIMO("Minimo");
  
    private String descricao;

    OperacaoEnum(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}

