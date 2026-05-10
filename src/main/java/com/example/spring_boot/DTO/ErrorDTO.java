package com.example.spring_boot.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
public class ErrorDTO {
    private String Error;
    private List<String> Deatail = new ArrayList<String>();
}
