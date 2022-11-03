package edu.upenn.cit594.logging;

import java.io.FileWriter;
import java.io.IOException;

public class Logger {
    private FileWriter out;
    private String filename;
    private Logger() {}

    private static Logger instance = new Logger();

    public static Logger getInstance() {return instance;}

    public void log (String message){
        if (getInstance()==null){
            System.out.println("ERROR No logger instance");
        }
        try{
            out = new FileWriter(filename, true);
            out.write(message+"\n");
            out.close();
        }
        catch (Exception e){
            e.getStackTrace();
        }
    }

    public void set (String filename){
        this.filename = filename;
    }
}
