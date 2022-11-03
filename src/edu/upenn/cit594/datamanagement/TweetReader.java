package edu.upenn.cit594.datamanagement;

import edu.upenn.cit594.util.Tweet;

import java.util.List;

public class TweetReader {
    List<Tweet> tweets;
    String filename;

    public TweetReader(String filename){
        this.filename = filename;
    }
}
