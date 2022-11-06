package edu.upenn.cit594.datamanagement;
import edu.upenn.cit594.util.Tweet;
import java.util.ArrayList;

/**
 * Abstract class that is the generic form of a Tweet Reader
 * Classes that Implement this must contain a parseFile method
 * which describes how to parse the particular file passed in.
 */
public abstract class TweetReader {

    String filename;

    public TweetReader(String filename){
        this.filename = filename;
    }

    /**
     * parseFile is the specific method for how to find and store Tweets
     * in the specific filetype the subclass is implemented for.
     * @return ArrayList of Tweets that are found
     */
    public abstract ArrayList<Tweet> parseFile() throws Exception;

}
