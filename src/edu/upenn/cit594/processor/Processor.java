package edu.upenn.cit594.processor;

import edu.upenn.cit594.datamanagement.JSONReader;
import edu.upenn.cit594.datamanagement.StateReader;
import edu.upenn.cit594.datamanagement.TextReader;
import edu.upenn.cit594.datamanagement.TweetReader;
import edu.upenn.cit594.logging.Logger;
import edu.upenn.cit594.util.Tweet;

import java.util.LinkedList;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Processor {
    protected TweetReader tweetReader;
    protected StateReader stateReader;
    protected TreeMap<String,Integer> stateTotals;
    protected LinkedList<Tweet> tweets;
    protected Logger logger;
    public Processor(TweetReader tweetReader, StateReader stateReader, Logger logger){
        this.tweetReader = tweetReader;
        this.stateReader = stateReader;
        this.tweets = tweetReader.getTweets();
        this.logger = logger;
    }

    public LinkedList<Tweet> getTweets(){

        try {
            tweetReader.parseFile();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        this.tweets = tweetReader.getTweets();
//        if (fileType.equals("txt")){
//            this.tweetReader = new TextReader(filename);
//        } else if (fileType.equals("json")){
//            this.tweetReader = new JSONReader(filename);
//        }
        this.tweets = this.tweetReader.getTweets();
        for(Tweet tweet : tweets){
            System.out.println(tweet.getTweetTxt());
        }
        return tweets;
    }
    public void findFluTweets(){
        stateTotals = new TreeMap<String,Integer>();
        Pattern p = Pattern.compile("(?>^|\\s)[#][fF][lL][uU](?>\\Z|[^a-zA-Z])|(?>^|\\s)[fF][lL][uU](?>\\Z|[^a-zA-Z])");
        for (Tweet tweet : this.tweets){
            Matcher m = p.matcher(tweet.getTweetTxt());
            if(m.find()){
                System.out.println(tweet.getTweetTxt());
            }
        }


    }

    public TreeMap<String, Integer> getStateTotals(){
        return stateTotals;
    }



}
