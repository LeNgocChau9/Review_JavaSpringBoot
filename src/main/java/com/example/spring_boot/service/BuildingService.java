package com.example.spring_boot.service;

import com.example.spring_boot.model.BuildingDTO;

import java.util.List;

public interface BuildingService {
    List<BuildingDTO> findAll();
}
