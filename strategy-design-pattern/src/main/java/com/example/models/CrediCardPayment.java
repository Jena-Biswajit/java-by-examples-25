package com.example.models;

import com.example.contracts.PaymentStrategy;

public class CrediCardPayment implements PaymentStrategy {
    public void pay(int amount) {
        System.out.println("Paid ₹" + amount + " using Credit Card.");
    }
}