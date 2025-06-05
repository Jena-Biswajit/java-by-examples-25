package com.example.implemetationexample.app;

import com.example.implemetationexample.models.FindMaxMin;

public class App2 {
    public static void main(String[] args) {

        int[] arr = {10,15,98,1,2};
        FindMaxMin fmm = new FindMaxMin();
        int maxResult =fmm.findMax(arr);
        System.out.println(maxResult);
        int minResult =fmm.findMinElement(arr);
        System.out.println(minResult);
    }
}
