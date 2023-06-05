package org.example;

import org.example.backend.repository.UserRepository;
import org.example.backend.service.UserService;
import org.example.entity.*;
import org.example.utills.DataValidator;
import org.example.utills.JdbcUtils;
import org.example.utills.ScannerUntils;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
////            JdbcUtils jdbcUtils = new JdbcUtils();
//        UserRepository userRepository = new UserRepository();
// //       List<User> list = userRepository.getUser();
//
//        List<User> list = userRepository.getUserByProject(1);
//        System.out.println("- Manager:");
//        for (User user: list) {
//            if (user instanceof Manager) {
//                user.printData();
//            }
//        }
//        System.out.println("- Employee:");
//        for (User user: list) {
//            if (user instanceof Employee) {
//                user.printData();
//            }
//        }

        while (true) {
            menu();
        }
    }

    public static void menu() {
        System.out.println("======= Chức năng =======");
        System.out.println("1. Hiển thị các employee trong project theo id");
        System.out.println("2. lấy ra tất cả Manager của các project");
        System.out.println("3. Login vào Manager");
        System.out.println("4. Thoát");

        Scanner sc = new Scanner(System.in);
        int choose = Integer.parseInt(sc.nextLine());
        switch (choose) {
            case 1: {
                UserService userService = new UserService();
                Scanner s = new Scanner(System.in);
                System.out.println("nhap vao id nha san xuat: ");

                int id = ScannerUntils.inputInt(s, "Nhap vao int");
                List<User> list = userService.getUserByProject(id);
                System.out.println("- Employee:");
                for (User user : list) {
                    if (user instanceof Employee) {
                        user.printData();
                    }
                }
                break;
            }
            case 2: {
                UserService userService = new UserService();
                List<User> list = userService.getManagerEachProject();
                for (User user: list) {
                    user.printData();
                }
                break;
            }
            case 3: {
                UserService userService = new UserService();
                DataValidator datavalidator = new DataValidator();
                Scanner s = new Scanner(System.in);
                System.out.println("Mời bạn nhập email");
                String email = ScannerUntils.inputString(sc, "Giá trị nhập vào phải là một chuỗi!");
                if (datavalidator.validateEmail(email)) {
                    System.out.println(email + " là email hợp lệ");
                } else {
                    System.out.println(email + " là email không hợp lệ");
                }
                System.out.println("Mời bạn nhập password");
                String password = ScannerUntils.inputString(sc, "Giá trị nhập vào phải là một chuỗi!");
                if (datavalidator.validatePass(password)) {
                    System.out.println(password + " là password hợp lệ");
                } else {
                    System.out.println(password + " là password không hợp lệ");
                }
                userService.login(email, password);
                break;
            }
            case 4:
                System.exit(0);
                break;
            default:
                System.out.println("Chọn từ 1-4");
        }
    }
}
