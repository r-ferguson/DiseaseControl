package edu.upenn.cit594.util;

public class Tweet {
    protected String tweetTxt;
    protected float lat;
    protected float lon;

    public Tweet(String tweetTxt, float lat, float lon){
        this.tweetTxt = tweetTxt;
        this.lat = lat;
        this.lon = lon;
    }

    public String getStateName(){
        return tweetTxt;
    }

    public float getLat(){
        return lat;
    }

    public float getLon(){
        return lon;
    }

}
