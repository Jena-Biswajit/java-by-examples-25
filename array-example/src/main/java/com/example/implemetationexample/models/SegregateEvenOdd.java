package com.example.implemetationexample.models;

public class SegregateEvenOdd {
    public int [] segregateNumber(int[] array){
        int start = 0 ;
        int end = array.length-1;

        while (start<= end ){
            if(array[start]%2==0){
                start++;
            }
            else if (array[end]%2==1){
                end--;
            }
            else {
                int temp = array[start];
                array[start] = array[end];
                array[end] = temp ;
                start++ ;
                end -- ;
            }
        }
        return array ;
    }
}
