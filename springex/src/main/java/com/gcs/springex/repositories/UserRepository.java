package com.gcs.springex.repositories;

import com.gcs.springex.models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {

  @Query("SELECT e FROM user where e")
  List<UserEntity> filter(Integer x);
}
