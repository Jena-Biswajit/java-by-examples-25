package com.example.app;


// stack overflow error
public class App9 {
  public static void main(String[] args) {
    m1();
  }

  private static void m1(){
    try {
      m1();
    } catch (Error e) {
      // better not to catch Errors.
     // throw new RuntimeException(e);
    }
  }
}
