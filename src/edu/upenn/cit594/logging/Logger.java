package edu.upenn.cit594.logging;

import java.io.FileWriter;
import java.io.IOException;

public class Logger {
    private FileWriter out;
    private String filename;
    private Logger() {}

    private static Logger instance = new Logger();

    public static Logger getInstance() {return instance;}

    public void log (String message) throws Exception{
        if (getInstance()==null){
            throw new Exception("No Logger Instance");
        }
        out = new FileWriter(filename, true);
        out.write(message+"\n");
        out.close();

    }

    public void set (String filename){
        this.filename = filename;
    }
}
