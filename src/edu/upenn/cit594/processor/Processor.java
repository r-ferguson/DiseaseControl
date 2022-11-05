package edu.upenn.cit594.processor;
import edu.upenn.cit594.datamanagement.StateReader;
import edu.upenn.cit594.datamanagement.TweetReader;
import edu.upenn.cit594.logging.Logger;
import edu.upenn.cit594.util.State;
import edu.upenn.cit594.util.Tweet;

import java.util.ArrayList;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Processor {
    protected TweetReader tweetReader;
    protected StateReader stateReader;
    protected TreeMap<String,Integer> stateTotals;
    protected ArrayList<Tweet> tweets;
    protected ArrayList<State> states;
    protected Logger logger;
    public Processor(TweetReader tweetReader, StateReader stateReader, Logger logger){
        this.tweetReader = tweetReader;
        this.stateReader = stateReader;
        this.tweets = tweetReader.getTweets();
        this.logger = logger;
    }

    public void getTweets(){

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
//        for(Tweet tweet : tweets){
//            System.out.println(tweet.getTweetTxt());
//        }
//        return tweets;
    }
    public void findFluTweets(){
        try {
            stateReader.parseFile();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        this.states = stateReader.getStates();
        stateTotals = new TreeMap<>();
        Pattern p = Pattern.compile("(?>^|\\s)[#][fF][lL][uU](?>\\Z|[^a-zA-Z])|(?>^|\\s)[fF][lL][uU](?>\\Z|[^a-zA-Z])");
        for (Tweet tweet : this.tweets){
            Matcher m = p.matcher(tweet.getTweetTxt());
            if(m.find()){
//                System.out.println(tweet.getTweetTxt());
                double long1 = tweet.getLon();
                double lat1 = tweet.getLat();
                double distance = 2000000000;
                State closestState = null;
                for (State state : this.states){
                    double distFromState = java.lang.Math.sqrt(java.lang.Math.pow((state.getLon()-long1),2) + java.lang.Math.pow((state.getLat()-lat1),2));
//                    System.out.println(state.getStateName() + " distance: " + distFromState);
//                    System.out.println(distFromState + " < " + distance);
                    if (distFromState < distance){
                        closestState = state;
                        distance = distFromState;
                    }
                }
                if (closestState == null){
                    System.out.println("Error: Closest State Not Found");
                    return;
                }
                String stateName = closestState.getStateName();
                logger.log(stateName + "\t" + tweet.getTweetTxt()); //log flu tweet with state

                if (stateTotals.get(stateName) != null){
                    stateTotals.put(stateName, stateTotals.get(stateName)+1); //increment count if it exists
                } else stateTotals.put(stateName, 1); //otherwise add state with count as 1
            }
        }


    }
    public TreeMap<String, Integer> getStateTotals(){
        return stateTotals;
    }



}
