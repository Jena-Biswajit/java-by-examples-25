package com.example.app;

public class MyCustomCheckedException extends Exception{
  public MyCustomCheckedException(String message) {
    super(message);
  }

  public MyCustomCheckedException(String message, Throwable cause) {
    super(message, cause);
  }
}
