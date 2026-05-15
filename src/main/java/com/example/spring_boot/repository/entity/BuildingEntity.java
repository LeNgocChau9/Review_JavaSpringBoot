package com.example.spring_boot.repository.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BuildingEntity {
    private Long id;
    private String name;
    private String street;
    private String ward;
    private String districtid;
    private Integer numberofbasement;
}
