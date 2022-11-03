package edu.upenn.cit594.datamanagement;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CSVReaderTest {

    @Test
    void parseCSV() {
        CSVReader reader = new CSVReader("states.csv");
        try {
            reader.parseCSV();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}