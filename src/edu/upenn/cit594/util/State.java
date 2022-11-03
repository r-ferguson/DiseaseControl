package edu.upenn.cit594.util;

public class State {
    protected String stateName;
    protected float lat;
    protected float lon;

    public State(String stateName, float lat, float lon){
        this.stateName = stateName;
        this.lat = lat;
        this.lon = lon;
    }

    public String getStateName(){
        return stateName;
    }

    public float getLat(){
        return lat;
    }

    public float getLon(){
        return lon;
    }

}
