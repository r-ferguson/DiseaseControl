package edu.upenn.cit594.logging;

import static org.junit.jupiter.api.Assertions.*;

class LoggerTest {

    @org.junit.jupiter.api.Test
    void getInstance() {
        Logger testLog = Logger.getInstance();
        System.out.println(testLog);
        Logger testLog2 = Logger.getInstance();
        System.out.println(testLog2);
    }

    @org.junit.jupiter.api.Test
    void log() {
        Logger testLog = Logger.getInstance();
        testLog.log("test");
    }

    @org.junit.jupiter.api.Test
    void set() {
        Logger testLog = Logger.getInstance();
        testLog.set("loggerTest.txt");
        testLog.log("test");
        testLog.log("test2");
        testLog.set("loggerTest2.txt");
        testLog.log("test3");
    }
}