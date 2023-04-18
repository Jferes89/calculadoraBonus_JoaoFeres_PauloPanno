package com.mycompany.model;

import java.util.ArrayList;
import java.util.List;


public class DadosPesoModel{
    private List<Long> pesos;
    private List<ResultadoModel> resultModel;
    
    public List<Long> getPesos() {
        return pesos;
    }

    public DadosPesoModel() {
        this.resultModel = new ArrayList<ResultadoModel>();
    }

    public void setPesos(List<Long> pesos) {
        this.pesos = pesos;
    }
    
    public void add(Long pesos){
        this.pesos.add(pesos);
    }

    public List<ResultadoModel> getResultModel() {
        return resultModel;
    }
    
    
    public void addResultado(ResultadoModel restult){
        this.resultModel.add(restult);
    }    

}
