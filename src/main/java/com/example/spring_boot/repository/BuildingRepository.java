package com.example.spring_boot.repository;

import com.example.spring_boot.repository.entity.BuildingEntity;

import java.util.ArrayList;
import java.util.List;
// interface chứa các abtract method có kiểu trả về tên hàm và có được có tham số truyền vào

public interface BuildingRepository {
    List <BuildingEntity> fillAll ();
}
