package com.ibs.redis.rediscache.repository;

import com.ibs.redis.rediscache.model.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInfoRepository extends JpaRepository<UserInfo,Integer> {
  Boolean existsByUsername(String username);
  UserInfo findByUsername(String username);
}
