package com.gcs.springex.exception;

import com.gcs.springex.base.ApiResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

  @ResponseBody
  @ExceptionHandler(value = Exception.class)
  public ApiResult exceptionHandle(HttpServletRequest request, Exception ex) {
    ApiResult result = new ApiResult();
    result.setSuccess(false);
    result.setMessage(ex.getMessage());
    return result;
  }

  @ResponseBody
  @ExceptionHandler(value = BaseException.class)
  public ApiResult exceptionHandle(HttpServletRequest request, BaseException ex) {
    ApiResult result = new ApiResult();
    result.setSuccess(false);
    result.setMessage(ex.getMessage());
    return result;
  }
}
