package com.example.spring_boot.service.Impl;

import com.example.spring_boot.model.BuildingDTO;
import com.example.spring_boot.repository.BuildingRepository;
import com.example.spring_boot.repository.entity.BuildingEntity;
import com.example.spring_boot.repository.impl.BuildingImpl;
import com.example.spring_boot.service.BuildingService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class BuidingServiceImpl implements BuildingService {
    private BuildingRepository buildingRepository;
    @Override
    public List<BuildingDTO> findAll() {
        List <BuildingEntity> buildingEntities = buildingRepository.fillAll();
        List <BuildingDTO> result = new ArrayList<>();
        for(BuildingEntity iteam : buildingEntities){
            BuildingDTO buildingDTO = new BuildingDTO();
            buildingDTO.setName(iteam.getName());
            buildingDTO.setAddrress(iteam.getStreet()
                    + iteam.getWard()
                    + iteam.getDistrict());
            buildingDTO.setNumberOfBasement(iteam.getNumberOfBasement());
            buildingDTO.setStreet(iteam.getStreet());
            buildingDTO.setWard(iteam.getWard());
            buildingDTO.setDistrict(iteam.getDistrict());
            result.add(buildingDTO);
        }
        return result;
    }
}
