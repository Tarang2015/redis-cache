package com.ibs.redis.rediscache.controller;

import com.ibs.redis.rediscache.model.UserInfo;
import com.ibs.redis.rediscache.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.NoSuchAlgorithmException;

@RestController
public class UserController {

private final UserInfoRepository userInfoRepository;

@Autowired
  public UserController(UserInfoRepository userInfoRepository) {
    this.userInfoRepository = userInfoRepository;
  }

  @PostMapping("/user")
  public Boolean create(@RequestBody UserInfo userInfo) throws NoSuchAlgorithmException {
    String username = userInfo.getUsername();
    userInfoRepository.existsByUsername(username);

    String password = userInfo.getPassword();
    String encodedPassword = new BCryptPasswordEncoder().encode(password);
//        String hashedPassword = hashData.get_SHA_512_SecurePassword(password);
    String fullname = userInfo.getFullname();
    userInfoRepository.save(new UserInfo(username, encodedPassword, fullname));
    return true;
  }
}
