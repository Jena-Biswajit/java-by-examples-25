package com.example.app;

public class MyCustomRuntimeException extends RuntimeException{
  public MyCustomRuntimeException(String message) {
    super(message);
  }

  public MyCustomRuntimeException(String message, Throwable cause) {
    super(message, cause);
  }
}
