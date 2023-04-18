package com.mycompany.operacao;

import com.mycompany.Enum.OperacaoEnum;
import com.mycompany.model.DadosPesoModel;
import com.mycompany.model.ResultadoModel;

/**
 *
 * @author paulo
 */
public class VariancaOperacao implements Ioperacao{

    @Override
    public ResultadoModel calcular(DadosPesoModel peso) {
        double p1 = 1 / Double.valueOf(peso.getPesos().size() - 1);
        double somaAoQuadrado = 0;
        for (int counter = 0; counter < peso.getPesos().size(); counter++) {
            somaAoQuadrado += Math.pow(peso.getPesos().get(counter), 2);
        }
        double soma = 0;
        for (int counter = 0; counter < peso.getPesos().size(); counter++) {
            soma += peso.getPesos().get(counter);
        }
        double p2 = somaAoQuadrado - (Math.pow(soma, 2) / Double.valueOf(peso.getPesos().size()));
        soma = p1 * p2;
        return new ResultadoModel(OperacaoEnum.VARIANCA.getDescricao(), soma);
    }
}
