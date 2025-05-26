package com.example.models;

public class EagerSingleton {

    public static EagerSingleton eagerSingleton = new EagerSingleton();

    private EagerSingleton(){
        System.out.println("eager singleton");
    }

    public static EagerSingleton getEagerSingleton(){
        return eagerSingleton ;
    }
}
