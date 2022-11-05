package edu.upenn.cit594.datamanagement;

import edu.upenn.cit594.util.State;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Paths;


public class CSVReader extends StateReader {
    public CSVReader(String filename){
        super(filename);
    }

    public void parseFile() throws Exception {

        BufferedReader reader = Files.newBufferedReader(Paths.get(filename));
        while(true){
            String line = reader.readLine();
            if (line == null) break;
            String[] lineArray = line.split(",");
            State state = new State(lineArray[0],Double.parseDouble(lineArray[1]),Double.parseDouble(lineArray[2]));
//            states.add(state);
            addState(state);
        }
        reader.close();
//        for(State stateval : states){
//            System.out.println(stateval.getStateName() + ", " + stateval.getLat() + ", " + stateval.getLon());
//        }
    }


//    @Override
//    public int compare(String o1, String o2) {
//        return 0;
//    }
}
