package edu.school21.infoweb.csv;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class CSVExecutorTest {
    List<List<String>> table;

    public void setTable(List<List<String>> table) {
        this.table = table;
    }

    @BeforeEach
    void createTable() {
        List<List<String>> table = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            List<String> innerList = new ArrayList<>();
            for (int j = i; j < 3 + i; j++) {
                innerList.add(String.valueOf(i + j));
            }
            table.add(innerList);
        }
        this.setTable(table);
    }

    @Test
    void CSVTest() throws IOException {
        CSVExecutor csvExecutor = new CSVExecutor();
        csvExecutor.writeCSV(table, "testFile");
        Assertions.assertEquals(
                csvExecutor.readCSV("testFile"),
                "0, 1, 2\n" +
                        "2, 3, 4\n" +
                        "4, 5, 6\n");
    }
}