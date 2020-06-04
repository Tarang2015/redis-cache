package com.ibs.redis.rediscache.service;

import com.ibs.redis.rediscache.model.Branch;
import com.ibs.redis.rediscache.model.Region;
import com.ibs.redis.rediscache.repository.BranchRepository;
import com.ibs.redis.rediscache.repository.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CacheService {
  private final RegionRepository regionRepository;
  private final BranchRepository branchRepository;

  @Autowired
  public CacheService(RegionRepository regionRepository, BranchRepository branchRepository) {
    this.regionRepository = regionRepository;
    this.branchRepository = branchRepository;
  }

  public Region saveRegion(Region region){

    List<Branch> list=new ArrayList<>();
    for(Branch b: region.getBranchList()){
      list.add(b);
    }
    region.setBranchList(list);
    return regionRepository.save(region);


  }

  public List<Region> getRegion() {
    return regionRepository.findAll();
  }

  public Region getReio(Integer regionId) throws Exception {
    Region region=regionRepository.findById(regionId).orElseThrow(()->new Exception("No region Found"));

    return region;
  }

  public void delete(Integer regionId) {
    regionRepository.deleteById(regionId);
  }

  public Region update(Region region,Integer regionId) throws Exception {
return regionRepository.findById(regionId)
    .map(region1->{
      region1.setCity(region.getCity());
      region1.setPin(region.getPin());
      region1.setRegionName(region.getRegionName());
      region1.setState(region.getState());
      return regionRepository.save(region1);
    }).orElseThrow(()->new Exception("No region Found"));
  }
}
