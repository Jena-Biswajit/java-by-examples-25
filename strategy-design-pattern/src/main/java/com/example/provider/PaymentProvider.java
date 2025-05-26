package com.example.provider;

import com.example.contracts.PaymentStrategy;
import com.example.models.CrediCardPayment;
import com.example.models.DebitCardPayment;

public class PaymentProvider {
    private String cardType;

    public PaymentProvider(String cardType) {
        this.cardType = cardType.toLowerCase();
    }

    public PaymentStrategy getPaymentStrategy() {
        switch (cardType) {
            case "debitcard":
                return new CrediCardPayment();
            case "creditcard":
                return new DebitCardPayment();
            default:
                throw new IllegalArgumentException("Unsupported card type: " + cardType);
        }
    }
}

