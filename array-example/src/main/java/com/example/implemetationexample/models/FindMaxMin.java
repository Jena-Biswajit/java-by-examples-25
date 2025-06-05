package com.example.implemetationexample.models;

public class FindMaxMin {
    public int findMax(int []array){

        int len = array.length-1;
        int max = array[0];
        for (int i =1 ; i<len ; i++){
            if (max>array[i]){
                max = array[i];
                return max ;
            }
        }
        return -1 ;
    }

    public int findMinElement(int []array){
        int len = array.length-1;
        int min = array[0];
        for (int i = 1 ; i<len ;i++){
            if (min < array[i]){
                min = array[i];
                return min;
            }
        }
        return -1;
    }
}
