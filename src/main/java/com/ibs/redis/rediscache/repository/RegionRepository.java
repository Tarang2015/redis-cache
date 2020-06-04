package com.ibs.redis.rediscache.repository;

import com.ibs.redis.rediscache.model.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegionRepository extends JpaRepository<Region,Integer> {
}
