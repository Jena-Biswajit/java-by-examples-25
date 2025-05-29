package com.example.app;

// 1. Exception basics
// process success: exit : 0
// process fail: exit: 1
public class App1 {

  public static void main(String[] args) {
   m1();
  }

  public static void m1(){
    int x = 10;
    int y = 0;

    int r = x / y; // exception
    System.out.println(r);
    System.out.println("program complete");
  }

}
