package com.gcs.springex.models;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Builder
@Entity(name = "user")
@Table(name = "user")
public class UserEntity {

  @Id
  @Column(name = "id", length = 10)
  private String id;

  @Column(name = "username", length = 10, unique = true)
  private String username;

  @Column(name = "password", length = 50)
  private String password;

  @Column(name = "full_name", length = 50)
  private String fullName;


}
