package org.example.backend.repository;

import org.example.entity.Employee;
import org.example.entity.Manager;
import org.example.entity.User;
import org.example.utills.JdbcUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    JdbcUtils jdbcUtils;

    public UserRepository() {
        jdbcUtils = new JdbcUtils();
    }

    public List<User> getUser() {
        try {
            List<User> result = new ArrayList<>();
            Connection connection = jdbcUtils.connect();
            Statement st;
            String sql = " SELECT * from Users";
            st = connection.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                if (rs.getString("Role").equalsIgnoreCase("Employee")) {
                    Employee employee = new Employee();
                    employee.setId(rs.getInt("Id"));
                    employee.setFullName(rs.getString("FullName"));
                    employee.setEmail(rs.getString("Email"));
                    employee.setPassword(rs.getString("Password"));
                    employee.setProSkill(rs.getString("Pro_skill"));
                    employee.setProjectId(rs.getInt("Project_id"));
                    result.add(employee);
                } else {
                    Manager manager = new Manager();
                    manager.setId(rs.getInt("Id"));
                    manager.setFullName(rs.getString("FullName"));
                    manager.setEmail(rs.getString("Email"));
                    manager.setPassword(rs.getString("Password"));
                    manager.setExpInYear(rs.getInt("Exp_in_year"));
                    manager.setProjectId(rs.getInt("Project_id"));
                    result.add(manager);
                }
            }
            jdbcUtils.disconnect();
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
            jdbcUtils.disconnect();
            return null;
        }
    }

    public List<User> getUserByProject (int id) {
        List<User> list = getUser();
        List<User> rs = new ArrayList<>();
        for (User user: list) {
            if (user instanceof Employee) {
                if (((Employee) user).getProjectId() == id) {
                    rs.add(user);
                }
            }
        }
        for (User user: list) {
            if (user instanceof Manager) {
                if (((Manager) user).getProjectId() == id) {
                    rs.add(user);
                }
            }
        }
        return rs;
    }

    public List<User> getManagerEachProject() {
        List<User> list = getUser();

        try {
            List<User> result = new ArrayList<>();
            Connection connection = jdbcUtils.connect();
            String sql = "SELECT *  FROM Users u where u.`Role` = 'Manager'";
            Statement st;
            st = connection.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Manager manager = new Manager();
                manager.setId(rs.getInt("Id"));
                manager.setFullName(rs.getString("FullName"));
                manager.setEmail(rs.getString("Email"));
                manager.setPassword(rs.getString("Password"));
                manager.setExpInYear(rs.getInt("Exp_in_year"));
                manager.setProjectId(rs.getInt("Project_id"));
                result.add(manager);
            }
            jdbcUtils.disconnect();
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
            jdbcUtils.disconnect();
            return null;
        }
    }

    public void login (String email, String password) {
        try {
            Connection connection = jdbcUtils.connect();
            PreparedStatement preparedStatement;
            String sql = "SELECT * FROM Users u WHERE u.Email = ? AND u.Password = ? ";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            ResultSet rs = preparedStatement.executeQuery();
            if (!rs.wasNull()) {
                System.out.println("Đăng nhập thành công");
            } else {
                System.out.println("Đăng nhập thất bại");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
