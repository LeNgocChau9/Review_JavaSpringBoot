package com.example.spring_boot.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BuildingDTO {
    private String name;
    private String addrress;
    private String street;
    private String ward;
    private String district;
    private Integer numberOfBasement;
}
