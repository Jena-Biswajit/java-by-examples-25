package com.example.app;


// stack overflow error
public class App10 {
  public static void main(String[] args) {
    int result = fact(4);
    System.out.println(result);
  }

  // 4 * fact(3) | 3 * fact(2) | 2 * fact(1) | 1 * fact(0) | 0 * fact(-1)
  // 4 * fact(3) | 3 * fact(2) | 2 * fact(1) | 1 * fact(0)
  // 4 * fact(3) | 3 * fact(2) | 2 * fact(1) | 1
  // 4 * fact(3) | 3 * fact(2) | 2 * 1 | 1
  // 4 * fact(3) | 3 * 2 | 2 * 1 | 1
  // 4 * 6 | 3 * 2 | 2 * 1 | 1
  // 24 | 3 * 2 | 2 * 1 | 1
  private static int fact(int n) {
    if (n == 0) {
      return 1;
    }
    int first = n;
    int second = fact(n - 1);
    return first * second;
  }
}
