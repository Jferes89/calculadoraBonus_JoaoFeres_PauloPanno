
package com.mycompany.service;

import com.mycompany.log.Log;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class LogService {

    private Log log;

    public LogService(Log log) {
        this.log = log;
    }
    
    public List<Long> getAllNumeros() throws IOException{
        List<Long> listNumeros = new ArrayList<>();
        for(String[] numero : log.leitura()){
            listNumeros.add(Long.valueOf(numero[0]));
        } 
        return listNumeros;
    }
}
