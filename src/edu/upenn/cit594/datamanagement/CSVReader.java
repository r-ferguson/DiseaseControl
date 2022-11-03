package edu.upenn.cit594.datamanagement;

import edu.upenn.cit594.util.State;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class CSVReader extends StateReader {
    private BufferedReader reader;
    public CSVReader(String filename){
        super(filename);
    }

    public void parseCSV() throws Exception {

        this.reader = Files.newBufferedReader(Paths.get(filename));
        while(true){
            String line = reader.readLine();
            if (line == null) break;
            String[] lineArray = line.split(",");
            Double test = Double.parseDouble(lineArray[1]);
            State state = new State(lineArray[0],Double.parseDouble(lineArray[1]),Double.parseDouble(lineArray[2]));
            states.add(state);
        }
        reader.close();
        for(State stateval : states){
            System.out.println(stateval.getStateName());
        }
    }


    @Override
    public int compare(String o1, String o2) {
        return 0;
    }
}
