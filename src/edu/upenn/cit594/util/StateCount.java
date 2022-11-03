package edu.upenn.cit594.util;

public class StateCount {
    protected String stateName;
    protected int count;

    public StateCount(String stateName, int count){
        this.stateName = stateName;
        this.count = count;
    }

    public String getStateName(){
        return stateName;
    }
    public int getCount() {
        return count;
    }
}
