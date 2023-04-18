package com.mycompany.operacao;

import com.mycompany.Enum.OperacaoEnum;
import com.mycompany.model.DadosPesoModel;
import com.mycompany.model.ResultadoModel;


public class SomatorioOperacao implements Ioperacao{

    @Override
    public ResultadoModel calcular(DadosPesoModel peso) {
        double soma = 0;
        if(peso.getPesos() != null && !peso.getPesos().isEmpty()){
            for (int counter = 0; counter < peso.getPesos().size(); counter++) {
                soma += peso.getPesos().get(counter);
            } 
        }
           
        return new ResultadoModel(OperacaoEnum.SOMATORIO.getDescricao(), soma);
    }
    
}
