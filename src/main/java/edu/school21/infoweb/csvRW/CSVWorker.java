package edu.school21.infoweb.csvRW;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.List;

@Component
public class CSVWorker {
    public void writeCSV(List<List<String>> data, String fileName) throws IOException {
        CSVPrinter printer = new CSVPrinter(new FileWriter("target/" + fileName + ".csv"), CSVFormat.DEFAULT);
        data.forEach(line -> {
            try {
                printer.printRecord((Object) line);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        printer.flush();
        printer.close();
    }

    public String readCSV(String fileName) throws IOException {
        StringBuilder csv = new StringBuilder();
        CSVParser csvParser = new CSVParser(new FileReader("target/" + fileName), CSVFormat.DEFAULT);

        for (CSVRecord record : csvParser) {
            record.forEach(csv::append);
        }
        csvParser.close();
        return csv.toString().replaceAll("\\]", "\n").replaceAll("\\[", "");
    }
}

