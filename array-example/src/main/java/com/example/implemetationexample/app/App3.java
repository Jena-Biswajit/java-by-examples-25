package com.example.implemetationexample.app;

import com.example.implemetationexample.models.SegregateEvenOdd;

import java.util.Arrays;

public class App3 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        SegregateEvenOdd seo = new SegregateEvenOdd();
       int [] result = seo.segregateNumber(arr);
        System.out.println(Arrays.toString(result));
    }
}
