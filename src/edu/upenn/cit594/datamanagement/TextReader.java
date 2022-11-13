package edu.upenn.cit594.datamanagement;
import edu.upenn.cit594.util.Tweet;
import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class TextReader extends TweetReader {
    public TextReader(String filename) {
        super(filename);
    }

    public ArrayList<Tweet> parseFile() throws Exception{
        BufferedReader reader = Files.newBufferedReader(Paths.get(filename));
        ArrayList<Tweet> tweets = new ArrayList<>();
        //loop through file and add tweets to arraylist
        while(true){
            String line = reader.readLine();
            if (line == null) break;
            String[] lineArray = line.split("\t");
            lineArray[0] = lineArray[0].replaceAll("\\[","");
            lineArray[0] = lineArray[0].replaceAll("]","");
            double Lat = Double.parseDouble(lineArray[0].split(",")[0]);
            double Lon = Double.parseDouble(lineArray[0].split(",")[1]);
            Tweet tweet = new Tweet(lineArray[3],Lat,Lon);
            tweets.add(tweet);
        }
        reader.close();
        return tweets;
    }


}
