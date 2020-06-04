package com.ibs.redis.rediscache.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="userInfo")
@Data
public class UserInfo {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  private String username;
  private String password;
  private String fullname;

  public UserInfo(String username, String password, String fullname) {
    this.username = username;
    this.password = password;
    this.fullname = fullname;
  }
  public UserInfo(){}
}
