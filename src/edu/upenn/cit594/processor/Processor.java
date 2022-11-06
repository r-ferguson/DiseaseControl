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
    protected Logger logger;

    protected ArrayList<Tweet> tweets;
    protected ArrayList<State> states;
    public Processor(TweetReader tweetReader, StateReader stateReader, Logger logger){
        this.tweetReader = tweetReader;
        this.stateReader = stateReader;
        this.logger = logger;
        this.stateTotals = new TreeMap<>();
        try {
            this.tweets = tweetReader.parseFile();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        try {
            this.states = stateReader.parseFile();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        findFluTweets();
    }


    private void findFluTweets(){

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
                    if (distFromState <= distance){
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
//                stateTotals.merge(stateName,1, (prev,one)->prev+1); //interesting equivalent
            }
        }



    }
    public TreeMap<String, Integer> getStateTotals(){
        return stateTotals;
    }



}
