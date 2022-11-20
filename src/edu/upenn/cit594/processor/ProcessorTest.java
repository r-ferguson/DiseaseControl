package edu.upenn.cit594.processor;

import edu.upenn.cit594.datamanagement.CSVReader;
import edu.upenn.cit594.datamanagement.JSONReader;
import edu.upenn.cit594.logging.Logger;
import edu.upenn.cit594.util.State;
import edu.upenn.cit594.util.Tweet;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ProcessorTest {

    @Test
    void findFluTweets() {
        JSONReader jr = new JSONReader("flu_tweets2.json");
        try {
            jr.parseFile();
//            ArrayList<Tweet> storedTweets = new ArrayList<>(jr.getTweets());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        CSVReader reader = new CSVReader("states.csv");
        try {
            reader.parseFile();
//            ArrayList<State> states = reader.getStates();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Logger testLog = Logger.getInstance();
        try {
            Processor pro = new Processor(jr,reader);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
//        pro.getTweets("flu_tweets.json");
       // pro.findFluTweets();

    }
}