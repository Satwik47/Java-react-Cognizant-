package com.example;

import com.example.context.PaymentContext;
import com.example.strategy.CreditCardStrategy;
import com.example.strategy.PayPalStrategy;

public class Main {
    public static void main(String[] args) {
        PaymentContext context = new PaymentContext(
            new CreditCardStrategy("Alice", "1234-5678-9012-3456", "123", "12/25")
        );

        // Pay with credit card
        context.pay(100);

        // Switch strategy at runtime to PayPal
        context.setStrategy(new PayPalStrategy("alice@example.com"));
        context.pay(250);
    }
}
