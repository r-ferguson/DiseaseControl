package edu.upenn.cit594.datamanagement;

import edu.upenn.cit594.util.Tweet;

import java.util.LinkedList;
import java.util.List;

public abstract class TweetReader {
    LinkedList<Tweet> tweets;
    String filename;

    public TweetReader(String filename){
        this.filename = filename;
        this.tweets = new LinkedList<>();
    }

    public void addTweet(Tweet tweet){
        this.tweets.add(tweet);
    }

    public LinkedList<Tweet> getTweets(){
        return tweets;
    }
}
