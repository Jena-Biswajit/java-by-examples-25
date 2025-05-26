package com.example.app;

import com.example.models.EagerSingleton;
import com.example.models.LazySingleton;

public class App1 {
    public static void main(String[] args) {
        LazySingleton lazySingleton = LazySingleton.getLazySingleton();
        System.out.println(lazySingleton);

        EagerSingleton eagerSingleton = EagerSingleton.getEagerSingleton();
        System.out.println(eagerSingleton);


    }
}
