package com.example.app;


// checked : compile time : compiler identifies: compliation error
// unchecked : runtime

// any exception will occur at the execution of code only

// The exception classes not detected by compiler. No alert. Compilation success.
// Any class either RuntimeException or its child.

// validating inputs using : IllegalArgumentException


public class App7 {
  public static void main(String[] args) {
    m1(10, 0);
  }

  public static void m1(int x, int y) {
    if (y == 0) {
      throw new IllegalArgumentException("Invalid input value for y =" + y);
    }
    System.out.println(x / y);
  }
}
