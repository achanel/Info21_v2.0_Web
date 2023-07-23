package edu.school21.infoweb.csvRW;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSVWorker {
    public static void writeCSV(List<List<String>> data, String fileName) throws IOException {
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

    public static List<List<String>> readCSV(String fileName) throws IOException {
        List<List<String>> csv = new ArrayList<>();
        List<String> tmp = new ArrayList<>();
        CSVParser csvParser = new CSVParser(new FileReader(fileName), CSVFormat.DEFAULT);

        for (CSVRecord record : csvParser) {
            record.forEach(tmp::add);
            List<String> innerList = new ArrayList<>(tmp);
            csv.add(innerList);
            tmp.clear();
        }
        csvParser.close();
        return csv;
    }
}

