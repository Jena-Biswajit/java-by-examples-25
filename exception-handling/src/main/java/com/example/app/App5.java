package com.example.app;


// checked : compile time : compiler identifies: compliation error
// unchecked : runtime

// any exception will occur at the execution of code only

// Checked Exception

/**
 * Exception
 * |
 * ReflectiveOPerationException
 * |
 * ClassNotFoundExceptiom (checked exception)
 * <p>
 * <p>
 * handling checked exception alert by compiler: using try / catch
 */
public class App5 {
  public static void main(String[] args) {
    String className = "java.lang.String";
    try {
      Class.forName(className);// this line might cause some exception during the code execution
    } catch (ClassNotFoundException e) {
      throw new RuntimeException(e);
    }
  }
}
