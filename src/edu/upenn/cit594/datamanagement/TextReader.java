package edu.upenn.cit594.datamanagement;
import edu.upenn.cit594.util.Tweet;
import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class TextReader extends TweetReader {

    private BufferedReader reader;
    public TextReader(String filename) {
        super(filename);
    }

    public void parseText() throws Exception{
        this.reader = Files.newBufferedReader(Paths.get(filename));
        while(true){
            String line = reader.readLine();
            if (line == null) break;
            String[] lineArray = line.split("\t");
            lineArray[0] = lineArray[0].replaceAll("\\[","");
            lineArray[0] = lineArray[0].replaceAll("]","");
            Double Lat = Double.parseDouble(lineArray[0].split(",")[0]);
            Double Lon = Double.parseDouble(lineArray[0].split(",")[1]);
            Tweet tweet = new Tweet(lineArray[3],Lat,Lon);
            tweets.add(tweet);
        }
        reader.close();
    }


}
