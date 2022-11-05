package edu.upenn.cit594.ui;

import edu.upenn.cit594.processor.Processor;

public class UserInterface {
    protected Processor processor;

    public UserInterface(Processor processor){
        this.processor = processor;
    }

    public void start(){
        System.out.println("Start Process");
        processor.getTweets();
        processor.findFluTweets();
    }
}
