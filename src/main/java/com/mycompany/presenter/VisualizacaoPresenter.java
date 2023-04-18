package com.mycompany.presenter;

import com.mycompany.model.DadosPesoModel;
import com.mycompany.model.ResultadoModel;
import com.mycompany.service.CalculoEstatisticaService;
import com.mycompany.view.ViewCalculadoraEstatistica;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import javax.swing.JFrame;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

public class VisualizacaoPresenter {

    private final ViewCalculadoraEstatistica view;
    private DefaultTableModel tabelaResultado;
    private CalculoEstatisticaService calculoService;

    public VisualizacaoPresenter() throws ExecutionException, IOException {
        this.view = new ViewCalculadoraEstatistica();
        this.view.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.calculoService = new CalculoEstatisticaService();

        constructTableModel();
    }

    private void constructTableModel() {
            tabelaResultado = new DefaultTableModel(
                    new Object[][][][]{},
                    new String[]{"Operacao", "Valor"}
            );
            
            view.getTblResultado().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            tabelaResultado.setNumRows(0);
            view.getTblResultado().setModel(tabelaResultado);     
    }

    public void CalcularEstatistica(DadosPesoModel pesoModel) throws ExecutionException, IOException, Exception {
        calculoService.calcular(pesoModel);
        loadDados(pesoModel);
    }
    
    public void VisualizarCalculoEstatistico(DadosPesoModel pesoModel) throws IOException, Exception{
        this.loadDados(pesoModel);
    }
    
    private void loadDados(DadosPesoModel pesoModel) throws ExecutionException, IOException, Exception {
        if(pesoModel.getResultModel().size() <= 0 ){
            throw new Exception("Por favor realize o cálculo");
        }
        
        for(ResultadoModel resultado : pesoModel.getResultModel()) {
            tabelaResultado.addRow(new Object[]{
                resultado.getNome(),
                resultado.getValor()
            });
        }
    }

    public ViewCalculadoraEstatistica getView() {
        return view;
    }


}
