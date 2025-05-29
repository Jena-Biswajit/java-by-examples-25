package com.example.app;


// checked : compile time : compiler identifies: compliation error
// unchecked : runtime

// any exception will occur at the execution of code only

// Checked Exception

/**
 * Exception
 *     |
 * ReflectiveOPerationException
 *      |
 * ClassNotFoundExceptiom (checked exception)
 *
 *
 * handling checked excepotion alert: add throws [CheckedException] to method signature
 */
public class App3 {
  public static void main(String[] args) throws ClassNotFoundException {
    String className = "com.uuv.Student";
    Class.forName(className);// this line might cause some exception during the code execution
  }
}
