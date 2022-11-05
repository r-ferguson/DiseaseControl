package edu.upenn.cit594.datamanagement;

import edu.upenn.cit594.util.Tweet;

import java.util.ArrayList;


public abstract class TweetReader {

    ArrayList<Tweet> tweets;
    String filename;

    public TweetReader(String filename){
        this.filename = filename;
        this.tweets = new ArrayList<>();
    }
    public abstract void parseFile() throws Exception;
    public void addTweet(Tweet tweet){
        this.tweets.add(tweet);
    }

    public ArrayList<Tweet> getTweets(){
        return tweets;
    }
}
