package edu.upenn.cit594;

import edu.upenn.cit594.datamanagement.*;
import edu.upenn.cit594.logging.Logger;
import edu.upenn.cit594.processor.Processor;
import edu.upenn.cit594.ui.UserInterface;

import java.io.Reader;

public class Main {

    public static void main(String[] args){
        if (args.length<3){
            System.out.println("Invalid file args");
            return;
        }

        String tweetFilename = args[0];
        String statesFilename = args[1];
        String loggerFilename = args[2];

        Logger logger = Logger.getInstance();
        logger.set(loggerFilename);

        StateReader stateReader = new CSVReader(statesFilename);

        TweetReader tweetReader;
        String[] splitName = tweetFilename.split("\\.");
        String fileType = splitName[splitName.length-1].toLowerCase();
        if (fileType.equals("txt")){
            tweetReader = new TextReader(tweetFilename);
        } else if (fileType.equals("json")){
            tweetReader = new JSONReader(tweetFilename);
        } else {
            System.out.println("Invalid Arguments");
            return;
        }

        Processor processor = new Processor(tweetReader,stateReader,logger);
        UserInterface ui = new UserInterface(processor);

        ui.start();
    }
}
