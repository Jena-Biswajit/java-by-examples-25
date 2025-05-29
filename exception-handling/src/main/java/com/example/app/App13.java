package com.example.app;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

// multi level try / catch
public class App13 {
  public static void main(String[] args) {
    m1();
  }

  private static void m1() {
    try {
      int r = 10 / 5;
      System.out.println("evaluated expression");
      System.out.println("file reading start");

      File f = new File("abc.txt");
      FileInputStream inputStream = new FileInputStream(f);
      System.out.println("file reading complete");
    }
    catch (ArithmeticException e) {
      e.printStackTrace();
      // throw new RuntimeException(e);
      System.out.println("AE occured");
    } catch (FileNotFoundException e) {
      e.printStackTrace();
      //  throw new RuntimeException(e);
      System.out.println("FNFE occured");
    }
  }
}
