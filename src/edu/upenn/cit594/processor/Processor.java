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
    public Processor(TweetReader tweetReader, StateReader stateReader) throws Exception{
        this.tweetReader = tweetReader;
        this.stateReader = stateReader;
        this.logger = Logger.getInstance();
        this.stateTotals = new TreeMap<>();
        this.tweets = tweetReader.parseFile();
        this.states = stateReader.parseFile();
        findFluTweets();
    }


    private void findFluTweets() throws Exception {
        //Start with space or beginning of line followed by # f or F l or L u or U and is followed by end of line or isn't followed by a character
        // OR starts with beginning of line and same as above except without the #
        Pattern p = Pattern.compile("(?>^|\\s)[#][fF][lL][uU](?>\\Z|[^a-zA-Z])|(?>^|\\s)[fF][lL][uU](?>\\Z|[^a-zA-Z])");


        for (Tweet tweet : this.tweets){
            Matcher m = p.matcher(tweet.getTweetTxt());
            //check if tweet matches regex
            if(m.find()){
                double long1 = tweet.getLon();
                double lat1 = tweet.getLat();
                double distance = 2000000000;
                State closestState = null;

                //find closest state
                for (State state : this.states){
                    double distFromState = java.lang.Math.sqrt(java.lang.Math.pow((state.getLon()-long1),2) + java.lang.Math.pow((state.getLat()-lat1),2));
                    if (distFromState <= distance){
                        closestState = state;
                        distance = distFromState;
                    }
                }
                //if closest state not found throw exception
                if (closestState == null){
                    throw new RuntimeException("Closest State Not Found");
                }
                String stateName = closestState.getStateName();
                logger.log(stateName + "\t" + tweet.getTweetTxt()); //log flu tweet with state

                //update count for state
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
