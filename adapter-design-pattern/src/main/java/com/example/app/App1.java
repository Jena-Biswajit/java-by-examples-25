package com.example.app;

import com.example.contracts.Iphone;
import com.example.models.AndroidCharger;
import com.example.models.ChargeAdapter;

public class App1 {
    public static void main(String[] args) {
        AndroidCharger androidCharger = new AndroidCharger();
        Iphone iphone = new ChargeAdapter(androidCharger);
        iphone.chargeWithIphone();
    }
}
