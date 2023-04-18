package com.mycompany.log;

import java.io.IOException;
import java.util.List;

public abstract class Log {
 
    protected String file;

    public Log(String file) {
        this.file = file;
    }
    
    public abstract List<String[]> leitura() throws IOException;
    
}
