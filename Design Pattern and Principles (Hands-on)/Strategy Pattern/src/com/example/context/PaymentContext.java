package com.example.context;

import com.example.strategy.PaymentStrategy;

public class PaymentContext {
    private PaymentStrategy strategy;

    public PaymentContext(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public void pay(int amount) {
        if (strategy == null) {
            throw new IllegalStateException("PaymentStrategy not set");
        }
        strategy.pay(amount);
    }
}
