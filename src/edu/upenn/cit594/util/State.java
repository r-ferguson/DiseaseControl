package edu.upenn.cit594.util;

public class State {
    protected String stateName;
    protected double lat;
    protected double lon;

    public State(String stateName, double lat, double lon){
        this.stateName = stateName;
        this.lat = lat;
        this.lon = lon;
    }

    public String getStateName(){
        return stateName;
    }

    public double getLat(){
        return lat;
    }

    public double getLon(){
        return lon;
    }


}
