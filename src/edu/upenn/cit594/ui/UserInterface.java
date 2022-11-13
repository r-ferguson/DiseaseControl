package edu.upenn.cit594.ui;

import edu.upenn.cit594.processor.Processor;

import java.util.Map;
import java.util.TreeMap;

public class UserInterface {
    protected Processor processor;

    public UserInterface(Processor processor){
        this.processor = processor;
    }

    public void start(){
        //create treemap to hold final count returned by processor
        TreeMap<String,Integer> finalCount = processor.getStateTotals();
        //loop through treemap printing the state + the entry.
        for (Map.Entry<String,Integer> entry: finalCount.entrySet()){
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
