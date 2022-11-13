package edu.upenn.cit594.logging;

import static org.junit.jupiter.api.Assertions.*;

class LoggerTest {

    @org.junit.jupiter.api.Test
    void getInstance() {
        Logger testLog = Logger.getInstance();
        System.out.println(testLog);
        Logger testLog2 = Logger.getInstance();
        System.out.println(testLog2);
        assertEquals(testLog,testLog2);
    }

    @org.junit.jupiter.api.Test
    void log() {
        Logger testLog = Logger.getInstance();
        try {
            testLog.log("test");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @org.junit.jupiter.api.Test
    void set() {
        Logger testLog = Logger.getInstance();
        testLog.set("loggerTest.txt");
        try {
            testLog.log("test");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        try {
            testLog.log("test2");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        testLog.set("loggerTest2.txt");
        try {
            testLog.log("test3");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}