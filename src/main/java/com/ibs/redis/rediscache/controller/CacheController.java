package com.ibs.redis.rediscache.controller;

import com.ibs.redis.rediscache.model.Region;
import com.ibs.redis.rediscache.service.CacheService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class CacheController {

  private final CacheService cacheService;

  public CacheController(CacheService cacheService) {
    this.cacheService = cacheService;
  }
  @PostMapping("/save")
  public Region saveRegion(@RequestBody Region region){
    System.out.println("post method called");
    return cacheService.saveRegion(region);
  }
  @GetMapping("/get")
  public List<Region> getRegion(){
    System.out.println("get  method called");

    return cacheService.getRegion();
  }
  @Cacheable(value = "region",key = "#regionId")
  @GetMapping("/get/{regionId}")
  public Region getRegio(@PathVariable Integer regionId) throws Exception {
    System.out.println("get one  method called");
    return cacheService.getReio(regionId);
  }
  @CacheEvict(value = "region", key="#regionId")
  @DeleteMapping("remove/{regionId}")
  public void delete(@PathVariable Integer regionId){
    System.out.println("delete one  method called");
    cacheService.delete(regionId);
  }

  @PutMapping("/update/{regionId}")
  public Region update(@PathVariable Integer regionId,@RequestBody Region region) throws Exception {
    System.out.println("delete one  method called");
    return cacheService.update(region,regionId);
  }

}
