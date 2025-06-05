package com.example.implemetationexample.models;


class VersionControl{
    protected int badVersion ;
    public VersionControl(int badVersion){
        this.badVersion = badVersion ;
    }

    public boolean isBadVersion(int version){
        return version >= badVersion;
    }
}

public class Solution extends VersionControl {
    public Solution(int badVersion) {
        super(badVersion);
    }
    public int firstBadVersion(int n){
        int start = 1;
        int end = n;

        while (start<end){
            int mid = (start+end)/2 ;
            if (isBadVersion(mid)){
                end = mid ;
            }else {
                start = mid+1 ;
            }
        }
        return start;
    }
}
