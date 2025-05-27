package com.example.superexample.models;

public class Mercedies extends Car{
    public void carDetails(){
//        System.out.println(super.gear);
//        System.out.println(super.colour);
    }

    @Override
    public String toString() {
        return "Mercedies{" +
                "gear=" + super.gear +
//                "tyre"+ super.tyre +
                ", colour='" + super.colour + '\'' +
                '}';
    }
}
