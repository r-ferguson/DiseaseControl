package edu.upenn.cit594.datamanagement;

import edu.upenn.cit594.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

class JSONReaderTest {

    @org.junit.jupiter.api.Test
    void parse() {
        JSONReader jr = new JSONReader("flu_tweets.json");
        jr.parseFile();

    }
}