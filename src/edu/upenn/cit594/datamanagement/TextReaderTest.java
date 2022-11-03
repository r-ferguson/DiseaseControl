package edu.upenn.cit594.datamanagement;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TextReaderTest {

    @Test
    void parseTXT() {
        TextReader reader = new TextReader("flu_tweets.txt");
        try {
            reader.parseText();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}