package com.example.spring_boot.Controller;

import com.example.spring_boot.DTO.BuildingDTO;
import com.example.spring_boot.DTO.ErrorDTO;
import com.example.spring_boot.ExceptionCustom.ExceptionValidate;
import org.springframework.web.bind.annotation.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class BuildingAPI {
    // kết nối jdbc my SQL
    static final String DB_URL = "jdbc:mysql://localhost:3306/estatebasic";
    static final String USER = "root";
    static final String PASS = "123456";

    @GetMapping(value="/api/buildings")
    @ResponseBody
    public Object SearchBuilding(@RequestParam(value = "name") String name,
                               @RequestParam(value = "numberOfBasement",required = false) String numberOfBasement){
        com.example.spring_boot.DTO.BuildingDTO room = new com.example.spring_boot.DTO.BuildingDTO();
        room.setName(name);
        room.setAddrress(numberOfBasement);
        return room;
    }
    // cách 2 khi trường hợp quá nhiều fill để làm request params
    @GetMapping(value="/api/v1/buildings")
    @ResponseBody
    public Object SearchBuilding(@RequestParam Map<String,String> params){
        System.out.println(5/0);
        return params;
    }
    // cách 1 sài phương thức Post cách 1 sài map hoặc sài java bean mà đa số sài java bean

    @PostMapping(value="/api/room")
    @ResponseBody
    public com.example.spring_boot.DTO.BuildingDTO AddRoom(@RequestBody com.example.spring_boot.DTO.BuildingDTO Room){
        return Room;
    }
    //sài java bean để nhận dữ liệu
    //b1 tạo class javaBean
    //cách thuộc tính của javaBean luôn là private
    //phải có hàm getter và setter
    //luồng hoạt động khi gửi 1 request từ client tới bằng RequestBody thì sẽ tự map các key trùng với thuộc tính
    //bằng cách kiếm đúng cái hàm setter có trùng tên key của thuộc tính setter vào và dùng hàm getter để lấy dữ liệu ra

    //--------------- Ôn tập kiến thức try catch ---------------
    // trường hợp nếu như nghi ngờ 1 chức năng bị lỗi thì bỏ dô sử lý try catch

    @GetMapping(value = "/api/tryCatch")
    @ResponseBody
    public Object TryCatch(@RequestBody com.example.spring_boot.DTO.BuildingDTO Room ){
        try{
            System.out.println(5/1);
        }
        catch(Exception e){
            ErrorDTO ErrorDetials = new ErrorDTO();
            ErrorDetials.setError(e.getMessage());
            ArrayList<String>  Details = new ArrayList<String>();
            Details.add("lỗi chia cho 0");
            ErrorDetials.setDeatail(Details);
            return ErrorDetials;
        }
        return -1;
    }

    @PostMapping(value="/api/newhome")
    @ResponseBody
    public Object NewHome(@RequestBody com.example.spring_boot.DTO.BuildingDTO Room){
        try{
            validate(Room);
        }
        catch(ExceptionValidate e){
            ErrorDTO ErrorDetials = new ErrorDTO();
            ErrorDetials.setError(e.getMessage());
            ArrayList<String>  Details = new ArrayList<String>();
            Details.add("lỗi validate");
            ErrorDetials.setDeatail(Details);
            return ErrorDetials;
        }
        return Room;
    }
    public void validate(com.example.spring_boot.DTO.BuildingDTO Room) throws ExceptionValidate {
        if(Room.getName() == null)  {
            throw new ExceptionValidate("all attribute must not null");
        }
    }
// lấy dữ liệu jdbc cơ bản
    @GetMapping(value = "/api/building")
    public List<BuildingDTO> Building(){
        String sql = "SELECT * FROM building";
        List <BuildingDTO> result = new ArrayList<>();
        try(Connection conn = DriverManager.getConnection(DB_URL,USER,PASS)){
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            // lặp để lấy toàn bộ dữ liệu
            while (rs.next()){
                BuildingDTO building = new BuildingDTO();
                building.setName(rs.getString("name"));
                result.add(building);
            }
        }
        catch(SQLException e){
            e.printStackTrace();
            System.out.println("Connect database failed");
        }
        return result;
    }
    //try catch nhưng vẫn trả cho client biết tên lỗi và chi tiết lỗi
    //custom exception cho chính mình sài
}
