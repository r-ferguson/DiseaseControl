package edu.upenn.cit594.datamanagement;

import edu.upenn.cit594.util.State;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class CSVReaderTest {

    @Test
    void parseCSV() {
        CSVReader reader = new CSVReader("states.csv");
        try {
            reader.parseCSV();
            ArrayList<State> states = reader.getStates();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}