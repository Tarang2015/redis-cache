package com.ibs.redis.rediscache.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "branch")
@Data
public class Branch implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "branchId")
  private Integer branchId;
  private String branchName;
  private String city;
  private String state;
  private Integer pin;
/*  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "REGION_ID")
  private Region region;*/

}
