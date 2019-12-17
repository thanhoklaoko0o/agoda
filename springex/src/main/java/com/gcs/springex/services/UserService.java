package com.gcs.springex.services;

import com.gcs.springex.models.UserEntity;

import java.util.List;

public interface UserService {
  UserEntity create(UserEntity newUser);

  void delete(String id);

  UserEntity findById(String id);

  List<UserEntity> filter(String keyword);

  List<UserEntity> findAll();

  UserEntity findByUserName(String username);

  void update(UserEntity userEntity);
}
