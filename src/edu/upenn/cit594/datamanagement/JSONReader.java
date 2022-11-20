package edu.upenn.cit594.datamanagement;
import edu.upenn.cit594.util.Tweet;
import org.json.simple.parser.*;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;

public class JSONReader extends TweetReader{
    public JSONReader(String filename){
        super(filename);
    }

    public ArrayList<Tweet> parseFile() throws Exception{
        ArrayList<Tweet> tweets = new ArrayList<>();
        Object obj = new JSONParser().parse(new FileReader(filename));

        JSONArray ja = (JSONArray) obj;

        Iterator itr2 = ja.iterator();

        while (itr2.hasNext()) {
            JSONObject jo = (JSONObject) itr2.next();
            JSONArray location = (JSONArray) jo.get("location");
            Tweet tweet = new Tweet((String)jo.get("text"),(double)location.get(0),(double)location.get(1));
            tweets.add(tweet);
        }
        return tweets;
    }

}
