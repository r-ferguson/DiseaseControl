package edu.upenn.cit594.datamanagement;

import edu.upenn.cit594.util.State;

import java.util.Collection;
import java.util.Comparator;
import java.util.TreeSet;
import java.util.function.Function;

class Helper implements Comparator<State>{


    @Override
    public int compare(State o1, State o2) {
        return (o1.getStateName().compareTo(o2.getStateName()));
    }
}
public abstract class StateReader implements Comparator<String>{
    TreeSet<State> states;
    String filename;

    public StateReader(String filename){
        this.filename = filename;
        this.states = new TreeSet<State>(new Helper());
    }


    public void addState(State state){
        this.states.add(state);
        Comparator comp = states.comparator();
    }

    public TreeSet<State> getStates(){
        return states;
    }
}
