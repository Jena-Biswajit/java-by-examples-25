package com.example.app;


// try / catch / finally
// try / finally
// try / catch / catch / finally
// try / catch [try / catch / finally ] / finally
public class App15 {
  public static void main(String[] args) {
    try {
      System.out.println("try-1");
      int r = 10 / 20;
      System.out.println("about to return");
      System.exit(-1); // on exit finally wont execute. process killed here.
      return; // when return encounters finally will execute
    }
//    catch (Exception e) {
//      System.out.println("catch-1");
//    }
    finally {
      System.out.println("finally-1");
    }

  }
}
