package com.example.app;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

// nested exception handling
public class App16 {
  public static void main(String[] args) {
    FileInputStream is = null;
    try {
      System.out.println("try-1");
      is = new FileInputStream("abc.txt");
    } catch (FileNotFoundException e) {
      e.printStackTrace();
      System.out.println("catch-1");
    } finally {
      try {
        System.out.println("try-2");
        is.close();
      } catch (NullPointerException e) {
        System.out.println("NPE-CATCH");
      } catch (IOException e) {
        System.out.println("cathc-2");
      } finally {
        System.out.println("finally-2");
      }
    }
  }
}
