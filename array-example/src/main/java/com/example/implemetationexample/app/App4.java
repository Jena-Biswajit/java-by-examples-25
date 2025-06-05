package com.example.implemetationexample.app;

import com.example.implemetationexample.models.BinarySearch2;

import java.util.Arrays;

public class App4 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,5,5,6,7};
        int target = 5 ;
        BinarySearch2 binarySearch2 = new BinarySearch2();
        int [] result = binarySearch2.findFirstAndLatOccurrence(arr,target);
        System.out.println(Arrays.toString(result));
    }
}
