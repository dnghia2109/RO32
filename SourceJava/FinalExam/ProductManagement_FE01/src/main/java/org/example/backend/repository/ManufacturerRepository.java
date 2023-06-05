package org.example.backend.repository;

import org.example.entity.Manufacturer;
import org.example.utills.JdbcUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ManufacturerRepository {
    JdbcUtils jdbcUtils;

    public ManufacturerRepository() {
        jdbcUtils = new JdbcUtils();
    }

    // Lấy danh sách các nhà sản xuất
    public List<Manufacturer> getManufacturer(){
        try {
            List<Manufacturer> list = new ArrayList<>();
            Connection connection = jdbcUtils.connect();
            Statement st;
            String sql = " select * from ProductManagement.Manufacturer";
            st = connection.createStatement();
            ResultSet myRs =st.executeQuery(sql);
            while(myRs.next()) {
                Manufacturer m = new Manufacturer();
                m.setManufacturerId(myRs.getInt("ManufacturerId"));
                m.setManufacturerName(myRs.getString("ManufacturerName"));
                list.add(m);
            }
            jdbcUtils.disconnect();
            return list;

        }catch (Exception e) {
            e.printStackTrace();
            jdbcUtils.disconnect();
            return null;
        }
    }

    // Tìm kiếm nhà sản xuất theo id
    public Manufacturer findManufacturerById(int id) {
        try {
            Manufacturer manufacturer = new Manufacturer();
            Connection connection = jdbcUtils.connect();
            PreparedStatement preparedStatement;
            String sql = "SELECT * FROM ProductManagement.Manufacturer m WHERE m.ManufacturerId = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            ResultSet rs = preparedStatement.executeQuery();
            if (!rs.wasNull()) {
                manufacturer.setManufacturerId(rs.getInt("ManufacturerId"));
                manufacturer.setManufacturerName(rs.getString("ManufacturerName"));
            } else {
                System.out.println("Không tìm thấy nhà sản xuất có id - " + id);
            }
            jdbcUtils.disconnect();
            return manufacturer;

        } catch (SQLException e) {
            e.printStackTrace();
            jdbcUtils.disconnect();
            return null;
        }
    }
}
