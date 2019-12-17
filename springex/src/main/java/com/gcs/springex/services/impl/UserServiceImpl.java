package com.gcs.springex.services.impl;

import com.gcs.springex.models.UserEntity;
import com.gcs.springex.repositories.UserRepository;
import com.gcs.springex.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
  @Autowired
  private UserRepository userRepository;

  @Override
  public List<UserEntity> filter(String keyword) {
    return userRepository.filter();
  }

  @Override
  public List<UserEntity> findAll() {
    return userRepository.findAll();
  }

  public void deleteById(String id) {
    this.userRepository.deleteById(id);
  }


  @Override
  public UserEntity create(UserEntity newUser) {
    return userRepository.save(newUser);
  }

  @Override
  public void delete(String id) {
    userRepository.deleteById(id);
  }

  @Override
  public UserEntity findById(String id) {
    return userRepository.findById(id).orElse(null);
  }

  @Override
  public void update(UserEntity newUser) {
    userRepository.save(newUser);
  }
}
