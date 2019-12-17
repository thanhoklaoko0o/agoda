package com.gcs.springex.controllers;

import com.gcs.springex.base.ApiResult;
import com.gcs.springex.base.annotations.ApiAuthen;
import com.gcs.springex.exception.UserNameConflictException;
import com.gcs.springex.services.UserService;
import com.gcs.springex.models.UserEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RequestMapping("/users")
@RestController
public class UserController {

  @Autowired
  private UserService userService;


  @GetMapping
  @ApiAuthen(roles = {"admin", "users"},)
  public ApiResult findAll() {
    ApiResult apiResult = new ApiResult();
    apiResult.setData(userService.findAll());
    apiResult.setSuccess(true);
    return apiResult;
  }

  @GetMapping("/{id}")
  @ApiAuthen(isPublic = true, roles = {})
  public ApiResult findById(@PathVariable String id) {
    ApiResult apiResult = createResult(userService.findById(id), true);
    return apiResult;
  }

  ApiResult createResult(Object data, boolean success) {
    ApiResult apiResult = new ApiResult();
    apiResult.setData(data);
    apiResult.setSuccess(success);
    return apiResult;
  }

  @DeleteMapping("/{id}")
  public ApiResult deleteById(@PathVariable String id) {
    userService.delete(id);
    return createResult(null, true);

  }

  @PostMapping("")
  public ApiResult create(@RequestBody UserEntity newUser) {
    ApiResult apiResult = createResult(userService.create(newUser), true);
    if (userService.findByUserName(newUser.getUsername()) != null) {
      throw new UserNameConflictException();
    }

    return apiResult;
  }

  @PutMapping
  public ApiResult update(@RequestBody UserEntity newUser) {
    userService.update(newUser);
    ApiResult apiResult = createResult(newUser, true);
    return apiResult;
  }
}
