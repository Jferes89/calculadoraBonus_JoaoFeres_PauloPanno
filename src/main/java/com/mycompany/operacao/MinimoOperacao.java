package com.mycompany.operacao;

import com.mycompany.Enum.OperacaoEnum;
import com.mycompany.model.DadosPesoModel;
import com.mycompany.model.ResultadoModel;

public class MinimoOperacao implements Ioperacao{

    @Override
    public ResultadoModel calcular(DadosPesoModel peso) { 
        double min = peso.getPesos().get(0);    
        for (Long n : peso.getPesos())
           if (n < min)
               min = n;
        
    return new ResultadoModel(OperacaoEnum.MAXIMO.getDescricao(), min);
    } 
 }