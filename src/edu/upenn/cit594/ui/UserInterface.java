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
//        processor.getTweets();
//        processor.getStates();
//        processor.findFluTweets();
        TreeMap<String,Integer> finalCount = processor.getStateTotals();
        for (Map.Entry<String,Integer> entry: finalCount.entrySet()){
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
