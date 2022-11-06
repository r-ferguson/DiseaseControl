package edu.upenn.cit594.datamanagement;
import edu.upenn.cit594.util.State;
import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class CSVReader extends StateReader {
    public CSVReader(String filename){
        super(filename);
    }

    public ArrayList<State> parseFile() throws Exception {
        ArrayList<State> states = new ArrayList<>();
        BufferedReader reader = Files.newBufferedReader(Paths.get(filename));
        while(true){
            String line = reader.readLine();
            if (line == null) break;
            String[] lineArray = line.split(",");
            State state = new State(lineArray[0],Double.parseDouble(lineArray[1]),Double.parseDouble(lineArray[2]));
            states.add(state);
        }
        reader.close();
        return states;
    }
}
