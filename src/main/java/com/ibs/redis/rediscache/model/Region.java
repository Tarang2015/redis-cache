package com.ibs.redis.rediscache.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="region")
@Data
public class Region implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="regionId")
  private Integer regionId;
  private String regionName;
  private String city;
  private String state;
  private  Integer pin;
  @OneToMany(targetEntity = Branch.class,cascade = CascadeType.ALL,fetch = FetchType.EAGER)
  @JoinColumn(name="region_Id",referencedColumnName = "regionId")

  private List<Branch> branchList;

}
