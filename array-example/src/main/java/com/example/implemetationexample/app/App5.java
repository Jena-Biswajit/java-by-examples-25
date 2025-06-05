package com.example.implemetationexample.app;

import com.example.implemetationexample.models.Solution;

public class App5 {
    public static void main(String[] args) {
        int totalVersion = 10 ;
        int firstBad = 7;
        Solution solution = new Solution(firstBad);
        int result = solution.firstBadVersion(totalVersion);
        System.out.println("first bad version is "+ result);

    }
}
