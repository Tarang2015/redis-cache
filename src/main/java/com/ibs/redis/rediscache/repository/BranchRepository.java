package com.ibs.redis.rediscache.repository;

import com.ibs.redis.rediscache.model.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BranchRepository extends JpaRepository<Branch,Integer> {
}
