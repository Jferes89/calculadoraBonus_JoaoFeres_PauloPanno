
package com.mycompany.operacao;

import com.mycompany.Enum.OperacaoEnum;
import com.mycompany.model.DadosPesoModel;
import com.mycompany.model.ResultadoModel;


public class MediaOperacao implements Ioperacao{

    @Override
    public ResultadoModel calcular(DadosPesoModel peso) {
        double total = 0;
            for (int i = 0; i < peso.getPesos().size(); i++) {
                total += peso.getPesos().get(i);
            }
       return new ResultadoModel(OperacaoEnum.MEDIA.getDescricao(), total / peso.getPesos().size());    
    }
    
}
