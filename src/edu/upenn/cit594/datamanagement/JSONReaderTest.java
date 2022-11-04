package edu.upenn.cit594.datamanagement;

import edu.upenn.cit594.logging.Logger;
import edu.upenn.cit594.util.Tweet;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class JSONReaderTest {

    @org.junit.jupiter.api.Test
    void parse() {
        JSONReader jr = new JSONReader("flu_tweets.json");
        try {
            jr.parseFile();
            ArrayList<Tweet> storedTweets = new ArrayList<>(jr.getTweets());
            for (int i = 0; i < storedTweets.size(); i++){
                System.out.println(storedTweets.get(i).getTweetTxt());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}