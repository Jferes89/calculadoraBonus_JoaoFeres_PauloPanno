package com.mycompany.service;

import com.mycompany.model.DadosPesoModel;
import com.mycompany.operacao.DesvioPadraoOperacao;
import com.mycompany.operacao.Ioperacao;
import com.mycompany.operacao.MaximoOperacao;
import com.mycompany.operacao.MediaOperacao;
import com.mycompany.operacao.MinimoOperacao;
import com.mycompany.operacao.SomatorioOperacao;
import com.mycompany.operacao.VariancaOperacao;
import java.util.ArrayList;
import java.util.List;

public class CalculoEstatisticaService {

    private List<Ioperacao> listOperacao = new ArrayList<Ioperacao>();

    public void calcular(DadosPesoModel pesoModel) throws Exception {
        if(pesoModel.getPesos() == null && pesoModel.getPesos().isEmpty()){
           throw new Exception("Não encontramos dados para calcular, por favor informe!");
        }
        initOperacao();
        for(Ioperacao op : listOperacao){
            pesoModel.addResultado(op.calcular(pesoModel));    
        }
    }

    private void initOperacao(){
        this.listOperacao.add(new MediaOperacao());
        this.listOperacao.add(new SomatorioOperacao());
        this.listOperacao.add(new DesvioPadraoOperacao());
        this.listOperacao.add(new VariancaOperacao());
        this.listOperacao.add(new MaximoOperacao());
        this.listOperacao.add(new MinimoOperacao());
    }   
}
