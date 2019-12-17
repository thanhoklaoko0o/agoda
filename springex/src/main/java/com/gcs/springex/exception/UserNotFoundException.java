package com.gcs.springex.exception;

public class UserNotFoundException extends BaseException {
  public UserNotFoundException() {
    super("Usernae or password invalid !");
  }
}
