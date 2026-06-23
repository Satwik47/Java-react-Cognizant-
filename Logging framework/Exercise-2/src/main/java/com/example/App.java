package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {
    private static final Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        String user = "alice";
        String ip = "192.168.1.100";

        logger.info("User {} logged in from {}", user, ip);
        logger.debug("Processing request id={} and retry={}.", 42, true);
        logger.warn("Low disk space: {}% remaining", 5);

        try {
            throw new IllegalStateException("simulated error");
        } catch (Exception e) {
            logger.error("An exception occurred while processing user {}", user, e);
        }
    }
}
