package com.mycompany.log;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class LogCsv extends Log{

    public LogCsv(String string) {
        super(string);
    }

    @Override
    public List<String[]> leitura() throws IOException {
        List<String[]> list = new ArrayList<>();
        Path path = Paths.get(this.file);
        try (Reader reader = Files.newBufferedReader(path)) {
            try (CSVReader csvReader = configReader(reader)) {
                String[] line;
                while ((line = csvReader.readNext()) != null) {
                    list.add(line);
                }
            }
        }
        
        return list;
    }
          
    public CSVReader configReader(Reader reader) {
        CSVParser parser = new CSVParserBuilder()
                .withSeparator(',')
                .withIgnoreQuotations(true)
                .build();

        CSVReader csvReader = new CSVReaderBuilder(reader)
                .withSkipLines(1)
                .withCSVParser(parser)
                .build();
        return csvReader;
    }

}
