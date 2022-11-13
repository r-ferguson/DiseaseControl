package edu.upenn.cit594;
import edu.upenn.cit594.datamanagement.*;
import edu.upenn.cit594.logging.Logger;
import edu.upenn.cit594.processor.Processor;
import edu.upenn.cit594.ui.UserInterface;

public class Main {

    public static void main(String[] args){
        if (args.length<3){
            throw new RuntimeException("invalid number of args");
        }

        String tweetFilename = args[0];
        String statesFilename = args[1];
        String loggerFilename = args[2];

        Logger logger = Logger.getInstance(); //Initialize Logger Singleton
        logger.set(loggerFilename); //Set Logger Filename

        StateReader stateReader = new CSVReader(statesFilename); //Initialize stateReader

        TweetReader tweetReader;
        String[] splitName = tweetFilename.split("\\.");
        String fileType = splitName[splitName.length-1].toLowerCase(); //determine file extension by looking at end
        if (fileType.equals("txt")){
            tweetReader = new TextReader(tweetFilename); //initialize tweet reader as TextReader if txt
        } else if (fileType.equals("json")){
            tweetReader = new JSONReader(tweetFilename); //initialize tweet reader as JSONReader if json
        } else {
            throw new RuntimeException("Invalid Tweet filename"); //otherwise Throw Exception
        }

        //Try to create new processor
        Processor processor = null;
        try {
            processor = new Processor(tweetReader,stateReader);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        //create new ui with processor
        UserInterface ui = new UserInterface(processor);
        //start ui
        ui.start();
    }
}
