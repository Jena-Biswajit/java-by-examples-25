package com.example.app;


// custom checked exception
// String
// String with Cause
public class App11 {
  public static void main(String[] args) throws MyCustomCheckedException {
    m1("com.uuv.Student");
    m2("com.uuv.Student");
  }

  private static void m1(String className) {

    // P -> C
    // P p = new C();

    try {
      Class.forName(className);
    } catch (ClassNotFoundException e) {
      // try / catch : ctrl alt t
      try {
        throw new MyCustomCheckedException("class loading failed", e);
      } catch (MyCustomCheckedException ex) {
        throw new RuntimeException(ex);
      }
    }
  }


  private static void m2(String className) throws MyCustomCheckedException {

    // P -> C
    // P p = new C();

    try {
      Class.forName(className);
    } catch (ClassNotFoundException e) {
      throw new MyCustomCheckedException("class loading failed", e);
    }
  }
}

