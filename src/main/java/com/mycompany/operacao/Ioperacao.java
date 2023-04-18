package com.mycompany.operacao;

import com.mycompany.model.DadosPesoModel;
import com.mycompany.model.ResultadoModel;


public interface Ioperacao {

    public ResultadoModel calcular(DadosPesoModel peso);
    
}
