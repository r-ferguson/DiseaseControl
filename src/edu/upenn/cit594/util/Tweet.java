package edu.upenn.cit594.util;

public class Tweet {
    protected String tweetTxt;
    protected double lat;
    protected double lon;

    public Tweet(String tweetTxt, double lat, double lon){
        this.tweetTxt = tweetTxt;
        this.lat = lat;
        this.lon = lon;
    }

    public String getTweetTxt(){
        return tweetTxt;
    }

    public double getLat(){
        return lat;
    }

    public double getLon(){
        return lon;
    }

}
