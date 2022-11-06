package edu.upenn.cit594.datamanagement;
import edu.upenn.cit594.util.State;
import java.util.ArrayList;

/**
 * Abstract class that is the generic form of a State Reader
 * Classes that Implement this must contain a parseFile method
 * which describes how to parse the particular file passed in.
 */
public abstract class StateReader{
    String filename;

    public StateReader(String filename){
        this.filename = filename;
    }

    /**
     * parseFile is the specific method for how to find and store states
     * in the specific filetype the subclass is implemented for.
     * @return ArrayList of States that are found
     */

    public abstract ArrayList<State> parseFile() throws Exception;

}
