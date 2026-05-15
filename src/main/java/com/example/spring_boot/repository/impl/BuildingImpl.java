package com.example.spring_boot.repository.impl;



import com.example.spring_boot.repository.BuildingRepository;
import com.example.spring_boot.repository.entity.BuildingEntity;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
@Repository

public class BuildingImpl implements BuildingRepository {
    // kết nối jdbc my SQL
    static final String DB_URL = "jdbc:mysql://localhost:3306/estatebasic";
    static final String USER = "root";
    static final String PASS = "123456";

    // ghi đè phương thức fillAll trong interface BuildingRepository
    @Override
    public List<BuildingEntity> fillAll() {
        String sql = "SELECT * FROM building";
        List <BuildingEntity> result = new ArrayList<>();
        try(Connection conn = DriverManager.getConnection(DB_URL,USER,PASS)){
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            // lặp để lấy toàn bộ dữ liệu
            while (rs.next()){
                BuildingEntity building = new BuildingEntity();
                building.setName(rs.getString("name"));
                building.setId(rs.getLong("id"));
                building.setStreet(rs.getString("street"));
                building.setWard(rs.getString("ward"));
                building.setDistrictid(rs.getString("districtid"));
                building.setNumberofbasement(rs.getInt("numberofbasement"));
                result.add(building);
            }
        }
        catch(SQLException e){
            e.printStackTrace();
            System.out.println("Connect database failed");
        }
        return result;
    }
}
