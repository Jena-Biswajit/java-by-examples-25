package com.example.app;

// 1. Introduce try / catch
// process success: exit : 0
// process fail: exit: 1
// ArithmeticException - RuntimeException - Exception - Throwable

/**
 *                        Throwable
 *                      |             |
 *                   Exception    Error
 *                    |
 *                 RuntimeException
 *                    |
 *                 ArithmeticException
 */
public class App2 {

  public static void main(String[] args) {
    int x = 10;
    int y = 0;

    int r = -1;
    try{
       r = x / y; // exception
    } catch (ArithmeticException e) {
      throw new RuntimeException(e);
    }

    System.out.println(r);
    System.out.println("program complete");
  }

}
