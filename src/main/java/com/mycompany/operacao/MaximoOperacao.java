package com.mycompany.operacao;

import com.mycompany.Enum.OperacaoEnum;
import com.mycompany.model.DadosPesoModel;
import com.mycompany.model.ResultadoModel;


 public class MaximoOperacao implements Ioperacao{

    @Override
    public ResultadoModel calcular(DadosPesoModel peso) { 
        double max = peso.getPesos().get(0);    
        for (Long n : peso.getPesos()){
            if(n > max){
              max = n;

            }
        }        
    return new ResultadoModel(OperacaoEnum.MAXIMO.getDescricao(), max);
    } 
 }