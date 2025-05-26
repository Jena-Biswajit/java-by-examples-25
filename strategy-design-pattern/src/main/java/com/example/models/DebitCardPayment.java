package com.example.models;

import com.example.contracts.PaymentStrategy;

public class DebitCardPayment implements PaymentStrategy {
    public void pay(int amount) {
        System.out.println("Paid ₹" + amount + " using debit Card.");
    }
}
