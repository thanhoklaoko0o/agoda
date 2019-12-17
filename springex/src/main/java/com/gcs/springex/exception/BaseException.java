package com.gcs.springex.exception;

import lombok.Getter;

@Getter
public abstract class BaseException extends RuntimeException {
  private String message;

  public BaseException(String msg) {
    super(msg);
  }
}
