package com.gcs.springex.exception;

public class UserNameConflictException extends BaseException {
  public UserNameConflictException(String msg) {
    super("Username conflict");
  }
}
