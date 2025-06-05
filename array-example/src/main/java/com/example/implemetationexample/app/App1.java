package com.example.implemetationexample.app;

import com.example.implemetationexample.models.BinarySearch1;

public class App1 {
    public static void main(String[] args) {

        int [] arr = {-1,2,4,5,6,7};
        int target = 7 ;
        BinarySearch1 b1 = new BinarySearch1();
        int result = b1.searchTarget(arr,target);
        System.out.println("target index is: "+result);
    }
}
