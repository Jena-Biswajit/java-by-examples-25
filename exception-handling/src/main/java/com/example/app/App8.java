package com.example.app;


// checked : compile time : compiler identifies: compliation error
// unchecked : runtime : subclass of runtime exception

// any exception will occur at the execution of code only
// and associated with a thread.

// The runtime exception classes not detected by compiler. No alert. Compilation success.
// Any class either RuntimeException or its child.

// validating array index inputs


public class App8 {
  public static void main(String[] args) {
    int[] arr = new int[0];
    m1(arr, 0);
  }

  public static void m1(int[] arr, int index) {
    int len = arr.length;
    // max value of index = len - 1
    // min value of index = 0
    boolean validIndex = index >= 0 && index < len;
    if (!validIndex) {
      throw new IllegalArgumentException("The index is invalid for the given array: " + index);
    }
    int value = arr[index];
    double square = Math.pow(value, 2);
    System.out.println("square is : " + square);
  }
}
