package com.example.app;

// using custom runtime exception
public class App12 {
  public static void main(String[] args) {
    m1(10, 0);
  }

  private static void m1(int x, int y){
    try {
      int r = x / y;
    } catch (ArithmeticException e) {
      throw new MyCustomRuntimeException("operation division failed", e);
    }
  }
}
