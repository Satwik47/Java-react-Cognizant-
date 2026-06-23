package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ParameterizedLoggingExample {
    private static final Logger logger =
            LoggerFactory.getLogger(ParameterizedLoggingExample.class);

    public static void main(String[] args) {
        String username = "Satwik";
        int age = 21;
        double salary = 50000.75;

        logger.info("User {} has logged in.", username);
        logger.info("User {} is {} years old.", username, age);
        logger.info("User {} earns a salary of {}.", username, salary);
    }
}
