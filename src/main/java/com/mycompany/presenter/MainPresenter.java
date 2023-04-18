package com.mycompany.presenter;

import com.mycompany.log.LogCsv;
import com.mycompany.model.DadosPesoModel;
import com.mycompany.service.LogService;
import com.mycompany.view.MainCalculadorEstatistica;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

public class MainPresenter {
    private final MainCalculadorEstatistica view;
    private DefaultTableModel tabelaDados;
    private LogService logService;
    private String filePath;
    private DadosPesoModel pesoModel;
    private VisualizacaoPresenter visualizacaoPresenter;


    public MainPresenter() throws Exception {
        this.pesoModel = new DadosPesoModel();
        this.view = new MainCalculadorEstatistica();
        view.setExtendedState(JFrame.MAXIMIZED_BOTH);
        view.setVisible(true);
        initListeners();
        constructTableModel();
        initPresenters();
    }
    
      private void constructTableModel() {
        tabelaDados = new DefaultTableModel(
                new Object[][][][]{},
                new String[]{"Dados"}
        );

        view.getTblDados().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tabelaDados.setNumRows(0);
        view.getTblDados().setModel(tabelaDados);
    }

    private void loadDados() throws ExecutionException, IOException{
        if(filePath != null && !filePath.isEmpty()){
            this.logService = new LogService(new LogCsv(filePath));
            this.pesoModel.setPesos(this.logService.getAllNumeros());
            
            for (Long numero : this.pesoModel.getPesos()) {
            tabelaDados.addRow(new Object[]{
                numero
            });
            }
        }
    }
    private void initPresenters() throws ExecutionException, IOException{
        this.visualizacaoPresenter = new VisualizacaoPresenter();
    }
            
    private void initListeners() throws Exception {
        try {
            view.getMniImportarDados().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JFileChooser fc = new JFileChooser();
                    fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
                    fc.showOpenDialog(view);
                    File f = fc.getSelectedFile();
                    filePath = f.getPath();
                    try {
                        loadDados();
                    } catch (ExecutionException ex) {
                        Logger.getLogger(MainPresenter.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(MainPresenter.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
            
            view.getMniCalacular().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        visualizacaoPresenter.CalcularEstatistica(pesoModel);
                        visualizacaoPresenter.getView().setVisible(true);
                    } catch (Exception ex) {
                        Logger.getLogger(MainPresenter.class.getName()).log(Level.SEVERE, null, ex);
                        JOptionPane.showMessageDialog(view, "Não encontramos dados para calcular, por favor informe!", "Atenção", JOptionPane.WARNING_MESSAGE);

                    }
                    
                }
            });
            
            view.getMniVisualizarDados().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        visualizacaoPresenter.VisualizarCalculoEstatistico(pesoModel);
                        visualizacaoPresenter.getView().setVisible(true);
                    } catch (Exception ex) {
                        Logger.getLogger(MainPresenter.class.getName()).log(Level.SEVERE, null, ex);
                        JOptionPane.showMessageDialog(view, "Por favor realize o cálculo", "Atenção", JOptionPane.WARNING_MESSAGE);

                    }
                    
                }
            });
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(view, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
}
