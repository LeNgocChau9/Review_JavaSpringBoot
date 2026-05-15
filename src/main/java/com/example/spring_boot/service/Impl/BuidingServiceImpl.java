package com.example.spring_boot.service.Impl;

import com.example.spring_boot.model.BuildingDTO;
import com.example.spring_boot.repository.BuildingRepository;
import com.example.spring_boot.repository.entity.BuildingEntity;
import com.example.spring_boot.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class BuidingServiceImpl implements BuildingService {
    @Autowired
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
                    + iteam.getDistrictid());
            buildingDTO.setNumberofbasement(iteam.getNumberofbasement());
            buildingDTO.setStreet(iteam.getStreet());
            buildingDTO.setWard(iteam.getWard());
            buildingDTO.setDistrictid(iteam.getDistrictid());
            result.add(buildingDTO);
        }
        return result;
    }
}
