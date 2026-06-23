package com.example;

public class PerformanceTester {
    public void performTask() {
        try {
            Thread.sleep(1000); // Simulates a task taking 1 second
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
