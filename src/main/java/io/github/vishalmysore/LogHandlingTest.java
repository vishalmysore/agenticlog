package io.github.vishalmysore;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogHandlingTest {

    private static final Logger logger = LoggerFactory.getLogger(LogHandlingTest.class);


    public static void main(String[] args) {
        // Send a log message that should trigger the agent
        logger.error("ERROR customer-support error, customer ID 12345, query: \"What is the status of my order?\"");
        logger.error("ERROR customer-support error, customer ID 765, query: \"I really need to talk to supervisor?\"");

    }
}
